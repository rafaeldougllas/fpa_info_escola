package com.rafaelbarreto.infoescola

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar

class LabComputacaoListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_computacao_lista)

        supportActionBar?.title = "Teste"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
