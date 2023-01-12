package com.example.android_vjestina_f1info.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteTeamDao {
    @Query("SELECT * FROM favoriteTeams")
    fun getfavorites(): Flow<List<DbFavoriteTeam>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favoriteTeam: DbFavoriteTeam)

    @Query("DELETE FROM favoriteTeams WHERE id = :teamId")
    fun deleteFavorite(teamId: Int)
}