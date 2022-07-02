private var win = 0
private var lose = 0
private var draw = 0
//variable declare top member
//agar tetap mempertahankan state valuenya, jika permainan berikutnya
//kalau dideklarasikan di kelas SuitGameImpl, value dari win, lose, draw akan ke reset ke 0

fun main() {
    val suitGameImpl = SuitGameImpl("GAME SUIT TERMINAL VERSION")
    suitGameImpl.showWelcomeMessage()
    suitGameImpl.showMessageVersusCpu()
    suitGameImpl.startGame()
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
        suitGameImpl.isDraw(suitGameImpl.suitChoose1, suitGameImpl.suitChoose2) -> draw++
        suitGameImpl.isWin(suitGameImpl.suitChoose1, suitGameImpl.suitChoose2) -> win++
        else -> lose++
    }

}

