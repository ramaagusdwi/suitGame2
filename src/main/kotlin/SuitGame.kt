interface SuitGame {
    fun showMessageTurnPlayer()
    fun readPlayerInput()
    fun showResult()
    fun setScore(saveScore: (suitGameImpl: SuitGameImpl) -> Unit)
}