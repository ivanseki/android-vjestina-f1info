package com.example.android_vjestina_f1info.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteTeams")
data class DbFavoriteTeam(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "logo_url")
    val logoUrl: String?
)