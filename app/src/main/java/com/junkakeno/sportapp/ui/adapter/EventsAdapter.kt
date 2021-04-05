package com.junkakeno.sportapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junkakeno.sportapp.data.model.F1ResultsItem
import com.junkakeno.sportapp.data.model.NbaResultsItem
import com.junkakeno.sportapp.data.model.Sport
import com.junkakeno.sportapp.data.model.TennisItem
import com.junkakeno.sportapp.databinding.ItemEventBinding


class EventsAdapter (val data:List<Sport>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemEventBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        data[position].let { (holder as ViewHolder).bind(it) }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


class ViewHolder(val binding: ItemEventBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(event:Sport){

        when(event){
            is F1ResultsItem -> {binding.eventTitle.text = "${event.winner} wins ${event.tournament} by ${event.seconds} seconds" }
            is NbaResultsItem -> {binding.eventTitle.text = "${event.mvp} leads ${event.winner} to game ${event.gameNumber} win in the ${event.tournament}"}
            is TennisItem -> {binding.eventTitle.text = "${event.tournament}: ${event.winner} wins against ${event.looser} in ${event.numberOfSets} sets"}
        }

    }

}