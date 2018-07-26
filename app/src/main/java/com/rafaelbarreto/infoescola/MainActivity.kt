package com.rafaelbarreto.infoescola

import android.app.Activity
import android.content.Intent
import android.content.res.ColorStateList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import kotlinx.android.synthetic.main.menu_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Esconde o actionbar
        supportActionBar!!.hide()


        lab_comp_card_id.cardBackgroundColor = ColorStateList.valueOf(2)
        //Adiciona os eventos de clique aos cardviews
        lab_comp_card_id.setOnClickListener{
            showComputerLabActivity(lab_comp_card_id,this)
        }
        biblioteca_card_id.setOnClickListener{
            showComputerLabActivity(biblioteca_card_id,this)
        }
        quadra_card_id.setOnClickListener{
            showComputerLabActivity(quadra_card_id,this)
        }
        acessibilidade_card_id.setOnClickListener{
            showComputerLabActivity(acessibilidade_card_id,this)
        }
        educacao_profissional_card_id.setOnClickListener{
            showComputerLabActivity(educacao_profissional_card_id,this)
        }
        refeicoes_card_id.setOnClickListener{
            showComputerLabActivity(refeicoes_card_id,this)
        }
        escolas_munic_card_id.setOnClickListener{
            showComputerLabActivity(escolas_munic_card_id,this)
        }
    }

    fun showComputerLabActivity(item_menu:CardView,context: Activity){
        val intent: Intent
        when (item_menu){
            lab_comp_card_id -> intent = Intent(this, LabComputacaoListaActivity::class.java)
            biblioteca_card_id -> intent = Intent(this, BibliotecaListaActivity::class.java)
            quadra_card_id -> intent = Intent(this, QuadraListaActivity::class.java)
            acessibilidade_card_id -> intent = Intent(this, AcessibilidadeListaActivity::class.java)
            educacao_profissional_card_id -> intent = Intent(this, EducacaoProfissionalListaActivity::class.java)
            refeicoes_card_id -> intent = Intent(this, RefeicoesListaActivity::class.java)
            escolas_munic_card_id -> intent = Intent(this, EscolasMunicListaActivity::class.java)
            else -> intent = Intent(this, LabComputacaoListaActivity::class.java)
        }
        context.startActivity(intent)
    }
}
