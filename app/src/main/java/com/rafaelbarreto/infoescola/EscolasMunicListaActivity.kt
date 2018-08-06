package com.rafaelbarreto.infoescola

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson

class EscolasMunicListaActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolas_munic_lista)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.menu_item_schools)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Creating a listview and filling with datas
        val schoolList = getDatas()

        listView = findViewById<ListView>(R.id.school_list_view_public_schools)
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
              "tipo_predio": "Próprio",
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
            "id": 338,
            "properties": {
              "escola_codigo": 121,
              "escola_tipo": "Esc",
              "rpa": 4,
              "escola_nome": "Nova Morada",
              "endereco": "Rua Eliane Fragoso do Nascimento, 24 - Caxangá - Nova Morada",
              "tipo_predio": "Alugado",
              "mec_codigo": 26177978,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 497,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.95255474602192,
                    -8.025668051490785
                  ],
                  [
                    -34.95235738952169,
                    -8.025635977423324
                  ],
                  [
                    -34.95234202070685,
                    -8.02572757959109
                  ],
                  [
                    -34.952539373670504,
                    -8.025758903314138
                  ],
                  [
                    -34.95255474602192,
                    -8.025668051490785
                  ]
                ]
              ]
            }
          },
          {
            "type": "Feature",
            "id": 336,
            "properties": {
              "escola_codigo": 45,
              "escola_tipo": "Esc",
              "rpa": 2,
              "escola_nome": "Pastor Paulo Leivas Macalao",
              "endereco": "Rua Alterosa  27 Linha do Tiro",
              "tipo_predio": "Próprio",
              "mec_codigo": 26126427,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "MaisEduc/EscAb/Pjov",
              "qtd_atendidos": 514,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.908717180632514,
                    -8.012082477877387
                  ],
                  [
                    -34.9087059993413,
                    -8.012175132557198
                  ],
                  [
                    -34.908958988083086,
                    -8.012215810471405
                  ],
                  [
                    -34.908975491237726,
                    -8.012115117485008
                  ],
                  [
                    -34.908717180632514,
                    -8.012082477877387
                  ]
                ]
              ]
            }
          },
          {
            "type": "Feature",
            "id": 335,
            "properties": {
              "escola_codigo": 212,
              "escola_tipo": "Esc",
              "rpa": 6,
              "escola_nome": "ProfÂº. Manoel Torres",
              "endereco": "R Eládio Ramos, 232-  Imbiribeira",
              "tipo_predio": "Alugado",
              "mec_codigo": 26124661,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "mais EducaÃ§Ã£o",
              "qtd_atendidos": 310,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.911830004360816,
                    -8.128467647152195
                  ],
                  [
                    -34.91157043112595,
                    -8.128521625407553
                  ],
                  [
                    -34.91159294209818,
                    -8.12863109291421
                  ],
                  [
                    -34.91185332917526,
                    -8.128577110801643
                  ],
                  [
                    -34.911830004360816,
                    -8.128467647152195
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
              "endereco": "Avenida Engº Domingos Ferreira 1040  Pina",
              "tipo_predio": "Próprio",
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
              "tipo_predio": "Próprio",
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
              "tipo_predio": "Próprio",
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
              "tipo_predio": "Próprio",
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
              "tipo_predio": "Próprio",
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
            "id": 274,
            "properties": {
              "escola_codigo": 0,
              "escola_tipo": "EP",
              "rpa": 5,
              "escola_nome": "Escola Profissionalizante de Areias",
              "endereco": "Rua Ipojuca  257 Areias",
              "tipo_predio": "Proprio",
              "mec_codigo": 0,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "sim",
              "prog": null,
              "qtd_atendidos": 0,
              "atendimento_especial": "nenhuma"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.93599193774193,
                    -8.093991362723939
                  ],
                  [
                    -34.93598214700116,
                    -8.093982665169765
                  ],
                  [
                    -34.93597138199747,
                    -8.093973972236151
                  ],
                  [
                    -34.93596162373197,
                    -8.093972074807153
                  ],
                  [
                    -34.935784222136675,
                    -8.093977774550602
                  ],
                  [
                    -34.93579286048,
                    -8.094153583485571
                  ],
                  [
                    -34.9360004694617,
                    -8.094144826684134
                  ],
                  [
                    -34.93599193774193,
                    -8.093991362723939
                  ]
                ]
              ]
            }
          },
          {
            "type": "Feature",
            "id": 273,
            "properties": {
              "escola_codigo": 0,
              "escola_tipo": "EP",
              "rpa": 5,
              "escola_nome": "Escola Profissionalizante Bidu Krause",
              "endereco": "Rua Onze de Agosto SN Curado",
              "tipo_predio": "Próprio",
              "mec_codigo": 0,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "Sim",
              "prog": null,
              "qtd_atendidos": 0,
              "atendimento_especial": "Nenhuma"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.97010358474206,
                    -8.079244368082621
                  ],
                  [
                    -34.96988452624787,
                    -8.07957765634211
                  ],
                  [
                    -34.970076080756584,
                    -8.079704634484022
                  ],
                  [
                    -34.97033246597816,
                    -8.079322813977575
                  ],
                  [
                    -34.97023039782764,
                    -8.079253115632577
                  ],
                  [
                    -34.97019462144823,
                    -8.07929852140121
                  ],
                  [
                    -34.97010358474206,
                    -8.079244368082621
                  ]
                ]
              ]
            }
          },
          {
            "type": "Feature",
            "id": 212,
            "properties": {
              "escola_codigo": 142,
              "escola_tipo": "Esc",
              "rpa": 5,
              "escola_nome": "Hugo Gerdau",
              "endereco": "Rua Coronel Mizael de MendonÃ§a SN San Martin",
              "tipo_predio": "Próprio",
              "mec_codigo": 26120810,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 20,
              "sala_professora": "nao",
              "prog": "Mais EducaÃ§Ã£o",
              "qtd_atendidos": 620,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.93651079586507,
                    -8.069645528747525
                  ],
                  [
                    -34.936448993056636,
                    -8.069630440445385
                  ],
                  [
                    -34.93644909769441,
                    -8.069652412953726
                  ],
                  [
                    -34.93648224038272,
                    -8.069667636828633
                  ],
                  [
                    -34.93651079586507,
                    -8.069645528747525
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
              "tipo_predio": "Próprio",
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
            "id": 209,
            "properties": {
              "escola_codigo": 47,
              "escola_tipo": "Esc",
              "rpa": 2,
              "escola_nome": "Poeta Solane Trindade",
              "endereco": "Rua da Regeneracao 103 Agua Fria",
              "tipo_predio": "Nada Consta",
              "mec_codigo": 26177960,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 200,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.89238034872176,
                    -8.01871238718649
                  ],
                  [
                    -34.89226601200585,
                    -8.018770472339654
                  ],
                  [
                    -34.8924208213535,
                    -8.019011513196125
                  ],
                  [
                    -34.89254401750715,
                    -8.018948074022527
                  ],
                  [
                    -34.8925439069408,
                    -8.018924165305531
                  ],
                  [
                    -34.89238034872176,
                    -8.01871238718649
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
              "tipo_predio": "Próprio",
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
              "tipo_predio": "Próprio",
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
            "id": 204,
            "properties": {
              "escola_codigo": 125,
              "escola_tipo": "Esc",
              "rpa": 4,
              "escola_nome": "Senador JosÃ© ErmÃ­rio de Moraes",
              "endereco": "Rua Roraima, 30- Ur 07/Várzea",
              "tipo_predio": "Próprio",
              "mec_codigo": 26119170,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 651,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.97936468212822,
                    -8.035814002284583
                  ],
                  [
                    -34.979294788763774,
                    -8.035855982165502
                  ],
                  [
                    -34.97946183719061,
                    -8.036128634665243
                  ],
                  [
                    -34.97948034528441,
                    -8.036116051814878
                  ],
                  [
                    -34.979521030639944,
                    -8.03617739602105
                  ],
                  [
                    -34.97956500210165,
                    -8.03615081003232
                  ],
                  [
                    -34.97936468212822,
                    -8.035814002284583
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
              "endereco": "Rua Barao de Cerro Largo ,S/N- Várzea",
              "tipo_predio": "Próprio",
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
            "id": 202,
            "properties": {
              "escola_codigo": 129,
              "escola_tipo": "Esc",
              "rpa": 4,
              "escola_nome": "Zumbi dos Palmares",
              "endereco": "Rua Engenheiro Vasconcelos Bittencourt, 35- Várzea",
              "tipo_predio": "Próprio",
              "mec_codigo": 26119200,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 687,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.95190700211594,
                    -8.040781268330525
                  ],
                  [
                    -34.95161024253341,
                    -8.040940461422299
                  ],
                  [
                    -34.951670242710364,
                    -8.041044245626505
                  ],
                  [
                    -34.95181022106723,
                    -8.040968605318438
                  ],
                  [
                    -34.951900828811596,
                    -8.041133791491658
                  ],
                  [
                    -34.95204977318423,
                    -8.041054751779763
                  ],
                  [
                    -34.95190700211594,
                    -8.040781268330525
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
              "tipo_predio": "Próprio",
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
            "id": 200,
            "properties": {
              "escola_codigo": 115,
              "escola_tipo": "Esc",
              "rpa": 4,
              "escola_nome": "Henfil",
              "endereco": "Rua Seis de MarÃ§o, 10-Várzea",
              "tipo_predio": "Próprio",
              "mec_codigo": 26127873,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 234,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.953491109014905,
                    -8.045250815227659
                  ],
                  [
                    -34.95348141909652,
                    -8.045286601842967
                  ],
                  [
                    -34.95353363976323,
                    -8.045333709059483
                  ],
                  [
                    -34.9535882156932,
                    -8.045653058168012
                  ],
                  [
                    -34.953715238584785,
                    -8.04563418298355
                  ],
                  [
                    -34.9536597256524,
                    -8.045267883188712
                  ],
                  [
                    -34.953491109014905,
                    -8.045250815227659
                  ]
                ]
              ]
            }
          },
          {
            "type": "Feature",
            "id": 199,
            "properties": {
              "escola_codigo": 100,
              "escola_tipo": "Esc",
              "rpa": 3,
              "escola_nome": "Severina Lyra",
              "endereco": "Rua Jundiá, 122-Tamarineira",
              "tipo_predio": "Alugado",
              "mec_codigo": 26122308,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 233,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.90350930472467,
                    -8.03139896138825
                  ],
                  [
                    -34.90323943478631,
                    -8.031083598242438
                  ],
                  [
                    -34.903189442648554,
                    -8.03118814042007
                  ],
                  [
                    -34.90315906326187,
                    -8.031274183141564
                  ],
                  [
                    -34.90336951670266,
                    -8.031521099241246
                  ],
                  [
                    -34.90350930472467,
                    -8.03139896138825
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
              "tipo_predio": "Próprio",
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
              "tipo_predio": "Próprio",
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
            "id": 196,
            "properties": {
              "escola_codigo": 104,
              "escola_tipo": "Esc",
              "rpa": 4,
              "escola_nome": "CasarÃ£o do Barbalho",
              "endereco": "Estrada do Barbalho, 1595 -Iputinga",
              "tipo_predio": "Próprio",
              "mec_codigo": 26127016,
              "qtd_anexos": 0,
              "existe_biblioteca": "nao",
              "existe_quadra": "nao",
              "laboratorio_informatica": 10,
              "sala_professora": "nao",
              "prog": "nao",
              "qtd_atendidos": 128,
              "atendimento_especial": "nenhum"
            },
            "geometry": {
              "type": "Polygon",
              "coordinates": [
                [
                  [
                    -34.935136976735414,
                    -8.028600806386603
                  ],
                  [
                    -34.934407799711174,
                    -8.028550699179972
                  ],
                  [
                    -34.9343616783016,
                    -8.029073533320595
                  ],
                  [
                    -34.93508616330642,
                    -8.029212889082276
                  ],
                  [
                    -34.935136976735414,
                    -8.028600806386603
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
