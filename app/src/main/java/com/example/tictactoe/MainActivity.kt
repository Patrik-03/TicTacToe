package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    enum class Player {
        X, O
    }

    var button1: Button = findViewById(R.id.R1)
    var button2: Button = findViewById(R.id.R2)
    var button3: Button = findViewById(R.id.R3)
    var button4: Button = findViewById(R.id.R4)
    var button5: Button = findViewById(R.id.R5)
    var button6: Button = findViewById(R.id.R6)
    var button7: Button = findViewById(R.id.R7)
    var button8: Button = findViewById(R.id.R8)
    var button9: Button = findViewById(R.id.R9)

    var activePlayer = Player.X // X will start the game
    var matrix1 = Array(3) { IntArray(3) }
    var matrix2 = Array(3) { IntArray(3) }

    fun buttonClicked(button: Button, row: Int, col: Int) {
        if (activePlayer == Player.X)
            button.text = "X"
        else if (activePlayer == Player.O)
            button.text = "O"
        button.isEnabled = false

    }
    fun findButton(row: Int, col: Int){

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
