package com.example.sbnridemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class LicenseModel {
    @SerializedName("name")
    @Expose
    var name : String? = null
}