interface SuitGame {
    fun showMessageVersusCpu()
    fun printMessageInputanPlayer()
    fun readPlayerInput()
    fun showResult()
    fun setScore(saveScore: (suitGameImpl: SuitGameImpl) -> Unit)
}