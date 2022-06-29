interface SuitGame {
    fun showMessageTurnPlayer(isPlayer1Turn: Boolean)
    fun readPlayerInput(isPlayer1Turn: Boolean)
    fun calculate()
}