package com.rafaelbarreto.infoescola

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import com.google.gson.Gson

class AcessibilidadeListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acessibilidade_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_accessibility)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = findViewById<ListView>(R.id.school_list_view_accessibility)
        val adapter = EscolaAdapter(this, schoolList)
        listView.adapter = adapter

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
    "id": 326,
    "properties": {
      "escola_codigo": 17,
      "escola_tipo": "Esc",
      "rpa": 1,
      "escola_nome": "Pedro Augusto",
      "endereco": "Rua Barao de Sao Borja, 279 - Boa Vista",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26121468,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 20,
      "sala_professora": "nao",
      "prog": "Projovem",
      "qtd_atendidos": 830,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.8901721117607,
            -8.060443170821397
          ],
          [
            -34.89004179003522,
            -8.06043655731286
          ],
          [
            -34.88981463911807,
            -8.060621568180222
          ],
          [
            -34.89019764509501,
            -8.06126547537969
          ],
          [
            -34.89046482404783,
            -8.061127173160157
          ],
          [
            -34.89043829325493,
            -8.060869386002535
          ],
          [
            -34.89021379859212,
            -8.06084697518653
          ],
          [
            -34.89022928048234,
            -8.060673762240025
          ],
          [
            -34.89015505465964,
            -8.060666890051003
          ],
          [
            -34.8901721117607,
            -8.060443170821397
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 211,
    "properties": {
      "escola_codigo": 99,
      "escola_tipo": "Esc",
      "rpa": 3,
      "escola_nome": "SÃ£o CristÃ³vÃ£o",
      "endereco": "Rua Cassiterita, 395 - Brejo da Guabiraba",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26126630,
      "qtd_anexos": 0,
      "existe_biblioteca": "nao",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 1154,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93525819469073,
            -7.993017991555647
          ],
          [
            -34.935167031457524,
            -7.993074113822966
          ],
          [
            -34.93545195374815,
            -7.993535219457586
          ],
          [
            -34.93553299051539,
            -7.993485895139737
          ],
          [
            -34.93525819469073,
            -7.993017991555647
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 140,
    "properties": {
      "escola_codigo": 116,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Iputinga",
      "endereco": "Rua Coronel Fernando Furtado 479 Iputinga",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26119218,
      "qtd_anexos": 2,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 718,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.928136763622454,
            -8.041200598221108
          ],
          [
            -34.927711194831275,
            -8.041431579960468
          ],
          [
            -34.927949913037146,
            -8.041869489295038
          ],
          [
            -34.92819111356935,
            -8.041735786918444
          ],
          [
            -34.92825733786927,
            -8.041859437776518
          ],
          [
            -34.928548476714866,
            -8.041692789253151
          ],
          [
            -34.92848397934781,
            -8.041569130347739
          ],
          [
            -34.92845093183287,
            -8.041521078413746
          ],
          [
            -34.92837972913652,
            -8.041440493161007
          ],
          [
            -34.928136763622454,
            -8.041200598221108
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 113,
    "properties": {
      "escola_codigo": 174,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Educador Paulo Freire",
      "endereco": "Avenida General Bento da Gama 301 Ipsep",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26148161,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 959,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92399534276852,
            -8.110240004701199
          ],
          [
            -34.923768506653154,
            -8.11021039674519
          ],
          [
            -34.92376776080461,
            -8.110200639155947
          ],
          [
            -34.92358993699453,
            -8.110178468763936
          ],
          [
            -34.92354511558042,
            -8.110169616314783
          ],
          [
            -34.92351660874581,
            -8.110354523162934
          ],
          [
            -34.92352156296328,
            -8.110366353777076
          ],
          [
            -34.923956346727195,
            -8.110426356034086
          ],
          [
            -34.92397517812641,
            -8.11041371606425
          ],
          [
            -34.92399534276852,
            -8.110240004701199
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 111,
    "properties": {
      "escola_codigo": 195,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Maria Sampaio de Lucena",
      "endereco": "Avenida Pernambuco, S/N - UR 01/ Ibura",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26124556,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 1081,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.94623725671051,
            -8.120779529458705
          ],
          [
            -34.94634227518291,
            -8.121139545136897
          ],
          [
            -34.946440651459,
            -8.121109620690081
          ],
          [
            -34.94645726080149,
            -8.121148812064837
          ],
          [
            -34.94655893686567,
            -8.12112214535283
          ],
          [
            -34.94652870354281,
            -8.120981569884217
          ],
          [
            -34.946617243446894,
            -8.120954966015603
          ],
          [
            -34.946705800006214,
            -8.120931633791292
          ],
          [
            -34.94673252859826,
            -8.121026410786929
          ],
          [
            -34.947096589260084,
            -8.120929763778921
          ],
          [
            -34.94710022025098,
            -8.12100174276046
          ],
          [
            -34.94718497227806,
            -8.120870435014782
          ],
          [
            -34.94718471993138,
            -8.120818074825898
          ],
          [
            -34.946615729826036,
            -8.120640806583001
          ],
          [
            -34.94623725671051,
            -8.120779529458705
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 76,
    "properties": {
      "escola_codigo": 133,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "Antonio Farias Filho",
      "endereco": "Rua Vinte e um de Abril, S/N-San Martim",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26117576,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais",
      "qtd_atendidos": 1191,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92615198329198,
            -8.072103051218662
          ],
          [
            -34.92574009097145,
            -8.072259503972846
          ],
          [
            -34.92578014920704,
            -8.073072877421852
          ],
          [
            -34.9261962812819,
            -8.07289442955293
          ],
          [
            -34.92615198329198,
            -8.072103051218662
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 74,
    "properties": {
      "escola_codigo": 153,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "ProfÂº. AntÃ´nio de Brito Alves",
      "endereco": "Rua  Ernesto Cavalcanti 41 Mustardinha",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26153386,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 1214,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.91824275061252,
            -8.07335064994951
          ],
          [
            -34.91767733398357,
            -8.0734463308682
          ],
          [
            -34.91778621161955,
            -8.074059900339606
          ],
          [
            -34.91779178847828,
            -8.074073907957713
          ],
          [
            -34.91780691580607,
            -8.074079329231168
          ],
          [
            -34.91826047275828,
            -8.074064978344525
          ],
          [
            -34.91827614388645,
            -8.07404435464097
          ],
          [
            -34.91824275061252,
            -8.07335064994951
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 53,
    "properties": {
      "escola_codigo": 12,
      "escola_tipo": "Esc",
      "rpa": 1,
      "escola_nome": "Professor JosÃ© da Costa Porto",
      "endereco": "Rua Cabo Eutropio  660 Ilha Joana Bezerra",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26121255,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 20,
      "sala_professora": "nao",
      "prog": "MaisEduc/EscAbe/ProJ",
      "qtd_atendidos": 403,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.900694300332106,
            -8.071779442699542
          ],
          [
            -34.90072574343423,
            -8.071451628804565
          ],
          [
            -34.90071023625075,
            -8.071424873416017
          ],
          [
            -34.900689033371265,
            -8.071413473904256
          ],
          [
            -34.900664933596985,
            -8.07141187350836
          ],
          [
            -34.900415879806076,
            -8.071385999158764
          ],
          [
            -34.90037335053283,
            -8.071748366629837
          ],
          [
            -34.900240614810656,
            -8.071733652597596
          ],
          [
            -34.90019975384309,
            -8.072086171527511
          ],
          [
            -34.900610906145374,
            -8.07212820109106
          ],
          [
            -34.900634479522324,
            -8.072118676619134
          ],
          [
            -34.90065795751242,
            -8.072088751322985
          ],
          [
            -34.900694300332106,
            -8.071779442699542
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 34,
    "properties": {
      "escola_codigo": 74,
      "escola_tipo": "Esc",
      "rpa": 3,
      "escola_nome": "Guabiraba",
      "endereco": "Rua Cassiterita 395 A Guabiraba",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26171740,
      "qtd_anexos": 2,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais Educ/ProJovem",
      "qtd_atendidos": 731,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93516363709467,
            -7.993072441846938
          ],
          [
            -34.9348851321491,
            -7.993254334130725
          ],
          [
            -34.934885163966285,
            -7.993261085476205
          ],
          [
            -34.93527632039708,
            -7.993630554923389
          ],
          [
            -34.93528817102509,
            -7.993630499414368
          ],
          [
            -34.935448559380426,
            -7.993533547485141
          ],
          [
            -34.93516363709467,
            -7.993072441846938
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 11,
    "properties": {
      "escola_codigo": 26,
      "escola_tipo": "Esc",
      "rpa": 2,
      "escola_nome": "Antonio Heraclio do Rego",
      "endereco": "Rua Manoel Silva 134 FundÃ£o",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26128640,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 19,
      "sala_professora": "nao",
      "prog": "MaisEduc/EscAbt/PJv",
      "qtd_atendidos": 932,
      "atendimento_especial": "Coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.88917916404541,
            -8.018432052451166
          ],
          [
            -34.888854807931935,
            -8.01835800769638
          ],
          [
            -34.88896815862298,
            -8.01913885898333
          ],
          [
            -34.88914537968415,
            -8.019604264300375
          ],
          [
            -34.88945052038891,
            -8.019477844956585
          ],
          [
            -34.8893519042502,
            -8.019058962099805
          ],
          [
            -34.889210531690665,
            -8.018434513242932
          ],
          [
            -34.88917916404541,
            -8.018432052451166
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
