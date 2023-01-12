package com.example.android_vjestina_f1info.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface IFavoriteTeamDao {
    @Query("SELECT * FROM favoriteTeams")
    fun getFavorites(): Flow<List<DbFavoriteTeam>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favoriteTeam: DbFavoriteTeam)

    @Query("DELETE FROM favoriteTeams WHERE id = :teamId")
    fun deleteFavorite(teamId: Int)
}