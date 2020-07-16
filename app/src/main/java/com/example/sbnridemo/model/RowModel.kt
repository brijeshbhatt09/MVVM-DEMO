package com.example.sbnridemo.model

import com.example.sbnridemo.model.LicenseModel
import com.example.sbnridemo.model.PermissionModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.collections.ArrayList

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */
class RowModel {
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("open_issues_count")
    @Expose
    var open_issues_count: String? = null
    @SerializedName("permissions")
    @Expose
    var permissions: PermissionModel? = null
    @SerializedName("license")
    @Expose
    var license: LicenseModel? = null

}