fun main() {
    val suitGameImpl = SuitGameImpl("GAME SUIT TERMINAL VERSION")
    suitGameImpl.showWelcomeMessage()
    suitGameImpl.showMessageTurnPlayer(true)
    suitGameImpl.readPlayerInput(true)
    suitGameImpl.showMessageTurnPlayer(false)
    suitGameImpl.readPlayerInput(false)
}