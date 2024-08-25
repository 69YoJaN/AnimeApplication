package com.example.anime.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.anime.R
import com.example.anime.viewModel.WaifuViewModel

class Waifu : Fragment() {
    private lateinit var viewModel: WaifuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_waifu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView: ImageView = view.findViewById(R.id.waifuHere)

        viewModel = ViewModelProvider(this)[WaifuViewModel::class.java]

        viewModel.angryWaifu.observe(viewLifecycleOwner, Observer { url ->
            Log.d("WaifuFragment", "Received URL: $url")
            Glide.with(this)
                .asGif()
                .load(url)
                .into(imageView)
            Log.d("WaifuFragment", "Glide should have started loading the GIF")
        })

        viewModel.getWaifu()

        imageView.setOnClickListener {
            viewModel.getWaifu()
        }
    }
}
