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
    private var matrix = Array(3) { IntArray(3) }

    private fun buttonClicked(button: Button, row: Int, col: Int) {
        if (activePlayer == Player.X) {
            button.text = "X"
            matrix[row][col] = 1
            activePlayer = Player.O
        }
        else if (activePlayer == Player.O) {
            button.text = "O"
            matrix[row][col] = 2
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
            if(matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]){
                if(matrix[i][0] == 1){
                    winText.text = "X wins!"
                    disableButtons()
                }
                else if(matrix[i][0] == 2){
                    winText.text = "O wins!"
                    disableButtons()
                }
            }
            else if(matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]){
                if(matrix[0][i] == 1){
                    winText.text = "X wins!"
                    disableButtons()
                }
                else if(matrix[0][i] == 2){
                    winText.text = "O wins!"
                    disableButtons()
                }
            }
            else if(matrix[0][0] == matrix[1][1] && matrix[1][1] == matrix[2][2]){
                if(matrix[0][0] == 1){
                    winText.text = "X wins!"
                    disableButtons()
                }
                else if(matrix[0][0] == 2){
                    winText.text = "O wins!"
                    disableButtons()
                }
            }
            else if(matrix[0][2] == matrix[1][1] && matrix[1][1] == matrix[2][0]){
                if(matrix[0][2] == 1){
                    winText.text = "X wins!"
                    disableButtons()
                }
                else if(matrix[0][2] == 2){
                    winText.text = "O wins!"
                    disableButtons()
                }
            }

        }
    }
    private fun disableButtons(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }
    private fun reset(){
        activePlayer = Player.X
        for(i in 0..2){
            for(j in 0..2){
                matrix[i][j] = 0
            }
        }
        button1.text = ""
        button2.text = ""
        button3.text = ""
        button4.text = ""
        button5.text = ""
        button6.text = ""
        button7.text = ""
        button8.text = ""
        button9.text = ""
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
        winText.text = ""
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

        for(i in 0..2){
            for(j in 0..2){
                matrix[i][j] = 0
            }
        }

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
        resetButton.setOnClickListener {
            reset()
        }
    }
}
