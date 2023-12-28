package com.example.kelas10.repository

import com.example.kelas10.model.Kontak
import com.example.kelas10.service_api.KontakService

interface KontakRepository {
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepository(
    private val kontakApiServices: KontakService
): KontakRepository{
    override suspend fun getKontak(): List<Kontak> = kontakApiServices.getKontak()
}