package com.rafaelbarreto.infoescola

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_escola_detalhe.*

class EscolaDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escola_detalhe)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.school_detail_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Recovery the object passed on intent
        val schoolObj = intent.extras.getParcelable<Escola>("SCHOOL_OBJ_SELECTED")

        school_detail_name.text = schoolObj.escola_nome
    }
}
