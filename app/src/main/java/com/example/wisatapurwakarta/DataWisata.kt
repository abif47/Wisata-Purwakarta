package com.example.wisatapurwakarta

data class WisataItem(val nama: String, val gambar_url: String, val kategori: String, val id: Int = 0)


data class DataWisata(val wisata: List<WisataItem>?)