open class Game{


}
//Tove
class Player {

}


//Mats
class GameBoard{

    private val board = Array(3) { CharArray(3) { '-' } }
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
}
class TicTacToeGame {

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

    fun printGameBoard() {}
}

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