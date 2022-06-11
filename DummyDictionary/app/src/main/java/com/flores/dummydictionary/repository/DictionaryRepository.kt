package com.flores.dummydictionary.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flores.dummydictionary.data.model.*
import com.flores.dummydictionary.network.ApiResponse
import com.flores.dummydictionary.network.WordService
import retrofit2.HttpException
import java.io.IOException

class DictionaryRepository(
    database: DummyDictionaryDatabase,
    private val api: WordService,
) {
    private val wordDoa = database.wordDao()

    suspend fun getAllWords(): ApiResponse<LiveData<List<Word>>> {
        // Try to get words from api
        return try {
            val response = api.getAllWord()
            // Use database as cache
            if (response.count > 0) {
                wordDoa.insertWord(response.words)
            }
            ApiResponse.Success(data = wordDoa.getAllWords())
        } catch (e: HttpException) {
            //handles exception with the request
            ApiResponse.Error(exception = e)
        } catch (e: IOException) {
            //handles no internet exception
            ApiResponse.Error(exception = e)
        }
    }

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }
}

