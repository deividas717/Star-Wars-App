package com.sample.starwarssample.model

import com.google.gson.annotations.SerializedName

data class UsersResult(@SerializedName("results") val result: List<User>)