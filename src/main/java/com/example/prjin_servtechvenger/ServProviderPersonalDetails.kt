package com.example.prjin_servtechvenger

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.example.prjin_servtechvenger.core.model.ServiceProviderDetails
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import kotlin.collections.ArrayList

    var currentMarkerr : Marker? = null
    private lateinit var eMap: GoogleMap
    var fusedLocationProviderClient: FusedLocationProviderClient?=null
    var currentLocation: Location? = null
class ServProviderPersonalDetails : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service_provider)
        val btnNext = findViewById<Button>(R.id.btnNextSerDetails)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation()
        btnNext.setOnClickListener {
            intent = Intent(this, ServProviderServSelection::class.java)
            addServiceProviders()
            startActivity(intent)
        }
    }
   private fun addServiceProviders(){
       val serviceProviders = ArrayList<ServiceProviderDetails>()
        val serProFirstName = findViewById<EditText>(R.id.txtEnterSerFirstName)
        val serProLastName = findViewById<EditText>(R.id.txtEnterSerLastName)
        val serProGender = findViewById<EditText>(R.id.txtEnterSerGender)
        val serProPhoneNumber = findViewById<EditText>(R.id.txtEnterSerPhoneNumber)
        val serProIdentityNumber = findViewById<EditText>(R.id.txtEnterIdentityNumber)
        val serProDOB = findViewById<EditText>(R.id.txtEnterDOB)
       val locationn = findViewById<TextView>(R.id.txtSerProResiAdd)
       locationn.text = fetchLocation().toString()
        serviceProviders.add(ServiceProviderDetails(serProFirstName.toString(), serProLastName.toString(),
            serProGender.toString(),serProPhoneNumber.toString(),serProIdentityNumber.toString(),serProDOB.toString(), locationn.toString()))
       return
    }
    private fun fetchLocation() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1000)
            return
        }
        val task = fusedLocationProviderClient?.lastLocation
        task?.addOnSuccessListener { clilocation ->
            currentLocation = clilocation
            if (clilocation != null) {
                val mapFragment =
                    supportFragmentManager.findFragmentById(R.id.txtSerProResiAdd) as SupportMapFragment
                mapFragment.getMapAsync(this)
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1000 -> if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                fetchLocation()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
    override fun onMapReady(googleMap: GoogleMap) {
        eMap = googleMap
        val latlong = LatLng(currentLocation?.latitude!!,currentLocation?.longitude!!)
        eMap.setOnMarkerDragListener(object : GoogleMap.OnMarkerDragListener{
            override fun onMarkerDrag(p0 : Marker?){
            }
            override fun onMarkerDragEnd(p0: Marker) {
                if (currentMarkerr != null)
                    currentMarkerr?.remove()
                val newLatLng = LatLng(p0?.position.latitude, p0?.position.longitude)
                drawMarker(newLatLng)
            }
            override fun onMarkerDragStart(p0: Marker) {
            }
        })
    }
    private fun drawMarker(latlong: LatLng){
        val marker= MarkerOptions().position(latlong).title("I am here").snippet(getAddress(latlong.latitude, latlong.longitude)).draggable(true)
        eMap.animateCamera(CameraUpdateFactory.newLatLng(latlong))
        eMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlong, 15f))
        eMap.addMarker(marker)
        currentMarkerr = eMap.addMarker(marker)
        currentMarkerr?.showInfoWindow()
    }
    private fun getAddress(lat: Double, lon: Double): String?{
        val geoCoder = Geocoder(this, Locale.getDefault())
        val addresses = geoCoder.getFromLocation(lat, lon,1)
        return addresses[0].getAddressLine(0).toString()
    }

}

