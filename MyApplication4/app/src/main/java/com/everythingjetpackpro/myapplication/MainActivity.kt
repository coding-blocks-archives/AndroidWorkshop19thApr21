package com.everythingjetpackpro.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var player = true
    lateinit var board: Array<Array<Button>>
    var boardStatus = Array(3) { IntArray(3) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = arrayOf(
            arrayOf(
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3)
            ),
            arrayOf(
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6)
            ),
            arrayOf(
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9)
            )
        )
        for (i in board) {
            for (button in i) {
                button.setOnClickListener(this)
            }
        }
        for (i in 0..2) {
            for (j in 0..2) {
                boardStatus[i][j] = -1
            }
        }
        for (i in 0..2) {
            for (j in 0..2) {
                boardStatus[i][j] = -1
            }
        }

    }

    override fun onClick(p0: View) {
        when (p0.id) {
            R.id.button1 -> {
                updateValue(0, 0)
            }
            R.id.button2 -> {
                updateValue(0, 1)
            }
            R.id.button3 -> {
                updateValue(0, 2)
            }
            R.id.button4 -> {
                updateValue(1, 0)
            }
            R.id.button5 -> {
                updateValue(1, 1)
            }
            R.id.button6 -> {
                updateValue(1, 2)
            }
            R.id.button7 -> {
                updateValue(2, 0)
            }
            R.id.button8 -> {
                updateValue(2, 1)
            }
            R.id.button9 -> {
                updateValue(2, 2)
            }
        }
        player = !player
        checkWinner()
    }

    private fun checkWinner() {
        if(boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            if(boardStatus[0][2] == 1){
                showWinner("Player 1")
            }else if(boardStatus[0][2] == 0){
                showWinner("Player 2")
            }
        }

        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            if(boardStatus[0][0] == 1){
                showWinner("Player 1")
            }else if(boardStatus[0][0] == 0){
                showWinner("Player 2")
            }
        }
        
        //Row
        for(i in 0..2){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if(boardStatus[i][0] == 1){
                    showWinner("Player 1")
                }else if(boardStatus[i][0] == 0){
                    showWinner("Player 2")
                }
            }
        }

        //Column
        for(i in 0..2){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
                if(boardStatus[0][i] == 1){
                    //player 1 winner
                    showWinner("Player 1")
                }else if(boardStatus[0][i] == 0){
                    showWinner("Player 2")
                }
            }
        }
    }

    private fun showWinner(s: String) {
        for (i in board) {
            for (button in i) {
                button.isEnabled = false
            }
        }
        Toast.makeText(this, "Winner is $s", Toast.LENGTH_SHORT).show()
    }

    private fun updateValue(row: Int, col: Int) {
        val text = if (player) "X" else "O";
        val value = if (player) 1 else 0;
        board[row][col].text = text
        board[row][col].isEnabled = false
        boardStatus[row][col] = value
    }

    fun resetBoard(view: View) {
        for (i in board) {
            for (button in i) {
                button.isEnabled = true
                button.text = ""
            }
        }

        for (i in 0..2) {
            for (j in 0..2) {
                boardStatus[i][j] = -1
            }
        }
    }

}