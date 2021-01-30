package project.stN991532818.org

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
    Author:
    Student No.:VV modified
    Project: DiceRoller
    Package: project.stN991532818.org
    Date and Time: 2021-01-25, 1:54 PM
    Description: Rolls a dice on button click and display the appropriate image of the dice
 */

class MainActivity : AppCompatActivity() {

    // colon is not required in Kotlin statements
    var diceImage: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_button)
        countButton.setOnClickListener { countUp() }

        diceImage = findViewById(R.id.dice)
    }

    private fun rollDice(){
        //Toast.makeText(this,"button clicked", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()

        var resultText:TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()

        val drawResource = when(randomInt){
            1->R.drawable.one
            2->R.drawable.two
            3->R.drawable.three
            4->R.drawable.four
            5->R.drawable.five
            else->R.drawable.six
        }

        diceImage?.setImageResource(drawResource)

    }

    private fun countUp(){
        val resultText:TextView = findViewById(R.id.result_text)

        resultText.text = if (resultText.text.toString()=="Hello World"){
            "1"
        }else if(resultText.text.toString()=="6"){
            "6"
        }else{
            (Integer.parseInt(resultText.text.toString()) + 1).toString()
        }


        val drawResource = when(Integer.parseInt(resultText.text.toString())){
            1->R.drawable.one
            2->R.drawable.two
            3->R.drawable.three
            4->R.drawable.four
            5->R.drawable.five
            else->R.drawable.six
        }

        diceImage?.setImageResource(drawResource)
    }
}