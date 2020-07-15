package com.brijesh.testdemo.model

import com.example.sbnridemo.model.LicenseModel
import com.example.sbnridemo.model.PermissionModel
import kotlin.collections.ArrayList

/**
 * Created by ${Brijesh.Bhatt} on 15/07/20.
 */
class RowModel {
    var name: String? = null
    var description: String? = null
    var open_issues_count: String? = null
    var permissions: ArrayList<PermissionModel>? = null
    var license: ArrayList<LicenseModel>? = null
}