package com.rafaelbarreto.infoescola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class EducacaoProfissionalListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educacao_profissional_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_professional_edu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
