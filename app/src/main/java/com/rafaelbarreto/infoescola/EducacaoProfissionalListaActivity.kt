package com.rafaelbarreto.infoescola

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson

class EducacaoProfissionalListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_educacao_profissional_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_professional_edu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = findViewById<ListView>(R.id.school_list_view_edu_prof)
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

    fun getDatas(): ArrayList<School> {
        val jsonStr = getJsonSt()
        val schoolListFromServ = Gson().fromJson(jsonStr, Array<School>::class.java)
        val schoolLi = schoolListFromServ.toCollection(ArrayList())
        println("RAAAFAAAAAAAAAA2")
        println(schoolLi)




        return schoolLi
    }

    fun getJsonSt(): String{
        val js = """[
          {
            "type": "Feature",
            "id": 343,
            "properties": {
              "escola_codigo": 179,
              "escola_tipo": "Esc",
              "rpa": 6,
              "escola_nome": "Engenheiro Henoch Coutinho de Melo",
              "endereco": "Rua das Oficinas, 12-Pina",
              "tipo_predio": "Próprio",
              "mec_codigo": 26155869,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "Pro-Jovem",
              "qtd_atendidos": 354,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.885070248302306,
                    -8.084520507420278
                  ],
                  [
                    -34.885059782437146,
                    -8.084541612587781
                  ],
                  [
                    -34.88510929292629,
                    -8.084587007607203
                  ],
                  [
                    -34.88511972709553,
                    -8.084558883320735
                  ],
                  [
                    -34.885070248302306,
                    -8.084520507420278
                  ]
                ]
              ]
            }
          },
          {
            "type": "Feature",
            "id": 341,
            "properties": {
              "escola_codigo": 178,
              "escola_tipo": "Esc",
              "rpa": 6,
              "escola_nome": "Futuro Feliz",
              "endereco": "Rua Ibirajuba, 440 - Cohab - Três Carneiros",
              "tipo_predio": "Próprio",
              "mec_codigo": 26124610,
              "qtd_anexos": 0,
              "existe_biblioteca": "sim",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 341,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.95835093451718,
                    -8.125672211268201
                  ],
                  [
                    -34.95829656401024,
                    -8.12569162880759
                  ],
                  [
                    -34.95829665690688,
                    -8.125710783144433
                  ],
                  [
                    -34.958360653718664,
                    -8.125694512309401
                  ],
                  [
                    -34.95835093451718,
                    -8.125672211268201
                  ]
                ]
              ]
            }
          }
          ]
                  """
        return js
    }
}
