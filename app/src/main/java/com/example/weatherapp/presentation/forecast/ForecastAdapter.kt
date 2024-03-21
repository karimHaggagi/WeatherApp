package com.example.weatherapp.presentation.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.weatherapp.databinding.ForecatsItemBinding
import com.example.weatherapp.domain.model.ForecastDayModel

class ForecastAdapter(private val list: List<ForecastDayModel>) :
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {
    inner class ForecastViewHolder(private val binding: ForecatsItemBinding) :
        ViewHolder(binding.root) {
        fun bind(item: ForecastDayModel) {
            binding.model = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            ForecatsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.bind(list[position])
    }
}