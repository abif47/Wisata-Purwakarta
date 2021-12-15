package com.example.wisatapurwakarta.utilities

import com.example.wisatapurwakarta.WisataItem

class StaticData {
    companion object{
        var nama: String = ""
        var gambar: String = ""
        var kategori: String = ""
        var id: Int = 0

        fun fill(wisataItem: WisataItem){
            if(wisataItem.nama != null){
                nama = wisataItem.nama
            } else{
                nama = " - "
            }
            if(wisataItem.kategori != null){
                kategori = "Kategori: " + wisataItem.kategori
            } else{
                kategori = "Kategori: - "
            }
            if(wisataItem.gambar_url != null){
                gambar = wisataItem.gambar_url
            } else{
                gambar = "-"
            }

        }
    }
}