package com.rafaelbarreto.infoescola

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PropertiesSchool(
        val escola_codigo: Int,
        val escola_tipo: String,
        val rpa: Int,
        val escola_nome: String,
        val endereco: String,
        val tipo_predio: String,
        val mec_codigo: Int,
        val qtd_anexos: Int,
        val existe_biblioteca: String,
        val existe_quadra: String,
        val laboratorio_informatica: Int,
        val sala_professora: String,
        val prog: String,
        val qtd_atendidos: Int,
        val atendimento_especial: String
) : Parcelable