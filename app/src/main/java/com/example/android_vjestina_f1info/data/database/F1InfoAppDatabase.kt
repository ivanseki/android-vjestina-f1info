package com.example.android_vjestina_f1info.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DbFavoriteTeam::class], version = 1)
abstract class F1InfoAppDatabase : RoomDatabase() {
    abstract fun favoriteTeamDao(): IFavoriteTeamDao
}