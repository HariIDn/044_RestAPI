package com.example.kelas10

import android.app.Application
import com.example.kelas10.repository.AppContainer
import com.example.kelas10.repository.KontakContainer

class KontakApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate(){
        super.onCreate()
        container = KontakContainer()
    }
}