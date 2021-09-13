package com.example.prjin_servtechvenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prjin_servtechvenger.core.model.Services

class SerProviderServiceSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ser_provider_service_selection)

        val services= ArrayList<Services>()
        services.add(Services("Cleaner", "Repairs", "Car-wash", "Gardener", "Baby-sitter", "Laundry-Assistant", "Personal-Trainer",
        "Hairdresser","Menicure/Penicure"))
    }
}