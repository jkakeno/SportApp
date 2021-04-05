package com.junkakeno.sportapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.junkakeno.sportapp.data.model.Sport
import com.junkakeno.sportapp.data.util.Resource
import com.junkakeno.sportapp.data.repository.EventRepository
import com.junkakeno.sportapp.extention.getLatestEvents
import kotlinx.coroutines.Dispatchers

class EventsViewModel : ViewModel() {

    private val repository = EventRepository()

    fun getEvents() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            val events = mutableListOf<Sport>()

            repository.getEvents().f1Results?.let { list ->
                events.addAll(list as List<Sport>)
            }

            repository.getEvents().nbaResults?.let { list ->
                events.addAll(list as List<Sport>)
            }

            repository.getEvents().tennis?.let { list ->
                events.addAll(list as List<Sport>)
            }

            val latestEvents = (events as List<Sport>).getLatestEvents()

            emit(Resource.success(data = latestEvents))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = "Something went wrong..."))
        }
    }

}