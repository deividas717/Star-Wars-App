package com.sample.starwarssample.model

import com.google.gson.annotations.SerializedName

data class PlanetsResult(@SerializedName("results") val result: List<Planet>)