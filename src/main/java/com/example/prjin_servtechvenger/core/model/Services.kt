package com.example.prjin_servtechvenger.core.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Services (
    var cleaner: String,
    var repairs: String,
    var carwash: String,
    var gardener: String,
    var babysitter: String,
    var launder_assistant: String,
    var personal_trainer: String,
    var hairdresser: String,
    var menicure_penicure: String
    ):Parcelable
