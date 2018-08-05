package com.rafaelbarreto.infoescola

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.google.gson.Gson

class LabComputacaoListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_computacao_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_lab_comp)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = findViewById<ListView>(R.id.school_list_view_comp)
        val adapter = EscolaAdapter(this, schoolList)
        listView.adapter = adapter

        val context = this
        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedSchool = schoolList[position]

            val detailIntent = Intent(this,EscolaDetalheActivity::class.java)
            detailIntent.putExtra("SCHOOL_OBJ_SELECTED",selectedSchool)
            startActivity(detailIntent)
        }
    }


    fun getDatas(): ArrayList<Escola> {
//        val schoolObj1 = Escola("Escola 9","Rua ali do lado da esquina 99","https://thumbs.dreamstime.com/b/country-school-building-illustration-33993929.jpg")
//        val schoolObj2 = Escola("Escola 10","Rua atras do posto ribeiro da esquina 403","https://thumbs.dreamstime.com/b/country-school-building-illustration-33993929.jpg")
//        val schoolList = ArrayList<Escola>()
//        schoolList.add(schoolObj1)
//        schoolList.add(schoolObj2)

        val json = """
           [{ "escola_nome": "Escola 9",
             "endereco": "Rua ali do lado da esquina 99",
             "imageUrl": "https://thumbs.dreamstime.com/b/country-school-building-illustration-33993929.jpg"
           },{ "escola_nome": "Escola 10",
             "endereco": "Rua ali do lado da esquina 100",
             "imageUrl": "https://thumbs.dreamstime.com/b/country-school-building-illustration-33993929.jpg"
           }]
        """

        val schoolListFromServer = Gson().fromJson(json, Array<Escola>::class.java)
        val schoolList = schoolListFromServer.toCollection(ArrayList())
        println("RAAAFAAAAAAAAAA")
        println(schoolListFromServer[1])

        return schoolList
    }
}
