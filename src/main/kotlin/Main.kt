private var win = 0
private var lose = 0
private var draw = 0
//variable declare top member
//agar tetap mempertahankan state valuenya, jika permainan berikutnya
//kalau dideklarasikan di kelas SuitGameImpl, value dari win, lose, draw akan ke reset ke 0

fun main() {
    val suitGameImpl = SuitGameImpl("GAME SUIT TERMINAL VERSION")
    suitGameImpl.showWelcomeMessage()
    suitGameImpl.startGame(true)
    suitGameImpl.startGame(false)
    suitGameImpl.showResult()

    suitGameImpl.setScore({saveScore(suitGameImpl)})
    suitGameImpl.showScore(win,lose,draw)
    val playAgain = suitGameImpl.playAgain()

    while (playAgain) {
        main()
    }
}

fun saveScore(suitGameImpl: SuitGameImpl) {
    when {
        suitGameImpl.isDraw(suitGameImpl.player1, suitGameImpl.player2) -> draw++
        suitGameImpl.isWin(suitGameImpl.player1, suitGameImpl.player2) -> win++
        else -> lose++
    }

}

