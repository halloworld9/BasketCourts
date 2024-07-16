CREATE TYPE "surface_type" AS ENUM (
  'rubber',
  'asphalt',
  'concrete',
  'rubber_crumb'
);

CREATE TYPE "role" AS ENUM (
  'admin',
  'user'
);

CREATE TABLE "court_rating" (
  "id" integer PRIMARY KEY,
  "surface" integer,
  "hoop" integer,
  "overall_impression" integer,
  "court_id" integer,
  "user_id" integer,
  "review" text
);

CREATE TABLE "player_rating" (
  "id" integer PRIMARY KEY,
  "social" int,
  "skill" int,
  "who" int,
  "by" int
);

CREATE TABLE "user" (
  "id" integer PRIMARY KEY,
  "username" varchar UNIQUE,
  "email" varchar UNIQUE,
  "password" varchar,
  "role" role,
  "register_date" timestamp,
  "about" text
);

CREATE TABLE "court" (
  "id" integer PRIMARY KEY,
  "surface_type" surface_type,
  "address_id" integer,
  "height" integer
);

CREATE TABLE "address" (
  "id" integer PRIMARY KEY,
  "city" varchar,
  "street" varchar,
  "number" varchar
);

CREATE TABLE "socials" (
  "id" integer PRIMARY KEY,
  "title" varchar,
  "url" varchar,
  "user_id" integer
);

CREATE UNIQUE INDEX ON "player_rating" ("who", "by");

CREATE UNIQUE INDEX ON "address" ("city", "street", "number");

ALTER TABLE "court_rating" ADD FOREIGN KEY ("court_id") REFERENCES "court" ("id");

ALTER TABLE "court_rating" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");

ALTER TABLE "player_rating" ADD FOREIGN KEY ("who") REFERENCES "user" ("id");

ALTER TABLE "player_rating" ADD FOREIGN KEY ("by") REFERENCES "user" ("id");

ALTER TABLE "court" ADD FOREIGN KEY ("address_id") REFERENCES "address" ("id");

ALTER TABLE "socials" ADD FOREIGN KEY ("user_id") REFERENCES "user" ("id");
