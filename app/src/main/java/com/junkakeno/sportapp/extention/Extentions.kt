package com.junkakeno.sportapp.extention

import com.junkakeno.sportapp.data.model.Sport
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun List<Sport>.getLatestEvents():List<Sport>{

    val eventlist = mutableListOf<Sport>()

    val latestDate = this.getLatestDate()

    this.forEach { item ->
        if (item.publicationDate?.getDate() == latestDate) {
            item.dateLong =item.publicationDate?.convertDateToLong()
            eventlist.add(item)
        }
    }

    Collections.sort(eventlist as List<Sport>, object : Comparator<Sport> {
        override fun compare(p0: Sport?, p1: Sport?): Int {
            return p1?.dateLong?.compareTo(p0?.dateLong!!)!!
        }
    })

    return eventlist
}

fun List<Sport>.getLatestDate():String {

    val datelist = mutableListOf<String>()

    this.forEach { item ->
        datelist.add(item.publicationDate?.getDate().toString())
    }

    return Collections.max(datelist)
}

fun String.getDate():String{
    return try {
        val date = SimpleDateFormat("MMM dd, yyyy HH:mm:ss aa", Locale.US).parse(this)
        SimpleDateFormat("MMM dd, yyyy", Locale.US).format(date)
    }catch (e: ParseException){
         e.localizedMessage
    }
}

fun String.convertDateToLong():Long{
    return try {
        val date = SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.US).parse(this)
        date.time
    } catch (e: ParseException) {
        e.localizedMessage
        0L
    }
}

