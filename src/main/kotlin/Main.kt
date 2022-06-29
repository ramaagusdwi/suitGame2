fun main() {
    val suitGameImpl = SuitGameImpl("GAME SUIT TERMINAL VERSION")
    suitGameImpl.showWelcomeMessage()
    suitGameImpl.startGame(true)
    suitGameImpl.startGame(false)
    suitGameImpl.showResult()
    suitGameImpl.showScore()
    val playAgain = suitGameImpl.playAgain()

    while (playAgain) {
        main()
    }
}