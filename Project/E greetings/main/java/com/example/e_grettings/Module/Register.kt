package com.example.e_grettings.Module

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Register {

    @Expose
    @SerializedName("firstname")
    var fname=""

    @Expose
    @SerializedName("lastname")
    var lname=""

    @Expose
    @SerializedName("phone")
    var mobile=""

    @Expose
    @SerializedName("email")
    var email=""

    @Expose
    @SerializedName("password")
    var password=""
}