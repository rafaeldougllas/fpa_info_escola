package com.rafaelbarreto.infoescola

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request



class LocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var schoolObj:School
    private lateinit var mMap: GoogleMap
    lateinit var mapFragment : SupportMapFragment

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.btn_how_get_there)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Recovery the object passed on intent
        if(intent.extras.getParcelable<School>("SCHOOL_OBJ_SELECTED") != null){
            schoolObj = intent.extras.getParcelable<School>("SCHOOL_OBJ_SELECTED")
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            Log.d("GoogleMap", "before isMyLocationEnabled")

            //mMap.isMyLocationEnabled = true


            val location1 = LatLng(-8.181969, -34.925189)
            mMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1,10f))

            Log.d("GoogleMap", "before location3")
            Log.d("RAFAEL LOCATION:",schoolObj.geometry.coordinates[0][0][0].toString())

            val lat = schoolObj.geometry.coordinates[0][0][1]
            val longit = schoolObj.geometry.coordinates[0][0][0]
            val location3 = LatLng(lat,longit)
            mMap.addMarker(MarkerOptions().position(location3).title("Bangalore"))

            Log.d("GoogleMap", "before URL")
            val URL = getDirectionURL(location1,location3)
            Log.d("GoogleMap", "URL : $URL")
            GetDirection(URL).execute()

        })
    }

    override fun onBackPressed() {
        val data = Intent()
        data.putExtra("key", schoolObj)
        setResult(Activity.RESULT_OK, data)
        //finish()
        super.onBackPressed()
    }
    //To make back button work in many listViewsActivities
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return true
    }
    //TODO ligar a api json e fazer a splash screen(Colocar a imagem correta e cores), colocar tela de contato

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

    }

    fun getDirectionURL(origin:LatLng,dest:LatLng) : String{
        return "https://maps.googleapis.com/maps/api/directions/json?origin=${origin.latitude},${origin.longitude}&destination=${dest.latitude},${dest.longitude}&sensor=false&mode=driving"
    }

    private inner class GetDirection(val url : String) : AsyncTask<Void, Void, List<List<LatLng>>>(){
        override fun doInBackground(vararg params: Void?): List<List<LatLng>> {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            val data = response.body()!!.string()
            Log.d("GoogleMap" , " data : $data")
            val result =  ArrayList<List<LatLng>>()
            try{
                val respObj = Gson().fromJson(data,GoogleMapDTO::class.java)

                val path =  ArrayList<LatLng>()

                for (i in 0..(respObj.routes[0].legs[0].steps.size-1)){
                    path.addAll(decodePolyline(respObj.routes[0].legs[0].steps[i].polyline.points))
                }
                result.add(path)
            }catch (e:Exception){
                e.printStackTrace()
            }
            return result
        }

        override fun onPostExecute(result: List<List<LatLng>>) {
            val lineoption = PolylineOptions()
            for (i in result.indices){
                lineoption.addAll(result[i])
                lineoption.width(10f)
                lineoption.color(Color.BLUE)
                lineoption.geodesic(true)
            }
            mMap.addPolyline(lineoption)
        }
    }

    public fun decodePolyline(encoded: String): List<LatLng> {

        val poly = ArrayList<LatLng>()
        var index = 0
        val len = encoded.length
        var lat = 0
        var lng = 0

        while (index < len) {
            var b: Int
            var shift = 0
            var result = 0
            do {
                b = encoded[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lat += dlat

            shift = 0
            result = 0
            do {
                b = encoded[index++].toInt() - 63
                result = result or (b and 0x1f shl shift)
                shift += 5
            } while (b >= 0x20)
            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
            lng += dlng

            val latLng = LatLng((lat.toDouble() / 1E5),(lng.toDouble() / 1E5))
            poly.add(latLng)
        }

        return poly
    }
}
