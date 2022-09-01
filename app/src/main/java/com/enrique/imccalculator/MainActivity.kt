package com.enrique.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

      }
    }
  }
}