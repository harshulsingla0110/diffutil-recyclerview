package com.harshul.diffutil

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.harshul.diffutil.adapters.ProgrammingListAdapter
import com.harshul.diffutil.adapters.ProgrammingRecyclerViewAdapter
import com.harshul.diffutil.databinding.ActivityMainBinding
import com.harshul.diffutil.model.ProgrammingItem

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListAdapter()
        //setupRecyclerViewAdapter()

    }

    private fun setupListAdapter() {
        val adapter = ProgrammingListAdapter()

        val p1 = ProgrammingItem(1, "Veggies", "Onions \uD83E\uDDC5")
        val p2 = ProgrammingItem(2, "Veggies", "Tomatoes \uD83C\uDF45")
        val p3 = ProgrammingItem(3, "Stationary", "Blue Pens \uD83D\uDD8A")

        adapter.submitList(listOf(p1, p2, p3))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val p4 = ProgrammingItem(3, "Stationary", "Blue Pens \uD83D\uDD8A")
            val p5 = ProgrammingItem(4, "Grocery", "Cheese \uD83E\uDDC0")
            val p6 = ProgrammingItem(5, "Grocery", "Eggs \uD83E\uDD5A")
            val p7 = ProgrammingItem(2, "Veggies", "Tomatoes \uD83C\uDF45")
            val p8 = ProgrammingItem(2, "Stationary", "Scissors ✂️")

            adapter.submitList(listOf(p4, p5, p6, p7, p8))
        }, 2000)
    }

    private fun setupRecyclerViewAdapter() {
        val adapter = ProgrammingRecyclerViewAdapter()

        val p1 = ProgrammingItem(1, "Veggies", "Onions \uD83E\uDDC5")
        val p2 = ProgrammingItem(2, "Veggies", "Tomatoes \uD83C\uDF45")
        val p3 = ProgrammingItem(3, "Stationary", "Blue Pens \uD83D\uDD8A")

        adapter.submitList(listOf(p1, p2, p3))

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        Handler(Looper.getMainLooper()).postDelayed({
            val p4 = ProgrammingItem(3, "Stationary", "Blue Pens \uD83D\uDD8A")
            val p5 = ProgrammingItem(4, "Grocery", "Cheese \uD83E\uDDC0")
            val p6 = ProgrammingItem(5, "Grocery", "Eggs \uD83E\uDD5A")
            val p7 = ProgrammingItem(2, "Veggies", "Tomatoes \uD83C\uDF45")
            val p8 = ProgrammingItem(2, "Stationary", "Scissors ✂️")

            adapter.submitList(listOf(p4, p5, p6, p7, p8))
        }, 2000)
    }

}

