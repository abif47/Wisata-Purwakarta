package com.example.wisatapurwakarta.ui.selected

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wisatapurwakarta.R
import com.example.wisatapurwakarta.utilities.StaticData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_selected_wisata.*

class SelectedWisata : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_wisata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load(StaticData.gambar)
            .into(gambar_selected)
        nama_selected.text = StaticData.nama
        kategori_selected.text = StaticData.kategori

        share.setOnClickListener{
            val nama = StaticData.nama.toUpperCase()
            val kategori = StaticData.kategori
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Hai! Jika Anda jalan-jalan ke Purwekerto, $nama adalah rekomendasi tempat wisata yang harus kamu kunjungi! \n$kategori")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SelectedWisata()
    }
}