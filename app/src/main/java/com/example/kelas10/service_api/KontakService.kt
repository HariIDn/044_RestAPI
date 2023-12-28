package com.example.kelas10.service_api

import com.example.kelas10.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Headers

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("/kontak")
    suspend fun getKontak(): List<Kontak>
}