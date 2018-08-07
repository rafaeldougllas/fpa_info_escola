package com.rafaelbarreto.infoescola

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson

class QuadraListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quadra_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_sports_court)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = findViewById<ListView>(R.id.school_list_view_sports_court)
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
    "id": 334,
    "properties": {
      "escola_codigo": 201,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Oswaldo Lima Filho",
      "endereco": "Avenida EngÂº Domjingos Ferreira 1040  Pina",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26125510,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 859,
      "atendimento_especial": "coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.886550108289654,
            -8.09842578510607
          ],
          [
            -34.88652321118864,
            -8.098410632389989
          ],
          [
            -34.886539020707644,
            -8.098513679219499
          ],
          [
            -34.88658500887282,
            -8.098513466554122
          ],
          [
            -34.886550108289654,
            -8.09842578510607
          ]
        ]
      ]
    }
  },
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
    "id": 197,
    "properties": {
      "escola_codigo": 95,
      "escola_tipo": "Esc",
      "rpa": 3,
      "escola_nome": "Professor Nilo Pereira",
      "endereco": "Estrada do Arraial, 4900- Casa Amarela",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26126524,
      "qtd_anexos": 1,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais Educ/Esc Aberta",
      "qtd_atendidos": 920,
      "atendimento_especial": "Descoberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92591377401273,
            -8.026892670511197
          ],
          [
            -34.92549842022058,
            -8.026916998787952
          ],
          [
            -34.92548431854565,
            -8.02749906611507
          ],
          [
            -34.92565082417799,
            -8.027487094647775
          ],
          [
            -34.92581911303658,
            -8.027456461300956
          ],
          [
            -34.92591443374188,
            -8.027429899579639
          ],
          [
            -34.92591377401273,
            -8.026892670511197
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 182,
    "properties": {
      "escola_codigo": 113,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Doutor Rodolfo Aureliano",
      "endereco": "Rua Jose Avelar, 211-VÃ¡rzea",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26119641,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 954,
      "atendimento_especial": "Alugada"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.95625999617606,
            -8.041942962697163
          ],
          [
            -34.95610878773973,
            -8.041993031866228
          ],
          [
            -34.95622431987978,
            -8.042398884502322
          ],
          [
            -34.956387108464064,
            -8.042334245681522
          ],
          [
            -34.95625999617606,
            -8.041942962697163
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 170,
    "properties": {
      "escola_codigo": 192,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Luiz Vaz de CamÃµes",
      "endereco": "R ERVAL, S/N, Vila Arquiteta MÂª. LÃºcia- Ipsep",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26119927,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 791,
      "atendimento_especial": "coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92573127185571,
            -8.103615341291034
          ],
          [
            -34.92517762902063,
            -8.103536164082765
          ],
          [
            -34.92516411536319,
            -8.103533437972239
          ],
          [
            -34.92515098314446,
            -8.103541485518917
          ],
          [
            -34.92514538972125,
            -8.103549555327929
          ],
          [
            -34.92511794999969,
            -8.103775814032787
          ],
          [
            -34.92512857358075,
            -8.103799570409528
          ],
          [
            -34.92515062296096,
            -8.10381470327409
          ],
          [
            -34.9257034860054,
            -8.103889109790224
          ],
          [
            -34.92571945327551,
            -8.103882229532969
          ],
          [
            -34.92573195142735,
            -8.103871905835508
          ],
          [
            -34.92576701044042,
            -8.103640353183053
          ],
          [
            -34.92574813644413,
            -8.10361745216375
          ],
          [
            -34.92573127185571,
            -8.103615341291034
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 164,
    "properties": {
      "escola_codigo": 222,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Vila SÃ©samo",
      "endereco": "R Vale do Cariri 290 Cohab UR- 05",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26121158,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais Educacao",
      "qtd_atendidos": 1151,
      "atendimento_especial": "Descoberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.95020751857444,
            -8.133451393255518
          ],
          [
            -34.94997821154123,
            -8.13370267441054
          ],
          [
            -34.95015129247657,
            -8.133859911901544
          ],
          [
            -34.95026030099018,
            -8.133746808084132
          ],
          [
            -34.950136493921605,
            -8.133631409179165
          ],
          [
            -34.9502567933139,
            -8.133493232683696
          ],
          [
            -34.95020751857444,
            -8.133451393255518
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 160,
    "properties": {
      "escola_codigo": 11,
      "escola_tipo": "Esc",
      "rpa": 1,
      "escola_nome": "Padre Antonio Henrique",
      "endereco": "Avenida Viscondessa do Livramento 290 Derby",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26121662,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 356,
      "atendimento_especial": "Campo de Areia"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.90001810158117,
            -8.06110501294006
          ],
          [
            -34.899785239236486,
            -8.061309378505674
          ],
          [
            -34.89987402018828,
            -8.061411849378798
          ],
          [
            -34.899894047030855,
            -8.061439026950845
          ],
          [
            -34.89991157996523,
            -8.061464976601522
          ],
          [
            -34.89992163297819,
            -8.061487241579584
          ],
          [
            -34.89994711447423,
            -8.061617276320613
          ],
          [
            -34.90030244712698,
            -8.061538776240251
          ],
          [
            -34.90023368576815,
            -8.061195740452598
          ],
          [
            -34.90013560305398,
            -8.061232142044814
          ],
          [
            -34.90001810158117,
            -8.06110501294006
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 156,
    "properties": {
      "escola_codigo": 18,
      "escola_tipo": "Esc",
      "rpa": 1,
      "escola_nome": "ColÃ©gio Reitor JoÃ£o Alfredo",
      "endereco": "Rua Senador Jose Henrique 160 -Ilha Do Leite",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26121786,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 1050,
      "atendimento_especial": "Descoberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.89591550559281,
            -8.064426339377073
          ],
          [
            -34.895883607656884,
            -8.064390645005403
          ],
          [
            -34.89556610544558,
            -8.064349947424297
          ],
          [
            -34.89555966122632,
            -8.064328894241113
          ],
          [
            -34.89526545718941,
            -8.064294413501443
          ],
          [
            -34.89505583055521,
            -8.06515980202156
          ],
          [
            -34.895675557481745,
            -8.06514006794311
          ],
          [
            -34.895698817300634,
            -8.065137851994285
          ],
          [
            -34.89577179416183,
            -8.06490981332396
          ],
          [
            -34.89574852544122,
            -8.064909921015087
          ],
          [
            -34.89591550559281,
            -8.064426339377073
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 148,
    "properties": {
      "escola_codigo": 103,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Arraial Novo do Bom Jesus",
      "endereco": "Estrada do Forte do Arraial Novo do Bom Jesus, 1340-TorrÃµes",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26127369,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 828,
      "atendimento_especial": "Descoberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.932267379794155,
            -8.058549046278392
          ],
          [
            -34.93216990918443,
            -8.058391042878638
          ],
          [
            -34.93155804888171,
            -8.058725377609658
          ],
          [
            -34.93169306109533,
            -8.058976961177072
          ],
          [
            -34.93216083906358,
            -8.058713292797263
          ],
          [
            -34.93211542839703,
            -8.058636917069956
          ],
          [
            -34.932267379794155,
            -8.058549046278392
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
    "id": 132,
    "properties": {
      "escola_codigo": 89,
      "escola_tipo": "Esc",
      "rpa": 3,
      "escola_nome": "PresbÃ­tero JosÃ© Bezerra",
      "endereco": "Avenida Norte 7123  Macaxeira",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26126419,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 595,
      "atendimento_especial": "coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93131476396929,
            -8.014936959882872
          ],
          [
            -34.931010258890986,
            -8.014866496186098
          ],
          [
            -34.9309810225083,
            -8.014983846979664
          ],
          [
            -34.93104862859044,
            -8.015023382857882
          ],
          [
            -34.9311513902635,
            -8.015036966634908
          ],
          [
            -34.93115444823623,
            -8.015020542754078
          ],
          [
            -34.93121538247084,
            -8.015033136402284
          ],
          [
            -34.93122512900257,
            -8.015037003487478
          ],
          [
            -34.93123366731883,
            -8.01503815411716
          ],
          [
            -34.931238504237776,
            -8.015038150434425
          ],
          [
            -34.93124605714666,
            -8.015036903600844
          ],
          [
            -34.93125329829501,
            -8.015035707951366
          ],
          [
            -34.93129096688226,
            -8.015044126291844
          ],
          [
            -34.93131476396929,
            -8.014936959882872
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 129,
    "properties": {
      "escola_codigo": 57,
      "escola_tipo": "Esc",
      "rpa": 3,
      "escola_nome": "Almerinda de Barros",
      "endereco": "Rua Vasco da Gama S/N Vasco da Gama",
      "tipo_predio": "nada consta",
      "mec_codigo": 0,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais Educ/Projovem",
      "qtd_atendidos": 1286,
      "atendimento_especial": "descoberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.920872894375684,
            -8.009836500584504
          ],
          [
            -34.92081798762802,
            -8.0099865722767
          ],
          [
            -34.92068415398716,
            -8.009972213554226
          ],
          [
            -34.92058967851426,
            -8.010338205258053
          ],
          [
            -34.92094061206518,
            -8.010495374589073
          ],
          [
            -34.92102245299675,
            -8.010319709033585
          ],
          [
            -34.92112774433488,
            -8.01033719666767
          ],
          [
            -34.92120070688655,
            -8.010191534921288
          ],
          [
            -34.92145926505292,
            -8.010200817261673
          ],
          [
            -34.92151866598374,
            -8.010047728526109
          ],
          [
            -34.92119644372201,
            -8.009923384397718
          ],
          [
            -34.921183071926905,
            -8.00995640612258
          ],
          [
            -34.920872894375684,
            -8.009836500584504
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
    "id": 107,
    "properties": {
      "escola_codigo": 214,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "ProfÂº. Solano MagalhÃ£es",
      "endereco": "Rua Jemil Asfora SN Pina",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26154820,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 377,
      "atendimento_especial": "coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.89348311323871,
            -8.087276172847355
          ],
          [
            -34.89329979006311,
            -8.087298115473665
          ],
          [
            -34.89337335530539,
            -8.087944611489934
          ],
          [
            -34.893546065010405,
            -8.087915687886449
          ],
          [
            -34.89348311323871,
            -8.087276172847355
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 104,
    "properties": {
      "escola_codigo": 209,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "ProfÂº. Florestan Fernandes",
      "endereco": "Rua Rio Novo do Sul, 541- Ibura de Baixo",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26139090,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Nada Consta",
      "qtd_atendidos": 1040,
      "atendimento_especial": "Descoberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.94256566362308,
            -8.115610000793309
          ],
          [
            -34.94239514224941,
            -8.115616939327078
          ],
          [
            -34.94241124359772,
            -8.11609000140538
          ],
          [
            -34.942594042760355,
            -8.116079942221361
          ],
          [
            -34.94256566362308,
            -8.115610000793309
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
    "id": 66,
    "properties": {
      "escola_codigo": 138,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "Dom Bosco",
      "endereco": "Rua Alvenopolis 600 Jardim Sao Paulo",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26123487,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 1060,
      "atendimento_especial": "coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.948360395762606,
            -8.078807063651924
          ],
          [
            -34.94782794733642,
            -8.079170858134802
          ],
          [
            -34.94852808947409,
            -8.07981723052229
          ],
          [
            -34.94854956415318,
            -8.079814873490287
          ],
          [
            -34.94897273752599,
            -8.079390212377726
          ],
          [
            -34.94897491328598,
            -8.079372169002708
          ],
          [
            -34.948360395762606,
            -8.078807063651924
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 57,
    "properties": {
      "escola_codigo": 109,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Divino EspÃ­rito Santo",
      "endereco": "PraÃ§a  do  Caxanga, 127- CaxangÃ¡",
      "tipo_predio": "Alugado",
      "mec_codigo": 26127520,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "sim",
      "laboratorio_informatica": 20,
      "sala_professora": "nao",
      "prog": "Mais Educ/Pro-Jovem",
      "qtd_atendidos": 409,
      "atendimento_especial": "coberta"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.95446624124649,
            -8.030052727790133
          ],
          [
            -34.95379733342861,
            -8.029831936468108
          ],
          [
            -34.95376523955925,
            -8.030871425547527
          ],
          [
            -34.95405405112302,
            -8.030810944325943
          ],
          [
            -34.95407168887798,
            -8.030882284618505
          ],
          [
            -34.95503680558728,
            -8.030668353087338
          ],
          [
            -34.954940732157084,
            -8.03021317661457
          ],
          [
            -34.95480710469368,
            -8.030171942663937
          ],
          [
            -34.95446624124649,
            -8.030052727790133
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
