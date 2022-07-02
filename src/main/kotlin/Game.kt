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

    private val rulesPlayer2 =
        mapOf(
            "GUNTING-KERTAS" to false,
            "GUNTING-BATU" to true,
            "BATU-GUNTING" to false,
            "BATU-KERTAS" to true,
            "KERTAS-BATU" to false,
            "KERTAS-GUNTING" to true
        )

    var isCpu = false

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

    //TO DO
    //display score each player, cpu or player1
//    fun showScore(win: Int, lose: Int, draw: Int) {
//        println()
//        println()
//        println("YOUR SCORE = WIN: $win, LOSE: $lose, DRAW: $draw")
//    }
    fun showScore(scores: Array<Score>) {
        var playerName = "Pemain 1"
        for (index in scores.indices) {
            val score = scores[index]
            println()
            if (index > 0) {
                if (isCpu) {
                    playerName = "Komputer"
                } else {
                    playerName = "Pemain 2"
                }

            }
            println("$playerName SCORE = WIN: ${score.win}, LOSE: ${score.lose}, DRAW: ${score.draw}")
        }

    }

    fun isDraw(from: String, to: String): Boolean = from == to

    fun isWin(from: String, to: String): Boolean = rules["$from-$to"]!!

    fun isPlayer2Win(from: String, to: String): Boolean = rulesPlayer2["$from-$to"]!!

}