package com.harshul.diffutil.adapters

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.harshul.diffutil.R
import com.harshul.diffutil.databinding.PrgrammingItemBinding
import com.harshul.diffutil.model.ProgrammingItem

class ProgrammingRecyclerViewAdapter :
    RecyclerView.Adapter<ProgrammingRecyclerViewAdapter.ProgrammingViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<ProgrammingItem>() {
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<ProgrammingItem>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val binding = PrgrammingItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ProgrammingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {

        val item = differ.currentList[position]

        with(holder) {
            binding.textView.apply {
                when (item.category) {
                    "Stationary" -> {
                        backgroundTintList =
                            ColorStateList.valueOf(context.getColor(R.color.light_blue))
                        setTextColor(resources.getColor(R.color.dark_blue))
                    }
                    "Grocery" -> {
                        backgroundTintList =
                            ColorStateList.valueOf(context.getColor(R.color.light_pink))
                        setTextColor(resources.getColor(R.color.dark_pink))
                    }
                    "Veggies" -> {
                        backgroundTintList =
                            ColorStateList.valueOf(context.getColor(R.color.light_green))
                        setTextColor(resources.getColor(R.color.dark_green))
                    }
                }

                text = item.category
            }
            binding.textView2.text = item.name
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class ProgrammingViewHolder(val binding: PrgrammingItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}