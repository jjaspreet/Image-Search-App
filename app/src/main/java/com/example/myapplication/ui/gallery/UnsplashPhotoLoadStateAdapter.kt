package com.example.myapplication.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.UnsplashPhotoLoadStateFooterBinding
import kotlinx.android.synthetic.main.unsplash_photo_load_state_footer.view.*

class UnsplashPhotoLoadStateAdapter(private val retry: () -> Unit): LoadStateAdapter<UnsplashPhotoLoadStateAdapter.LOadStateViewHolder>(){

    inner class LOadStateViewHolder(private val binding: UnsplashPhotoLoadStateFooterBinding): RecyclerView.ViewHolder(binding.root){

        init {
            binding.retruButton.setOnClickListener {
                retry.invoke()
            }
        }
        fun bind(loadState: LoadState){
            binding.apply {
                textView.isVisible = loadState !is LoadState.Loading
                retruButton.isVisible = loadState !is LoadState.Loading
                progressBar2.isVisible = loadState !is LoadState.Loading
            }
        }
    }

    override fun onBindViewHolder(holder: LOadStateViewHolder, loadState: LoadState) {
       holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LOadStateViewHolder {
       val binding = UnsplashPhotoLoadStateFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false )

        return LOadStateViewHolder(binding)
    }
}