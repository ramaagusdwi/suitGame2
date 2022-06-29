class SuitGameImpl : Game(), SuitGame {
    private var player1 = ""
    private var player2 = ""

    override fun showMessageTurnPlayer(isPlayer1Turn: Boolean) {
        val mapPlayer = mapOf(true to 1, false to 2)
        val numberPlayer = mapPlayer[isPlayer1Turn]
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting,batu,kertas): ")
    }

    override fun readPlayerInput(isPlayer1Turn: Boolean) {
        val enteredString = readLine()!! //take the input from user

        if (enteredString.isEmpty()) return //penerapan kondisi

        if (enteredString.isNotEmpty()) {
            println(enteredString)
            if (isPlayer1Turn) player1 = enteredString
            else player2 = enteredString
        }
    }

    override fun calculate() {
        TODO("Not yet implemented")
    }


}