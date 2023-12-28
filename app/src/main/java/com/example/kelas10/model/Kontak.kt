package com.example.kelas10.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kontak(
    val id: Int,
    val nama: String,
    @SerialName(value = "email")
    val mail: String,
    @SerialName(value = "nohp")
    val telepon: String
)
