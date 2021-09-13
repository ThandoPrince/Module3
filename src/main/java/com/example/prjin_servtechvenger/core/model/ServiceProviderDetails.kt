package com.example.prjin_servtechvenger.core.model

import android.os.Parcelable
import android.widget.EditText
import kotlinx.parcelize.Parcelize

@Parcelize
class ServiceProviderDetails(
    var firstName: String,
    var lastName: String,
    var gender: String,
    var phoneNumber: String,
    var identityNumber: String,
    var dateOfBirth: String,
    var serResidentialAddress: String,


    ): Parcelable