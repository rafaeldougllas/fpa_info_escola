package com.rafaelbarreto.infoescola

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class EscolaAdapter(private val context: Context,
                    private val dataSource: ArrayList<Escola>) : BaseAdapter() {


    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        // 1
        if (convertView == null) {

            // 2
            view = inflater.inflate(R.layout.list_item_escola, parent, false)

            // 3
            holder = ViewHolder()
            holder.thumbnailImageView = view.findViewById(R.id.school_list_thumbnail) as ImageView
            holder.nameTextView = view.findViewById(R.id.school_list_name) as TextView
            holder.addressTextView = view.findViewById(R.id.school_list_address) as TextView

            // 4
            view.tag = holder
        } else {
            // 5
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        // 6
        val nameTextView = holder.nameTextView
        val addressTextView = holder.addressTextView
        val thumbnailImageView = holder.thumbnailImageView

        val escola = getItem(position) as Escola

        nameTextView.text = escola.escola_nome
        addressTextView.text = escola.endereco

        Picasso.with(context).load(escola.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        //Muda as fontes
        val titleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_bold)
        nameTextView.typeface = titleTypeFace
        val subtitleTypeFace = ResourcesCompat.getFont(context, R.font.josefinsans_semibolditalic)
        addressTextView.typeface = subtitleTypeFace

        return view
    }

    private class ViewHolder {
        lateinit var nameTextView: TextView
        lateinit var addressTextView: TextView
        lateinit var thumbnailImageView: ImageView
    }

}