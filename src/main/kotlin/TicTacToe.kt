import java.util.*
import kotlin.system.exitProcess

class Player (val name: String, val symbol: Char)  {
}

//Mats
open class Game {
    protected val board = Array(3) {
        CharArray(3) { ' ' }
    }

    fun GameBoard() {
        //Create a 3x3 array to represent the tic-tac-toe board
        for (i in 0..2) {
            for (j in 0..2) {
                print(" ${board[i][j]} ")
                if (j != 2) print("|")
            }
            println()
            if (i != 2) println("---+---+---")
        }
    }
}

class TicTacToe : Game() {
    fun play() {
        GameBoard()
        val player1 = Player("Player 1", 'X')
        val player2 = Player("Player 2", 'O')

        var currentPlayer = player1


        while (true) {
            print("${currentPlayer.name}, make your move (row column from 0 to 2, use comma between numbers ):")
            try {
                val move = readln().split(",")
                val row = move[0].toInt()
                val col = move[1].toInt()

                if (isValidMove(row,col)) {
                    board[row][col] = currentPlayer.symbol
                    GameBoard()
                    if (checkForWin(row, col)) {
                        println("${currentPlayer.name} wins!")
                        playAgain()
                        return
                    } else if (checkForTie()) {
                        println("It's a tie!")
                        playAgain()
                        return
                    }
                    if (currentPlayer == player1)
                        currentPlayer = player2
                    else currentPlayer = player1
                } else {
                    println("The cell is already taken, try again.")
                }
            } catch (e: Exception) {
                println("Invalid input, please use comma between numbers and numbers between 0-2")
            }
        }
    }

    private fun resetBoard() {
        for (i in board.indices) {
            for (j in 0 until board[i].size) {
                board[i][j] = ' '
            }
        }
    }
    private fun playAgain(): String {
        println("Do you want to play again (yes/no)?")
        val playAgain = readln()
        if (playAgain.lowercase(Locale.getDefault()) == "yes") {
            resetBoard()
            play()
        }
        else if (playAgain.lowercase(Locale.getDefault()) == "no") {
            println("Thanks for playing Tic-Tac-Toe!")
            exitProcess(1)
        } else {
            println("Invalid input, please try again.")
            playAgain()
        }
        return playAgain
    }

    private fun checkForWin(row: Int, col: Int): Boolean {
        // logic to check for a win, such as checking for three consecutive player characters in a row, column, or diagonal
        val playerWon = when {
            checkRows(row) -> true
            checkColumns(col) -> true
            checkDiagonals() -> true
            else -> false
        }
        return playerWon
    }

    private fun checkForTie(): Boolean {
        for (i in 0..2) {
            for (j in 0..2) {
                if (board[i][j] == ' ')
                    return false
            }
        }
        return true
    }

    //Odd
    private fun checkRows(row: Int): Boolean {
        return board[row].toSet().size == 1 // unsure whether we need to test for cases when a win is declared due to ' '
    }

    //Odd
    private fun checkColumns(col: Int): Boolean {
        val randomColVal: Char = board[0][col]
        for (row in board) {
            if (randomColVal != row[col]) return false
        }
        return true
    }

    //Odd
    private fun checkDiagonals(): Boolean {
        val leftToRightNodes = mutableSetOf(board[0][0])
        val rightToLeftNodes = mutableSetOf(board[0][board.size - 1])
        var playerWon = false
        for (i in board.indices) {
            leftToRightNodes.add(board[i][i])
            rightToLeftNodes.add(board[i][board.size - 1 - i])
        }
        when {
            (!leftToRightNodes.contains(' ') && leftToRightNodes.size == 1) -> playerWon = true
            (!rightToLeftNodes.contains(' ') && rightToLeftNodes.size == 1) -> playerWon = true
        }

        return playerWon
    }

    fun isValidMove(row: Int, col: Int):Boolean {
        return row in 0..2 && col in 0..2 && board[row][col] == ' '
    }
}

fun main() {
    TicTacToe().play()
}