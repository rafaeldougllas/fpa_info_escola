package com.rafaelbarreto.infoescola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class EscolasMunicListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolas_munic_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_schools)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
