open class Game(val title: String) {

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


}