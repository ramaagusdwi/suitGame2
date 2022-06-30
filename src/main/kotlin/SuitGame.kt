interface SuitGame {
    fun showMessageTurnPlayer()
    fun readPlayerInput()
    fun showResult()

//    fun setScore(win: Int, draw: Int, lose : Int)
    fun setScore(saveScore: (suitGameImpl: SuitGameImpl) -> Unit)
}