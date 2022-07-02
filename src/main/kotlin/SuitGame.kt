interface SuitGame {
    fun showMessageVersusCpu()
    fun printMessageInputanPlayer(numberPlayer: Int, namePlayer: String, answer: String)
    fun readPlayerInput()
    fun showResult()
    fun setScore(saveScore: (suitGameImpl: SuitGameImpl) -> Unit)
}