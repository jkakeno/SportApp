package com.junkakeno.sportapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SportsResponse(

	@field:SerializedName("Tennis")
	val tennis: List<TennisItem>? = null,

	@field:SerializedName("f1Results")
	val f1Results: List<F1ResultsItem>? = null,

	@field:SerializedName("nbaResults")
	val nbaResults: List<NbaResultsItem>? = null
) : Parcelable

@Parcelize
data class NbaResultsItem(

	@field:SerializedName("winner")
	val winner: String? = null,

	@field:SerializedName("gameNumber")
	val gameNumber: Int? = null,

	@field:SerializedName("mvp")
	val mvp: String? = null,

	@field:SerializedName("tournament")
	val tournament: String? = null,

	@field:SerializedName("publicationDate")
	override val publicationDate: String? = null,

	override var dateLong:Long? = null,

	@field:SerializedName("looser")
	val looser: String? = null

) : Parcelable, Sport

@Parcelize
data class F1ResultsItem(

	@field:SerializedName("seconds")
	val seconds: Double? = null,

	@field:SerializedName("winner")
	val winner: String? = null,

	@field:SerializedName("tournament")
	val tournament: String? = null,

	@field:SerializedName("publicationDate")
	override val publicationDate: String? = null,

	override var dateLong:Long? = null,

	) : Parcelable, Sport

@Parcelize
data class TennisItem(

	@field:SerializedName("numberOfSets")
	val numberOfSets: Int? = null,

	@field:SerializedName("winner")
	val winner: String? = null,

	@field:SerializedName("tournament")
	val tournament: String? = null,

	@field:SerializedName("publicationDate")
	override val publicationDate: String? = null,

	override var dateLong:Long? = null,

	@field:SerializedName("looser")
	val looser: String? = null

) : Parcelable, Sport

interface Sport{
	var dateLong: Long?
    val publicationDate: String?
}
