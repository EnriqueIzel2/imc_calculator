package com.enrique.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.enrique.imccalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val btn_calculate = binding.btnCalculate
    val txt_message = binding.txtMessage

    btn_calculate.setOnClickListener {
      val editWeight = binding.editWeight.text.toString()
      val editHeight = binding.editHeight.text.toString()

      if (editWeight.isEmpty() || editHeight.isEmpty()) {
        txt_message.setText("Preencha todos os campos")
      } else {
        calculateIMC(editWeight.toInt(), editHeight.toFloat())
      }
    }
  }

  private fun calculateIMC(weight: Int, height: Float) {
    val resultMessage = binding.txtMessage
    val imc = weight / (height * height)

    val imcMessage = when {
      imc <= 18.5 -> "Peso Abaixo"
      imc <= 24.9 -> "Peso Normal"
      imc <= 29.9 -> "Sobrepeso"
      imc <= 34.9 -> "Obesidade (Grau 1)"
      imc <= 39.9 -> "Obesidade (Grau 2)"
      else -> "Obesidade Mórbida"
    }

    resultMessage.setText("IMC: ${imc.toString()} \n $imcMessage")
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflate = menuInflater
    inflate.inflate(R.menu.main_menu, menu)

    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      R.id.refresh -> {
        val cleanEditWeight = binding.editWeight
        val cleanEditHeight = binding.editHeight
        val cleanMessage = binding.txtMessage

        cleanEditWeight.setText("")
        cleanEditHeight.setText("")
        cleanMessage.setText("")
      }
    }

    return super.onOptionsItemSelected(item)
  }
}