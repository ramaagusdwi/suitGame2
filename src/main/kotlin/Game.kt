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
        println("==========================")
        println(this.title)
        println("==========================")
    }

    fun showResultMessage(vararg resultSuit: Int) {

    }

    fun playAgain(isTrue: Boolean) {

    }

    fun showScore(win: Byte, lose: Byte, draw: Byte) {

    }

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!

}