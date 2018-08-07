package com.rafaelbarreto.infoescola

import android.Manifest
import android.annotation.SuppressLint
import android.widget.Toast
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.location.Location
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AlertDialog
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.maps.model.CircleOptions


import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_location.*
import okhttp3.OkHttpClient
import okhttp3.Request



class LocationActivity : AppCompatActivity(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private lateinit var schoolObj:School
    private lateinit var mMap: GoogleMap
    lateinit var mapFragment : SupportMapFragment
    var mGoogleApiClient: GoogleApiClient? = null
    var latitude : Double = 0.0
    var longitude : Double = 0.0

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
        mapFragment?.getMapAsync(this)

        // Set up the GoogleApiClient object
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()

        // Require permitions
        PermissionUtils.validate(this, 0,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION)

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        for (result in grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                // Permission denied, execute something
                alertAndFinish()
                return
            }
        }
        // Its all ok
    }

    override fun onStart() {
        super.onStart()

        // Connecting to Google Play Services
        mGoogleApiClient?.connect()
    }

    override fun onStop() {
        // Disconnect to Google Play Services
        mGoogleApiClient?.disconnect()
        super.onStop()
    }

    override fun onConnected(bundle: Bundle?) {
        //toast("Conectado no Google Play Services!")
        Log.d("Rafaaa","Erro ao conectar: ")
        getLastLocation()
    }

    override fun onConnectionSuspended(cause: Int) {
        //toast("Conexão interrompida.")
        Log.d("Rafaaa","Erro ao conectar: ")
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        //toast("Erro ao conectar: " + connectionResult)
        Log.d("Rafaaa","Erro ao conectar: " + connectionResult)
    }

    private fun getLastLocation() {

        val fusedClient = LocationServices.getFusedLocationProviderClient(this)

        // Verifica permissões
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Este "if" o Android Studio pede para colocar.
            // Alguma permissão foi negada, agora é com você :-)
            alertAndFinish()
            return
        }

        // Fused Location Provider API
        fusedClient.lastLocation
                .addOnSuccessListener { location ->
                    // Atualiza a localização do mapa
                    setMapLocation(location)
                }
                .addOnFailureListener {
                    Log.d("RAFAAA", "Não foi possível ao buscar a localização do GPS")
                }
    }

    // Atualiza a coordenada do mapa
    private fun setMapLocation(l: Location) {
        if (mMap != null) {
            latitude = l.latitude
            longitude = l.longitude

            val currrentLocation = LatLng(l.latitude, l.longitude)
            mMap.addMarker(MarkerOptions().position(currrentLocation).title(resources.getString(R.string.my_location)))
            val update = CameraUpdateFactory.newLatLngZoom(currrentLocation, 10f)
            mMap?.animateCamera(update)

            Log.d("GoogleMap", "before location3")
            Log.d("RAFAEL LOCATION:",schoolObj.geometry.coordinates[0][0][0].toString())

            val lat = schoolObj.geometry.coordinates[0][0][1]
            val longit = schoolObj.geometry.coordinates[0][0][0]
            val location3 = LatLng(lat,longit)
            mMap.addMarker(MarkerOptions().position(location3).title(resources.getString(R.string.destiny)))

            Log.d("GoogleMap", "before URL")
            val URL = getDirectionURL(currrentLocation,location3)
            Log.d("GoogleMap", "URL : $URL")
            GetDirection(URL).execute()
        }
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

    private fun alertAndFinish() {
        run {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.app_name).setMessage("Para utilizar este aplicativo, você precisa aceitar as permissões.")
            // Add the buttons
            builder.setPositiveButton("OK") { dialog, id -> finish() }
            val dialog = builder.create()
            dialog.show()
        }
    }

    override fun onMapReady(map: GoogleMap) {
        this.mMap = map

        // Configura o tipo do mapa
        map.mapType = GoogleMap.MAP_TYPE_NORMAL
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

//    fun toast(s: String) {
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
//    }
}
