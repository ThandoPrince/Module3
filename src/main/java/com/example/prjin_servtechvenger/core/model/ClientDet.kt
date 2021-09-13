package com.example.prjin_servtechvenger.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ClientDet (
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var gender: String,
    var clientAdd: String,
): Parcelable