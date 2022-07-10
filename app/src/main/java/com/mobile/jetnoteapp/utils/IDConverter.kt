package com.mobile.jetnoteapp.utils

import androidx.room.TypeConverter
import java.util.*

class IDConverter {

    @TypeConverter
    fun uuidFromString(uuid: String): UUID {
        return UUID.fromString(uuid)
    }

    @TypeConverter
    fun stringFromUUID(uuid: UUID): String {
        return uuid.toString()
    }
}