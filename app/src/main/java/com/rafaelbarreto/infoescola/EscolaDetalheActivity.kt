package com.rafaelbarreto.infoescola

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_escola_detalhe.*

class EscolaDetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escola_detalhe)

        //Top of view
        supportActionBar?.title = resources.getString(R.string.school_detail_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Change the fonts
        val titleTypeFace = ResourcesCompat.getFont(this, R.font.josefinsans_bold)
        detail_school_name.typeface = titleTypeFace
        val subtitleTypeFace = ResourcesCompat.getFont(this, R.font.josefinsans_semibolditalic)
        detail_label_address.typeface = subtitleTypeFace

        //Setting texts in xml
        detail_label_address.text = resources.getString(R.string.address) //TODO VERIFICAR OUTRA POSSIBILIDADE OU FAZER ISSO PRA TUDO
        detail_label_edu_profe.typeface = subtitleTypeFace
        detail_label_edu_profe.text = resources.getString(R.string.menu_item_professional_edu)
        detail_label_has_meals.typeface = subtitleTypeFace
        detail_label_has_meals.text = resources.getString(R.string.menu_item_meals)
        detail_label_lab_computer.typeface = subtitleTypeFace
        detail_label_lab_computer.text = resources.getString(R.string.menu_item_lab_comp)
        detail_label_library.typeface = subtitleTypeFace
        detail_label_library.text = resources.getString(R.string.menu_item_library)
        detail_label_special_attention.typeface = subtitleTypeFace
        detail_label_special_attention.text = resources.getString(R.string.menu_item_accessibility)
        detail_label_sports_court.typeface = subtitleTypeFace
        detail_label_sports_court.text = resources.getString(R.string.menu_item_sports_court)

        //Recovery the object passed on intent
        val schoolObj = intent.extras.getParcelable<Escola>("SCHOOL_OBJ_SELECTED")

        //Setting info`s object in xml
        detail_school_name.text = schoolObj.escola_nome
        detail_address.text = schoolObj.endereco
        detail_edu_profe.text = "Teste"
        detail_has_meals.text = "Teste"
        detail_lab_computer.text = "Teste"
        detail_library.text = "Teste"
        detail_special_attention.text = "Teste"
        detail_sports_court.text = "Teste"

        //Adding listener event in button
        button_how_get_there.setOnClickListener{
            openLocationScreen(this)
        }
    }

    //To make back button work in many listViewsActivities
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        this.finish() /* Close activity */

        return super.onOptionsItemSelected(item)
    }

    //To open map screen with school`s location
    fun openLocationScreen(context: Activity){
        val intent = Intent(this, LocationActivity::class.java)
        context.startActivity(intent)
    }
}
