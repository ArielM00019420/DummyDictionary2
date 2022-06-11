package com.flores.dummydictionary

import androidx.lifecycle.LiveData
import com.flores.dummydictionary.data.model.Word
import java.lang.Exception

sealed class WordUiState() {
    object Loading: WordUiState()
    class Error(val exception: Exception) : WordUiState()
    data class Success(val word: LiveData<List<Word>>) : WordUiState()
}