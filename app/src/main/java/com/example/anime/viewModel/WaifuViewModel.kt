package com.example.anime.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anime.model.AngryWaifu
import com.example.anime.repository.Repository
import kotlinx.coroutines.launch

class WaifuViewModel : ViewModel() {
    private val repository = Repository()

    private val _angryWaifu = MutableLiveData<String>()
    val angryWaifu : LiveData<String> get() = _angryWaifu

    fun getWaifu() {
        viewModelScope.launch {
            try {
                val waifu = repository.getAngryWaifu()
                _angryWaifu.value = waifu.url
            } catch (e: Exception) {
                Log.e("WaifuViewModel", "Error fetching waifu: $e")
            }
        }
    }
}
