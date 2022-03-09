package com.hugorafaelcosta.roomdatabaseapp.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String
) {
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0
}