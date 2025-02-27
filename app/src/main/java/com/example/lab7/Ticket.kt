package com.example.lab7

import java.util.Date
import java.util.UUID
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.lab7.database.TicketTypeConverter

@TypeConverters(TicketTypeConverter::class) // Ensure TypeConverter is used
@Entity
data class Ticket(
    @PrimaryKey val id: String = java.util.UUID.randomUUID().toString(),
    val title: String,
    val date: Long,
    val isSolved: Boolean
)