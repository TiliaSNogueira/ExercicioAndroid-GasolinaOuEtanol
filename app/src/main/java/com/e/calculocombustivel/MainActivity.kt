package com.e.calculocombustivel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.e.calculocombustivel.R.drawable.abasteca_etanol
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val valorGasolina = 0f
    val valorEtanol = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        main_activity_botao_comparar.setOnClickListener {
            

            val valorGasolina = activity_main_edit_valor_gasolina.text.toString()
            getView().hideKeyBoard()
            val valorEtanol = activity_main_edit_valor_etanol.text.toString()
            getView().hideKeyBoard()
            val taxa =  0.7f

            //valor do etanol tem que ser menor do que valor da gasolina * 0.7 para compensar usar o etanol

            if (valorEtanol.toFloat() < valorGasolina.toFloat() * taxa) {
                activity_main_img_resultado.setImageResource(R.drawable.abasteca_etanol)
            } else {
                activity_main_img_resultado.setImageResource(R.drawable.abasteca_gasolina)
            }

            getView().hideKeyBoard()

        }
    }

    //executa a função de tirar o teclado da tela (chamando uma view/activity como referencia)
    private fun View.hideKeyBoard(){
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    //encontra a view/activity atual que o usuário está no momento
    private fun getView(): View {
        return  window.decorView.findViewById(android.R.id.content)
    }

}








