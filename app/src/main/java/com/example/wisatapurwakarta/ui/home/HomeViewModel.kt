package com.example.wisatapurwakarta.ui.home

import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.wisatapurwakarta.Adapter.HomeAdapter
import com.example.wisatapurwakarta.DataWisata
import com.example.wisatapurwakarta.Network.RetrofitClient
import com.example.wisatapurwakarta.WisataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel:ViewModel() {

    init {
        Log.d("HomeVIewModel","Created")
    }

    var listWisata : ArrayList<WisataItem> = arrayListOf()


    interface onClickListener{
        fun onClick(wisataItem: WisataItem)
    }


    fun getDataFromApi(recyclerView: RecyclerView,progressBar:ProgressBar, listener : onClickListener){

        RetrofitClient.instance.getDataWisata().enqueue(object :Callback<DataWisata> {
            override fun onFailure(call: Call<DataWisata>, t: Throwable) {
                Log.d("HomeViewModel", "onFailure")
            }

            override fun onResponse(call: Call<DataWisata>, response: Response<DataWisata>) {
                val data = response.body()?.wisata
                listWisata.addAll (data as ArrayList<WisataItem>)
                recyclerView.adapter = HomeAdapter(data as ArrayList<WisataItem>, object : HomeAdapter.OnItemClickListener{
                    override fun onClick(wisataItem: WisataItem) {
                        listener.onClick(wisataItem)
                    }

                })
                progressBar.visibility = View.GONE
            }


        })
    }

}