open class Game{


}

class TicTacToe {


    fun checkRows() {}

    fun checkColumns() {

    }

    fun checkDiagonals() {

    }

    fun printGameBoard() {
        //Create a 3x3 array to represent the tic tac toe board
        val board = Array(3) { CharArray(3) }

        for (k in board.indices) {
            for (l in board.indices) {
                board[k][l] = '-'
            }
        }
    }

    fun isValidMove(row: Int, column: Int, player: Int) {

    }


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
    }