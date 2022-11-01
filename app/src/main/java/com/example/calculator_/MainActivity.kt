package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var text1:TextView
    private var operation = ""
    private var operand1 = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text1 = findViewById<TextView>(R.id.textView1)
    }
    fun numberClick(clickedView: View){
        if (clickedView is TextView){
            var number = clickedView.text.toString()
            var text = text1.text.toString()

            if (text == "0"){
                text = ""
            }
            text1.text = text + number
        }
    }
    fun operationClick(clickedView: View){
        if (clickedView is TextView){
            operation = clickedView.text.toString()

            operand1 = text1.text.toString().toDouble()
            text1.text = "0"
        }
    }
    fun equalsClick(clickedView: View){
        var operand2 = text1.text.toString().toDouble()
        if (operation == " "){
            text1.text = text1.text.toString()
        }else{
            when (operation){
                "+" -> text1.text = (operand1 + operand2).toString()
                "-" -> text1.text = (operand1 - operand2).toString()
                "*" -> text1.text = (operand1 * operand2).toString()
                "/" -> text1.text = (operand1 / operand2).toString()
            }
            operation = " "
            operand1
            var newnumber = text1.text.toString()
            if (newnumber.substring(newnumber.length - 2, newnumber.length) == ".0"){
                text1.text = newnumber.substring(0, newnumber.length -2)
            }
        }
    }
    fun clearText(view: View){
        text1.text = "0"
        operand1 = 0.0
    }
    fun deleteText(view: View){
        var newoperand1 = operand1.toString().substring(0,operand1.toString().length-2)
        var text2 = text1.text.toString()

        if(text2.length ==1 && operand1 == 0.0)
            text1.text = "0"
        else if (text2.length == 1){
            text1.text = newoperand1
            operand1 = 0.0
        }else{
            text1.text = text2.substring(0,text2.length -1)

        }


    }
    fun dotClick(view: View) {
        var dotexists = false
        var txt = text1.text.toString()
        for (i in 0 until txt.length  ){
            if (txt[i]=='.'){
                dotexists = true
            }
        }
        if (dotexists == false){
            text1.text = txt + '.'
        }

    }

}