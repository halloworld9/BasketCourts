package halloworld.Courts.config

import halloworld.Courts.entity.enums.SurfaceType
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter
import java.util.*

@Converter(autoApply = true)
class SurfaceTypeConverter : AttributeConverter<SurfaceType, String> {
    override fun convertToDatabaseColumn(surfaceType: SurfaceType): String {
        return surfaceType.toString().lowercase(Locale.getDefault())
    }

    override fun convertToEntityAttribute(surfaceType: String): SurfaceType {
        return SurfaceType.valueOf(surfaceType.uppercase(Locale.getDefault()))
    }

}