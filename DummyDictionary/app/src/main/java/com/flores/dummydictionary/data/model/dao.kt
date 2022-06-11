package com.flores.dummydictionary.data.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {

    @Query("SELECT * FROM  word_table")
    fun getAllWords(): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)
}

@Dao
interface SynonymDao {

    @Query("SELECT w.term, w.definition, w.is_fav FROM synonym_table as st INNER JOIN word_table as w ON w.term == st.synonym_term WHERE st.term = :term")
    fun getAllSynonym(term: String): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Synonym)

    @Update
    suspend fun updateWord(word: Synonym)

    @Delete
    suspend fun deleteWord(word: Synonym)
}

@Dao
interface AntonymDao {

    @Query("SELECT w.term, w.definition, w.is_fav FROM antonym_table as at INNER JOIN word_table as w ON w.term == at.antonym_term WHERE at.term = :term")
    fun getAllAntonym(term: String): LiveData<List<Word>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Antonym)

    @Update
    suspend fun updateWord(word: Antonym)

    @Delete
    suspend fun deleteWord(word: Antonym)
}