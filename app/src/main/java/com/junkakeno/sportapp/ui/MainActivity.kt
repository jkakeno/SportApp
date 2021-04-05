package com.junkakeno.sportapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.junkakeno.sportapp.R
import com.junkakeno.sportapp.data.util.Status
import com.junkakeno.sportapp.databinding.ActivityMainBinding
import com.junkakeno.sportapp.extention.getLatestDate
import com.junkakeno.sportapp.ui.adapter.EventsAdapter
import com.junkakeno.sportapp.ui.viewmodel.EventsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: EventsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(EventsViewModel::class.java)
        
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getResultBtn.setOnClickListener {

            binding.getResultBtn.visibility = View.GONE

            viewModel.getEvents().observe(this, Observer {
                when (it.status) {
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        binding.errorMsg.visibility = View.GONE

                        it.data?.let { data ->
                            binding.date.visibility = View.VISIBLE
                            binding.eventList.visibility = View.VISIBLE

                            binding.date.text = resources.getString(R.string.result_title,data.getLatestDate())

                            val adapter = EventsAdapter(data)
                            binding.eventList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                            binding.eventList.adapter = adapter
                        }

                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.errorMsg.visibility = View.VISIBLE
                        binding.errorMsg.text = it.message
                    }
                    Status.LOADING -> {
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            })

        }

    }


}