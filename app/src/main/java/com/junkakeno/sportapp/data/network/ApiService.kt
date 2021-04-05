package com.junkakeno.sportapp.data.network

import com.junkakeno.sportapp.data.model.SportsResponse
import retrofit2.http.*

interface ApiService {

    @Headers("Content-Type:application/json")
    @POST("/results")
    suspend fun getEvents(): SportsResponse

}