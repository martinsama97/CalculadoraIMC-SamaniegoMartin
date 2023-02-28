package samaniego.martin.asignacion4_calculadoraimc_samaniegomartin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val estatura : EditText = findViewById(R.id.etEstatura) as EditText
        val peso : EditText = findViewById(R.id.etPeso) as EditText
        val calcular : Button = findViewById(R.id.btnCalcular) as Button
        val resultado : TextView = findViewById(R.id.tvResultado) as TextView
        val rango : TextView = findViewById(R.id.tvRango) as TextView


        calcular.setOnClickListener {
            val height = estatura.text.toString().toDouble()
            val weight = peso.text.toString().toDouble()

            val imc = calcularIMC(height, weight)

            if (imc < 18.5) {
                resultado.setText(imc.toString())
                rango.setText("Bajo peso")
                rango.setBackgroundResource(R.color.colorGreenish)
            } else if(imc <= 24.9) {
                resultado.setText(imc.toString())
                rango.setText("Normal")
                rango.setBackgroundResource(R.color.colorGreen)
            } else if(imc <= 29.9) {
                resultado.setText(imc.toString())
                rango.setText("Sobrepeso")
                rango.setBackgroundResource(R.color.colorYellow)
            } else if(imc <= 34.9) {
                resultado.setText(imc.toString())
                rango.setText("Obesidad grado 1")
                rango.setBackgroundResource(R.color.colorOrange)
            } else if(imc <= 39.9) {
                resultado.setText(imc.toString())
                rango.setText("obesidad grado 2")
                rango.setBackgroundResource(R.color.colorRed)
            } else if(imc > 39.9) {
                resultado.setText(imc.toString())
                rango.setText("obesidad grado 3")
                rango.setBackgroundResource(R.color.colorBrown)
            }
        }
    }

    fun calcularIMC(height:Double, weight:Double): Double{
        return weight / height.pow(2)
    }


}