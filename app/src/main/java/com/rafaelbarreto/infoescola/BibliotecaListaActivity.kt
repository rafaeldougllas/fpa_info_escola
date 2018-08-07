package com.rafaelbarreto.infoescola

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson

class BibliotecaListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biblioteca_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_library)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = findViewById<ListView>(R.id.school_list_view_library)
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
    "id": 341,
    "properties": {
      "escola_codigo": 178,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Futuro Feliz",
      "endereco": "Rua Ibirajuba, 440 - Cohab - TrÃªs Carneiros",
      "tipo_predio": "PrÃ³prio",
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
  },
  {
    "type": "Feature",
    "id": 340,
    "properties": {
      "escola_codigo": 170,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Cristiano Cordeiro",
      "endereco": "Avenida Santos, S/N - UR-2 - Cohab",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26133837,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 829,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.95406351872419,
            -8.114933122077696
          ],
          [
            -34.95397702033973,
            -8.11490961535367
          ],
          [
            -34.95395409310251,
            -8.114921872092326
          ],
          [
            -34.95395069793552,
            -8.114934732110257
          ],
          [
            -34.95394441335015,
            -8.114935388771721
          ],
          [
            -34.95393712262944,
            -8.114922892834773
          ],
          [
            -34.953920018155394,
            -8.11492434363954
          ],
          [
            -34.95391044870945,
            -8.114910187967936
          ],
          [
            -34.95388580311681,
            -8.114921667337105
          ],
          [
            -34.953872355752,
            -8.114891435614366
          ],
          [
            -34.95385903282221,
            -8.114886765985478
          ],
          [
            -34.953864627361106,
            -8.11486496347816
          ],
          [
            -34.953782810319346,
            -8.114841687373357
          ],
          [
            -34.95376975272558,
            -8.114891927982377
          ],
          [
            -34.95364415211731,
            -8.114851820754312
          ],
          [
            -34.9536524734929,
            -8.114804442468037
          ],
          [
            -34.9535982759079,
            -8.114795235391423
          ],
          [
            -34.9535657288471,
            -8.11494119186059
          ],
          [
            -34.95357243879607,
            -8.114953467295019
          ],
          [
            -34.95376234632405,
            -8.1151286516782
          ],
          [
            -34.954077942457474,
            -8.114969029199614
          ],
          [
            -34.95406351872419,
            -8.114933122077696
          ]
        ]
      ]
    }
  },
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
    "id": 330,
    "properties": {
      "escola_codigo": 190,
      "escola_tipo": "Esc",
      "rpa": 6,
      "escola_nome": "Lagoa  Encantada",
      "endereco": "Rua Doutor Benigno JordÃ£o de Vasconcelos, S/N-UR 02-Cohab",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26124114,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 256,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.952127055993955,
            -8.116915412553352
          ],
          [
            -34.952100047064945,
            -8.116902116140638
          ],
          [
            -34.95206008430502,
            -8.116996287564046
          ],
          [
            -34.95210723670555,
            -8.116996061434996
          ],
          [
            -34.952127055993955,
            -8.116915412553352
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
    "id": 324,
    "properties": {
      "escola_codigo": 58,
      "escola_tipo": "Esc",
      "rpa": 3,
      "escola_nome": "Boa Esperanca",
      "endereco": "Rua Pedra Bonita 80 Vasco da Gama",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26126869,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "nao",
      "qtd_atendidos": 350,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92001035184284,
            -8.018636536571547
          ],
          [
            -34.91980948389308,
            -8.018712894295437
          ],
          [
            -34.919838422849196,
            -8.018804029128495
          ],
          [
            -34.920059047307404,
            -8.018731405284862
          ],
          [
            -34.92001035184284,
            -8.018636536571547
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 323,
    "properties": {
      "escola_codigo": 114,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Engenho do Meio",
      "endereco": "Rua Bom Pastor, 1406-Engenho do Meio",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26127377,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 20,
      "sala_professora": "nao",
      "prog": "PrÃ³-Jovem",
      "qtd_atendidos": 732,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93963859058343,
            -8.04955414915334
          ],
          [
            -34.939616417640345,
            -8.049563110951826
          ],
          [
            -34.939404132282384,
            -8.050237238875168
          ],
          [
            -34.93968219188617,
            -8.050313421696547
          ],
          [
            -34.939712734813284,
            -8.050195924150275
          ],
          [
            -34.939568135458366,
            -8.050154536702765
          ],
          [
            -34.93966253767192,
            -8.049819876047431
          ],
          [
            -34.93981776706229,
            -8.049858865414961
          ],
          [
            -34.939898677983265,
            -8.049588347729378
          ],
          [
            -34.93963859058343,
            -8.04955414915334
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 284,
    "properties": {
      "escola_codigo": 146,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "Lojistas do Recife",
      "endereco": "Avenida Getulio Vargas 2501 Curado/ ROD BR 232 Km 07",
      "tipo_predio": "Cedido",
      "mec_codigo": 26123622,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": null,
      "laboratorio_informatica": 10,
      "sala_professora": null,
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 440,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.96588520368599,
            -8.07623456612389
          ],
          [
            -34.96542672112346,
            -8.076123678783514
          ],
          [
            -34.965180531479604,
            -8.076949408996285
          ],
          [
            -34.96566171733104,
            -8.077080406993888
          ],
          [
            -34.96588520368599,
            -8.07623456612389
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 245,
    "properties": {
      "escola_codigo": 0,
      "escola_tipo": "EP",
      "rpa": 3,
      "escola_nome": "Escola Profissionalizante Moacir do Melo Rego",
      "endereco": "Rua Vasco da Gama SN Casa Amarela",
      "tipo_predio": null,
      "mec_codigo": 0,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 0,
      "sala_professora": "sim",
      "prog": null,
      "qtd_atendidos": 0,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92156423971058,
            -8.009954904862932
          ],
          [
            -34.920975348229206,
            -8.009726051266407
          ],
          [
            -34.920926702348986,
            -8.009855416967511
          ],
          [
            -34.92117984938867,
            -8.009953493780953
          ],
          [
            -34.92119574962395,
            -8.009919266912643
          ],
          [
            -34.92152614046625,
            -8.010050068667752
          ],
          [
            -34.92156423971058,
            -8.009954904862932
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 208,
    "properties": {
      "escola_codigo": 156,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "Sancho",
      "endereco": "Rua Joao Ferreira 427 Sancho",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26168120,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 426,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.96030455625074,
            -8.087048911356895
          ],
          [
            -34.96020041914137,
            -8.087060227895254
          ],
          [
            -34.96007900177899,
            -8.087088932451897
          ],
          [
            -34.96007891074955,
            -8.087519423103485
          ],
          [
            -34.96025460458884,
            -8.08749262142799
          ],
          [
            -34.96035868954168,
            -8.087470489169739
          ],
          [
            -34.96030455625074,
            -8.087048911356895
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 207,
    "properties": {
      "escola_codigo": 159,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "TejipiÃ³",
      "endereco": "Rua Tutoia 165  Coqueiral",
      "tipo_predio": "Cedido",
      "mec_codigo": 26123550,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 714,
      "atendimento_especial": "Nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.96463559029267,
            -8.091944875396736
          ],
          [
            -34.96453108685854,
            -8.091868959081111
          ],
          [
            -34.96435905897548,
            -8.092119801066906
          ],
          [
            -34.96457952545863,
            -8.09229233438075
          ],
          [
            -34.96476841511017,
            -8.092004616857883
          ],
          [
            -34.96464967599784,
            -8.09192122128246
          ],
          [
            -34.96463559029267,
            -8.091944875396736
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 206,
    "properties": {
      "escola_codigo": 128,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Vila Santa Luzia",
      "endereco": "Rua Elizeu Cavalcante, 52- Cordeiro",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26153475,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 704,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.92101530755141,
            -8.049305766602258
          ],
          [
            -34.92089643231793,
            -8.049373337511472
          ],
          [
            -34.92085856045769,
            -8.049443575936952
          ],
          [
            -34.92097171429157,
            -8.049917936241977
          ],
          [
            -34.920997845304086,
            -8.0499143387026
          ],
          [
            -34.92099765039135,
            -8.049943233420871
          ],
          [
            -34.921149521992454,
            -8.049899132001944
          ],
          [
            -34.92106871188021,
            -8.0496131750657
          ],
          [
            -34.921152548647356,
            -8.049568613764105
          ],
          [
            -34.92101530755141,
            -8.049305766602258
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 205,
    "properties": {
      "escola_codigo": 123,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Professora Elizabeth Sales Coutinho de Barros-TorrÃµes",
      "endereco": "Rua Professor Avertano Rocha, 386- TorrÃµes",
      "tipo_predio": "Cedido",
      "mec_codigo": 26121050,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 338,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93413825107303,
            -8.067238217821673
          ],
          [
            -34.93393567534885,
            -8.067287611096905
          ],
          [
            -34.93397927744122,
            -8.067415949920923
          ],
          [
            -34.93417065673957,
            -8.067370335102854
          ],
          [
            -34.93413825107303,
            -8.067238217821673
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 203,
    "properties": {
      "escola_codigo": 122,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Professor JoÃ£o Batista Lippo Neto",
      "endereco": "Rua Barao de Cerro Largo ,S/N- VÃ¡rzea",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26157845,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 326,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.99038442165189,
            -8.035370042519135
          ],
          [
            -34.990069863039764,
            -8.035184945585385
          ],
          [
            -34.98986670188694,
            -8.035528864169445
          ],
          [
            -34.990222533098176,
            -8.035645174738686
          ],
          [
            -34.99038442165189,
            -8.035370042519135
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 201,
    "properties": {
      "escola_codigo": 106,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "Creuza de Freitas Cavalcanti",
      "endereco": "Rua Epaminondas CristovÃ£o de Oliveira, S/N- TorrÃµes",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26127008,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais Educ/PrÃ³-Jovem",
      "qtd_atendidos": 803,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93586008785837,
            -8.061150425158988
          ],
          [
            -34.93552719305447,
            -8.061283765232274
          ],
          [
            -34.93563363862397,
            -8.061552787932586
          ],
          [
            -34.93596952442523,
            -8.061416438471744
          ],
          [
            -34.93586008785837,
            -8.061150425158988
          ]
        ]
      ]
    }
  },
  {
    "type": "Feature",
    "id": 198,
    "properties": {
      "escola_codigo": 118,
      "escola_tipo": "Esc",
      "rpa": 4,
      "escola_nome": "JoÃ£o XXIII",
      "endereco": "Est Do Caiara, 350-Iputinga",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26119897,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 769,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.93080613262767,
            -8.041317715420094
          ],
          [
            -34.930493164473965,
            -8.041485287844313
          ],
          [
            -34.93050017977691,
            -8.041510456366387
          ],
          [
            -34.9306161101505,
            -8.04172183419935
          ],
          [
            -34.930930157121836,
            -8.041539364958709
          ],
          [
            -34.93080613262767,
            -8.041317715420094
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
    "id": 189,
    "properties": {
      "escola_codigo": 160,
      "escola_tipo": "Esc",
      "rpa": 5,
      "escola_nome": "Vila SÃ£o Miguel",
      "endereco": "Rua Rubiacea, 147, Afogados",
      "tipo_predio": "PrÃ³prio",
      "mec_codigo": 26123126,
      "qtd_anexos": 0,
      "existe_biblioteca": "sim",
      "existe_quadra": "nao",
      "laboratorio_informatica": 10,
      "sala_professora": "nao",
      "prog": "Mais EducaÃ§Ã£o",
      "qtd_atendidos": 455,
      "atendimento_especial": "nenhum"
    },
    "geometry": {
      "type": "Polygon",
      "coordinates": [
        [
          [
            -34.91278558646455,
            -8.084117264210706
          ],
          [
            -34.91267011785251,
            -8.084095158743267
          ],
          [
            -34.91263086894244,
            -8.084297414400718
          ],
          [
            -34.9126710809978,
            -8.084299548736126
          ],
          [
            -34.91275092911369,
            -8.084304981813487
          ],
          [
            -34.91278558646455,
            -8.084117264210706
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
