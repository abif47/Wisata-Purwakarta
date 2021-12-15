package com.example.wisatapurwakarta.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wisatapurwakarta.R
import com.example.wisatapurwakarta.WisataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*


class HomeAdapter(private val listWisata: ArrayList<WisataItem>, val listener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.Homeholder>() {

    interface OnItemClickListener{
        fun onClick(wisataItem: WisataItem)
    }

    class Homeholder(itemview: View): RecyclerView.ViewHolder(itemview){
        fun bind(wisataItem: WisataItem, listener: OnItemClickListener){
            with(itemView){
                Picasso.get()
                    .load(wisataItem.gambar_url)
                    .into(thumbnail_img)
                nama.text = wisataItem.nama
                kategori.text= wisataItem.kategori
            }
            itemView.setOnClickListener{
                listener.onClick(wisataItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.Homeholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return Homeholder(view)

    }

    override fun getItemCount(): Int {
        return listWisata.size
    }

    override fun onBindViewHolder(holder: HomeAdapter.Homeholder, position: Int) {
        holder.bind(listWisata[position],listener)
    }
}