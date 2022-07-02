//variable declare top member
//agar tetap mempertahankan state valuenya, jika permainan berikutnya
//kalau dideklarasikan di kelas SuitGameImpl, value dari win, lose, draw akan ke reset ke 0
var scorePlayer1: Score = Score()
var scorePlayer2: Score = Score()

fun main() {
    val suitGameImpl = SuitGameImpl("GAME SUIT TERMINAL VERSION")
    suitGameImpl.showWelcomeMessage()
    suitGameImpl.showMessageVersusCpu()
    suitGameImpl.startGame()
    suitGameImpl.showResult()

    suitGameImpl.setScore({ saveScore(suitGameImpl) })
    val arr = arrayOf(scorePlayer1,scorePlayer2)
    suitGameImpl.showScore(arr)
    val playAgain = suitGameImpl.playAgain()

    while (playAgain) {
        main()
    }
}

fun saveScore(suitGameImpl: SuitGameImpl) {
    when {
        suitGameImpl.isDraw(suitGameImpl.suitChoose1, suitGameImpl.suitChoose2) -> scorePlayer1.draw++
        suitGameImpl.isWin(suitGameImpl.suitChoose1, suitGameImpl.suitChoose2) -> scorePlayer1.win++
        else -> scorePlayer1.lose++
    }

    when {
        suitGameImpl.isDraw(suitGameImpl.suitChoose1, suitGameImpl.suitChoose2) -> scorePlayer2.draw++
        suitGameImpl.isPlayer2Win(suitGameImpl.suitChoose1, suitGameImpl.suitChoose2) -> scorePlayer2.win++
        else -> scorePlayer2.lose++
    }
}

