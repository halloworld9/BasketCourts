package halloworld.AuthServer.config

import halloworld.AuthServer.entity.Role
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.util.*

@Converter(autoApply = true)
class RoleConverter : AttributeConverter<Role, String> {
    override fun convertToDatabaseColumn(role: Role): String {
        return role.name.lowercase(Locale.getDefault())
    }

    override fun convertToEntityAttribute(roleName : String): Role {
        return Role.valueOf(roleName.uppercase(Locale.getDefault()))
    }
}