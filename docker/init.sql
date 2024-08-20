CREATE TABLE IF NOT EXISTS address
(
    id       bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    city     varchar(255) NOT NULL,
    street   varchar(255) NOT NULL,
    number   varchar(255),
    court_id bigint UNIQUE,
    UNIQUE (city, street, number)
);

DO
$$
    BEGIN
        CREATE TYPE surface_type AS enum ('asphalt', 'rubber_crumb', 'concrete', 'rubber');
    EXCEPTION
        WHEN DUPLICATE_OBJECT THEN
            RAISE NOTICE 'surface_type exists, skipping...';
    END
$$;


CREATE TABLE IF NOT EXISTS court
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    count_rims smallint,
    height     smallint,
    surface    surface_type NOT NULL,
    address_id bigint UNIQUE REFERENCES address (id) ON DELETE CASCADE
);

ALTER TABLE IF EXISTS address
    ADD FOREIGN KEY (court_id) REFERENCES court (id) ON DELETE CASCADE;

CREATE TABLE IF NOT EXISTS court_name
(
    id         bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    court_id   bigint REFERENCES court (id),
    court_name varchar(255) NOT NULL
);

DO
$$
    BEGIN
        CREATE TYPE role AS enum ('admin', 'user');
    EXCEPTION
        WHEN DUPLICATE_OBJECT THEN
            RAISE NOTICE 'role exists, skipping...';
    END
$$;

CREATE TABLE IF NOT EXISTS users
(
    id            bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    email         varchar(255) UNIQUE,
    name      varchar(30) NOT NULL UNIQUE,
    password      varchar(255) NOT NULL,
    role          role         NOT NULL,
    register_date timestamp DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS court_review
(
    id                 bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    surface            smallint NOT NULL CHECK (surface BETWEEN 1 AND 5),
    hoop               smallint NOT NULL CHECK (hoop BETWEEN 1 AND 5),
    overall_impression smallint NOT NULL CHECK (overall_impression BETWEEN 1 AND 5),
    review             varchar(255),
    user_id            bigint   NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    court_id           bigint   NOT NULL REFERENCES court (id) ON DELETE CASCADE,
    UNIQUE (user_id, court_id)
);

CREATE TABLE IF NOT EXISTS visit
(
    id      bigint PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    date    date NOT NULL ,
    time    time not NULL ,
    user_id bigint NOT NULL REFERENCES users (id) ON DELETE CASCADE,
    court_id bigint not null REFERENCES court (id) on DELETE CASCADE,
    UNIQUE (date, time, user_id)
);

CREATE CAST (varchar AS surface_type) WITH INOUT AS ASSIGNMENT;
CREATE CAST (varchar AS role) WITH INOUT AS ASSIGNMENT;
