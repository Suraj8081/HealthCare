package com.helthcare.adapter.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.helthcare.databinding.LoginDescViewBinding

class LoginDescAdapter(val list: List<String>) : RecyclerView.Adapter<LoginDescAdapter.DescHolder>() {


    inner class DescHolder(val binding:LoginDescViewBinding):RecyclerView.ViewHolder(binding.root) {
        fun setData(get: String) {
            binding.tvDesc.setText(get)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescHolder {
        val view=LoginDescViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DescHolder(view)
    }

    override fun onBindViewHolder(holder: DescHolder, position: Int) {
        holder.setData(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

}