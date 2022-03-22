package com.carmedia2p0.capture.data.db

import androidx.room.TypeConverter
import com.carmedia2p0.capture.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}
