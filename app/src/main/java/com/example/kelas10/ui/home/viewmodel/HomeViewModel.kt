package com.example.kelas10.ui.home.viewmodel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kelas10.model.Kontak
import com.example.kelas10.repository.KontakRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class KontakUIState{
    data class Success(val kontak: List<Kontak>): KontakUIState()

    object Error: KontakUIState()

    object Loading: KontakUIState()
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class HomeViewModel (private val kontakRepository: KontakRepository): ViewModel(){
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }


    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = KontakUIState.Loading
            kontakUIState = try{
                KontakUIState.Success(kontakRepository.getKontak())
            }catch (e: IOException){
                KontakUIState.Error
            }catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
}