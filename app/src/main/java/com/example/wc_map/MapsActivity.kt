package com.example.wc_map

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.example.wc_map.R.id
import com.example.wc_map.R.layout
import com.google.android.gms.maps.*
import com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

//test
/*
import android.support.v7.app.AppCompatActivity
import android.os.Looper
import android.widget.Toast
import com.google.android.gms.location.*

class MapsActivity : AppCompatActivity(){
    // 位置情報を取得できるクラス
    private lateinit var fusedLocationClient : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = FusedLocationProviderClient(this)

        // どのような取得方法を要求
        val locationRequest = LocationRequest().apply {
            // 精度重視(電力大)と省電力重視(精度低)を両立するため2種類の更新間隔を指定
            // 今回は公式のサンプル通りにする。
            interval = 10000                                   // 最遅の更新間隔(但し正確ではない。)
            fastestInterval = 5000                             // 最短の更新間隔
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY  // 精度重視


        }

        // コールバック
        val locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                // 更新直後の位置が格納されているはず
                val location = locationResult?.lastLocation ?: return
                Toast.makeText(this@MapsActivity,
                        "緯度:${location.latitude}, 経度:${location.longitude}", Toast.LENGTH_LONG).show()
            }
        }

        // 位置情報を更新
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
    }
}

*/
//test


class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.


        val mapFragment = supportFragmentManager
                .findFragmentById(id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap


//現在地のピン
        val utunomiya = LatLng(43.0675, 141.350784)
        mMap!!.addMarker(MarkerOptions().position(utunomiya).title("Marker in utunomiya"))
        mMap!!.moveCamera(newLatLngZoom(utunomiya,16f))
    }
}