package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    enum class Player {
        X, O
    }
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button
    private lateinit var winText: TextView

    private var activePlayer = Player.X // X will start the game
    private var matrix1 = Array(3) { IntArray(3) }
    private var matrix2 = Array(3) { IntArray(3) }

    private fun buttonClicked(button: Button, row: Int, col: Int) {
        if (activePlayer == Player.X) {
            button.text = "X"
            matrix1[row][col] = 1
            activePlayer = Player.O
        }
        else if (activePlayer == Player.O) {
            button.text = "O"
            matrix2[row][col] = 2
            activePlayer = Player.X
        }
        button.isEnabled = false
        winCheck()
    }
    private fun identifyButton(button: Button){
        when (button) {
            button1 -> buttonClicked(button, 0, 0)
            button2 -> buttonClicked(button, 0, 1)
            button3 -> buttonClicked(button, 0, 2)
            button4 -> buttonClicked(button, 1, 0)
            button5 -> buttonClicked(button, 1, 1)
            button6 -> buttonClicked(button, 1, 2)
            button7 -> buttonClicked(button, 2, 0)
            button8 -> buttonClicked(button, 2, 1)
            button9 -> buttonClicked(button, 2, 2)
        }
    }
    private fun winCheck(){
        for(i in 0..2){
            if(matrix1[i][0] == 1 && matrix1[i][1] == 1 && matrix1[i][2] == 1){
                winText.text = "X wins"
            }
            else if(matrix1[0][i] == 1 && matrix1[1][i] == 1 && matrix1[2][i] == 1){
                winText.text = "X wins"
            }
            else if(matrix1[0][0] == 1 && matrix1[1][1] == 1 && matrix1[2][2] == 1){
                winText.text = "X wins"
            }
            else if(matrix1[0][2] == 1 && matrix1[1][1] == 1 && matrix1[2][0] == 1){
                winText.text = "X wins"
            }
            else if(matrix2[i][0] == 2 && matrix2[i][1] == 2 && matrix2[i][2] == 2){
                winText.text = "O wins"
            }
            else if(matrix2[0][i] == 2 && matrix2[1][i] == 2 && matrix2[2][i] == 2){
                winText.text = "O wins"
            }
            else if(matrix2[0][0] == 2 && matrix2[1][1] == 2 && matrix2[2][2] == 2){
                winText.text = "O wins"
            }
            else if(matrix2[0][2] == 2 && matrix2[1][1] == 2 && matrix2[2][0] == 2){
                winText.text = "O wins"
            }
            else{
                winText.text = "Draw"
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.R1)
        button2 = findViewById(R.id.R2)
        button3 = findViewById(R.id.R3)
        button4 = findViewById(R.id.R4)
        button5 = findViewById(R.id.R5)
        button6 = findViewById(R.id.R6)
        button7 = findViewById(R.id.R7)
        button8 = findViewById(R.id.R8)
        button9 = findViewById(R.id.R9)
        resetButton = findViewById(R.id.Reset)
        winText = findViewById(R.id.winText)

        button1.setOnClickListener {
            identifyButton(button1)
        }
        button2.setOnClickListener {
            identifyButton(button2)
        }
        button3.setOnClickListener {
            identifyButton(button3)
        }
        button4.setOnClickListener {
            identifyButton(button4)
        }
        button5.setOnClickListener {
            identifyButton(button5)
        }
        button6.setOnClickListener {
            identifyButton(button6)
        }
        button7.setOnClickListener {
            identifyButton(button7)
        }
        button8.setOnClickListener {
            identifyButton(button8)
        }
        button9.setOnClickListener {
            identifyButton(button9)
        }
    }
}
