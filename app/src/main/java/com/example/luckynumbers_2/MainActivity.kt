package com.example.luckynumbers_2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.graphics.Color
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boxes = listOf(
            findViewById<TextView>(R.id.box1),
            findViewById<TextView>(R.id.box2),
            findViewById<TextView>(R.id.box3),
            findViewById<TextView>(R.id.box4),
            findViewById<TextView>(R.id.box5)
        )
        val boxes2 = listOf(
            findViewById<TextView>(R.id.box7),
            findViewById<TextView>(R.id.box8),
            findViewById<TextView>(R.id.box9),
            findViewById<TextView>(R.id.box10),
            findViewById<TextView>(R.id.box11)
        )
        val boxes3 = listOf(
            findViewById<TextView>(R.id.box13),
            findViewById<TextView>(R.id.box14),
            findViewById<TextView>(R.id.box15),
            findViewById<TextView>(R.id.box16),
            findViewById<TextView>(R.id.box17)
        )

        val boxes4 = listOf(
            findViewById<TextView>(R.id.box19),
            findViewById<TextView>(R.id.box20),
            findViewById<TextView>(R.id.box21),
            findViewById<TextView>(R.id.box22),
            findViewById<TextView>(R.id.box23)
        )


        val specialBox = findViewById<TextView>(R.id.box6)
        val specialBox1 = findViewById<TextView>(R.id.box12)
        val specialBox2 = findViewById<TextView>(R.id.box18)
//        val specialBox3 = findViewById<TextView>(R.id.box24)
        val generateButton = findViewById<Button>(R.id.generateButton)
        val generateButton2 = findViewById<Button>(R.id.generateButton2)
        val generateButton3 = findViewById<Button>(R.id.generateButton3)
        val generateButton4 = findViewById<Button>(R.id.generateButton4)


        generateButton.setOnClickListener {
            //Generate 5 numeros unicos entre 1 -70
                val mainNumbers = mutableSetOf<Int>()
                while (mainNumbers.size<5){
                    mainNumbers.add(Random.nextInt(1, 71))
                }

                //Ordenar los Numeros
                val sortedNumbers =  mainNumbers.sorted()

                //Mostrar en las cajas
                sortedNumbers.forEachIndexed{index, number ->
                boxes[index].text = number.toString()
                }
                //generar numero especial entrw 1 - 25
                specialBox.text = Random.nextInt(1,25).toString()

                //efecto visual
                flashBoxes (boxes + specialBox)
        }

        generateButton2.setOnClickListener {
            //Generate 5 numeros unicos entre 1 - 70
            val mainNumbers1 = mutableSetOf<Int>()
            while (mainNumbers1.size<5){
                mainNumbers1.add(Random.nextInt(1, 70))
            }

            //Ordenar los Numeros
            val sortedNumbers1 =  mainNumbers1.sorted()

            //Mostrar en las cajas
            sortedNumbers1.forEachIndexed{index, number ->
                boxes2[index].text = number.toString()
            }
            //generar numero especial entrw 1 - 26
            specialBox1.text = Random.nextInt(1,27).toString()

            //efecto visual
            flashBoxes (boxes + specialBox1)
        }

        generateButton3.setOnClickListener {
            //Generate 5 numeros unicos entre 1 - 47
            val mainNumbers2 = mutableSetOf<Int>()
            while (mainNumbers2.size<5){
                mainNumbers2.add(Random.nextInt(1, 48))
            }

            //Ordenar los Numeros
            val sortedNumbers2 =  mainNumbers2.sorted()

            //Mostrar en las cajas
            sortedNumbers2.forEachIndexed{index, number ->
                boxes3[index].text = number.toString()
            }
            //generar numero especial entre 1 - 27
            specialBox2.text = Random.nextInt(1,28).toString()

            //efecto visual
            flashBoxes (boxes + specialBox)
        }
        generateButton4.setOnClickListener {
            //Generate 5 numeros unicos entre 1 - 35
            val mainNumbers3 = mutableSetOf<Int>()
            while (mainNumbers3.size<5){
                mainNumbers3.add(Random.nextInt(1, 36))
            }

            //Ordenar los Numeros
            val sortedNumbers3 =  mainNumbers3.sorted()

            //Mostrar en las cajas
            sortedNumbers3.forEachIndexed{index, number ->
                boxes4[index].text = number.toString()
            }
            //generar numero especial entrw 1 - 25
//            specialBox3.text = Random.nextInt(1,25).toString()

            //efecto visual
            flashBoxes (boxes + specialBox)
        }


    }
    private fun flashBoxes(boxes: List<TextView>){
        val originalColors = boxes.map {it.currentTextColor}
        boxes.forEach { it.setTextColor(Color.WHITE) }

        boxes[0].postDelayed({
            boxes.forEachIndexed { index, box ->
                box.setTextColor(originalColors[index])
            }
        },300)
    }
}