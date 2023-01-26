open class Game {




}
//Tove
class Player {
    var currentPlayer: String = "Player 1"
    var symbol: Char = 'X'

    fun switchPlayer(){

    if ((currentPlayer == "Player 1") && (symbol == 'X')){
            currentPlayer = "Player 2"
            symbol = 'O'
        }
    else {
            currentPlayer = "Player 1"
            symbol = 'X'
        }




}


//Mats
open class GameBoard{
    protected val board = Array(3) {
        CharArray(3) { '-' }
    }
    fun displayBoard() {
        //Create a 3x3 array to represent the tic-tac-toe board
        for (i in 0..2) {
            for (j in 0..2) {
                print(board[i][j])
                if (j != 2) print("|")
            }
            println()
            if (i != 2) println("-+-+-")
        }
    }
    //abstract fun play(){
      // TODO("Not yet written")

    //}
}
class TicTacToeGame: GameBoard() {

    fun play() {
         displayBoard()
        var player = Player()
        var currentPlayer = player.currentPlayer
        var currentSymbol = player.symbol

        while (true) {
            println("Player $currentPlayer, make your move (row column):")
            val move = readln().split(" ")
            val row = move[0].toInt()
            val col = move[1].toInt()
            if (row in 0..2 && col in 0..2 && board[row][col] == '-') {
                board[row][col] = currentSymbol
                displayBoard()
                if (checkForWin(currentSymbol)) {
                    println("Player $currentPlayer wins!")
                    return
                } else if (checkForTie()) {
                    println("It's a tie!")
                    return
                }
                player.switchPlayer()
            } else {
                println("Invalid move, try again.")
            }
        }
    }

    private fun checkForWin(player: Char): Boolean {
        // logic to check for a win, such as checking for three consecutive player characters in a row, column, or diagonal
        //Her kommer checkRows, CheckColums og CheckDiagonal inn
        return false
    }

    private fun checkForTie(): Boolean {
        // logic to check for a tie, such as checking if all positions on the board are filled and no player has won
        //Her kommer checkRows, CheckColums og CheckDiagonal inn
        return false
    }


    //Odd
    fun checkRows() {}

    //Odd
    fun checkColumns() {

    }

    //Odd
    fun checkDiagonals() {

    }

    fun isValidMove(row: Int, column: Int, player: Int) {

    }

    fun printGameBoard() {
        val game = GameBoard()
        game.displayBoard()
    }
}}

/*
// Ask the users for their moves
    while (true) {
        println("Player 1 turn (X):")
        val row1 = readLine()!!.toInt()
        val col1 = readLine()!!.toInt()
        if (board[row1][col1] == '-') {
            board[row1][col1] = 'X'
        } else {
            println("This move is not valid, please try again")
            continue
        }


// Check if the game is over
        if (isGameOver(board)) {
            println("Game over! Player 1 wins!")
            break
        }


// Player 2 turn
        println("Player 2 turn (O):")
        val row2 = readLine()!!.toInt()
        val col2 = readLine()!!.toInt()
        if (board[row2][col2] == '-') {
            board[row2][col2] = 'O'
        } else {
            println("This move is not valid, please try again")
            continue
        }


// Check if the game is over
        if (isGameOver(board)) {
            println("Game over!)
}
*/