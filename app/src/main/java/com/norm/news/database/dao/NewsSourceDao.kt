package com.norm.news.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.norm.news.database.entity.SourceEntity

/**
 * Created by KZYT on 16/01/2020.
 */
@Dao
interface NewsSourceDao {

  @Insert
  fun insert(source: SourceEntity)

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(sources: List<SourceEntity>)

  @Update
  fun update(source: SourceEntity)

  @Query("SELECT * from news_source_table WHERE id = :id")
  fun get(id: String): SourceEntity?

  @Query("DELETE FROM news_source_table")
  fun clear()

  @Query("SELECT * FROM news_source_table ORDER BY id DESC LIMIT 1")
  fun getSource(): SourceEntity?

  @Query("SELECT * FROM news_source_table ORDER BY id")
  fun getAllSources(): LiveData<List<SourceEntity>>

  @Query("SELECT * FROM news_source_table WHERE name LIKE '%' || :q || '%'")
  fun searchSource(q: String): LiveData<List<SourceEntity>>
}