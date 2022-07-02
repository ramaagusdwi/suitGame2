open class Game(val title: String) {

    private val rules =
        mapOf(
            "GUNTING-KERTAS" to true,
            "GUNTING-BATU" to false,
            "BATU-GUNTING" to true,
            "BATU-KERTAS" to false,
            "KERTAS-BATU" to true,
            "KERTAS-GUNTING" to false
        )

    fun showWelcomeMessage() {
        println()
        println("==========================")
        println(this.title)
        println("==========================")
    }

    fun playAgain(): Boolean {
        println()
        print("Play Again? (y/n): ")
        val enteredString = readLine()!!.trim().lowercase()

        return enteredString.equals("y")
    }

    fun showScore(win: Int, lose: Int, draw: Int) {
        println()
        println()
        println("YOUR SCORE = WIN: $win, LOSE: $lose, DRAW: $draw")
    }

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!

}