package com.example.kelas10.ui

import android.os.Build
import android.text.Spannable.Factory
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kelas10.KontakApplication
import com.example.kelas10.ui.home.viewmodel.HomeViewModel
import com.example.kelas10.ui.kontak.viewmodel.InsertViewModel

object PenyediaViewModel{

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiKontak().container.kontakRepository)
        }
        initializer {
            InsertViewModel(aplikasiKontak().container.kontakRepository)
        }
    }
}

fun CreationExtras.aplikasiKontak(): KontakApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakApplication)