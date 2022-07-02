interface SuitGame {
    fun showMessageVersus()
    fun printMessageInputan()
    fun readPlayerInput()
    fun showResult()
    fun setScore(saveScore: (suitGameImpl: SuitGameImpl) -> Unit)
}