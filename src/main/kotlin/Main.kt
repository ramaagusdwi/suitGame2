fun main() {
    val suitGameImpl = SuitGameImpl("GAME SUIT TERMINAL VERSION")
    suitGameImpl.showWelcomeMessage()
    suitGameImpl.executeGame(true)
    suitGameImpl.executeGame(false)

}