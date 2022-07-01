interface SuitGame {
    fun showMessageInputan()
    fun readPlayerInput()
    fun showResult()
    fun setScore(saveScore: (suitGameImpl: SuitGameImpl) -> Unit)
}