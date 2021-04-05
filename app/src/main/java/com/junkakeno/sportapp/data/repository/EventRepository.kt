package com.junkakeno.sportapp.data.repository

import com.junkakeno.sportapp.data.network.Retrofit

class EventRepository {

    private val service = Retrofit.getService()

    suspend fun getEvents() = service.getEvents()

}