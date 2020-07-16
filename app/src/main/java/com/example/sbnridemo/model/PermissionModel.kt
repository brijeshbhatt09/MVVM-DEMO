package com.example.sbnridemo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */

class PermissionModel {

    @SerializedName("admin")
    @Expose
    var admin : Boolean? = null
    @SerializedName("push")
    @Expose
    var push : Boolean? = null
    @SerializedName("pull")
    @Expose
    var pull : Boolean? = null

    fun getPermission() : String{
        var permission : String = ""
        if(this!!.admin!!)
            permission = "admin "
        if(this!!.push!!)
            permission += "push "
        if(this!!.pull!!)
            permission += "pull "

        return permission
    }

}