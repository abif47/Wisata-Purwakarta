package com.example.wisatapurwakarta.Network

import com.example.wisatapurwakarta.DataWisata
import retrofit2.Call
import retrofit2.http.GET


interface api {

    @GET("api/purwakarta/wisata")

    fun getDataWisata(): Call<DataWisata>
}