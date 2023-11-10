package com.antonio.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.antonio.calculadora.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var num1=0.0
    var num2=0.0
    var resultado=0.0
    var resultadoTexto=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var operacion=""

        binding.botonC.setOnClickListener {
            binding.total.text="0"
            binding.parcial.text=""

        }

        binding.boton0.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }

            binding.total.text=binding.total.text.toString()+binding.boton0.text.toString()
        }

        binding.boton1.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton1.text.toString()
        }

        binding.boton2.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton2.text.toString()
        }
        binding.boton3.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton3.text.toString()
        }
        binding.boton4.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton4.text.toString()
        }
        binding.boton5.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton5.text.toString()
        }
        binding.boton6.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton6.text.toString()
        }
        binding.boton7.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton7.text.toString()
        }
        binding.boton8.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton8.text.toString()
        }
        binding.boton9.setOnClickListener {
            if(binding.total.text=="0"){
                binding.total.text=""
            }
            binding.total.text=binding.total.text.toString()+binding.boton9.text.toString()
        }
        binding.botonComa.setOnClickListener {
            binding.total.text=binding.total.text.toString()+"."
        }

        binding.botonPor.setOnClickListener {
            binding.parcial.text=binding.total.text.toString()+" x "
            num1= binding.total.text.toString().toDouble()
            binding.total.text=""
            operacion="x"
        }

        binding.botonMas.setOnClickListener {
            binding.parcial.text=binding.total.text.toString()+" + "
            num1= binding.total.text.toString().toDouble()
            binding.total.text=""
            operacion="+"
        }
        binding.botonDividir.setOnClickListener {
            binding.parcial.text=binding.total.text.toString()+" ÷ "
            num1= binding.total.text.toString().toDouble()
            binding.total.text=""
            operacion="÷"
        }
        binding.botonMenos.setOnClickListener {
            binding.parcial.text=binding.total.text.toString()+" - "
            num1= binding.total.text.toString().toDouble()
            binding.total.text=""
            operacion="-"
        }
        binding.boton1BarraX.setOnClickListener {
            binding.parcial.text="1/("+binding.total.text.toString()+")"
            num1=1.0;
            num2= binding.total.text.toString().toDouble()
            resultado=num1/num2
            resultadoTexto=comprobarEntero(resultado)
            binding.total.text=resultadoTexto
        }
        binding.botonXCuadrado.setOnClickListener {
            binding.parcial.text="sqr("+binding.total.text.toString()+")"
            num1=binding.total.text.toString().toDouble()
            resultado=num1*num1
            resultadoTexto=comprobarEntero(resultado)
            binding.total.text=resultadoTexto
        }
        binding.botonDosRaizX.setOnClickListener {
            binding.parcial.text="√("+binding.total.text.toString()+")"
            num1=binding.total.text.toString().toDouble()
            resultado= sqrt(num1)
            resultadoTexto=comprobarEntero(resultado)
            binding.total.text=resultadoTexto
        }


        binding.botonIgual.setOnClickListener {
            binding.parcial.text=binding.parcial.text.toString()+binding.total.text.toString()+" = "
            num2= binding.total.text.toString().toDouble()
            binding.total.text=""


            when(operacion){
                "x" -> {
                    resultado=num1*num2
                    resultadoTexto=comprobarEntero(resultado)
                    binding.total.text=resultadoTexto
                }
                "+" -> {
                    resultado=num1+num2
                    resultadoTexto=comprobarEntero(resultado)
                    binding.total.text=resultadoTexto
                }
                "÷" -> {
                    resultado=num1/num2
                    resultadoTexto=comprobarEntero(resultado)
                    binding.total.text=resultadoTexto
                }
                "-" -> {
                    resultado=num1-num2
                    resultadoTexto=comprobarEntero(resultado)
                    binding.total.text=resultadoTexto
                }


            }
            operacion=""
        }


    }

    private fun comprobarEntero(resultado:Double): String {
        var resultadoTexto=""
        if(resultado-resultado.toInt()==0.0){
            resultadoTexto=resultado.toInt().toString()
        }else{
            val formato = DecimalFormat("#.##")
            resultadoTexto=formato.format(resultado).toString()
        }
        return resultadoTexto
    }
}