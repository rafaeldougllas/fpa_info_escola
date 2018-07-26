package com.rafaelbarreto.infoescola

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.util.Log
import android.widget.ListView

class LabComputacaoListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_computacao_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_lab_comp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        listView = findViewById<ListView>(R.id.school_list_view_comp)

        val schoolObj1 = Escola("Escola 1","Rua ali do lado da esquina 99","https://thumbs.dreamstime.com/b/country-school-building-illustration-33993929.jpg")
        val schoolObj2 = Escola("Escola 2","Rua atras do posto ribeiro da esquina 403","https://thumbs.dreamstime.com/b/country-school-building-illustration-33993929.jpg")
        val schoolList = ArrayList<Escola>()
        schoolList.add(schoolObj1)
        schoolList.add(schoolObj2)

        val adapter = EscolaAdapter(this, schoolList)
        listView.adapter = adapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedSchool = schoolList[position]

            Log.d("RAFA","CLICOU EM "+selectedSchool)
            //TODO APAGAR QUANDO FOR COLOCAR NOVA ACTIVITY
            //val detailIntent = EscolaDetalheActivity.newIntent(context, selectedSchool)
            val detailIntent = Intent(this,EscolaDetalheActivity::class.java)
            detailIntent.putExtra("SCHOOL_OBJ_SELECTED",selectedSchool)
            startActivity(detailIntent)
        }

    }
}
