class SuitGameImpl(private val titleGame: String) : Game(titleGame), SuitGame {
    private var player1 = "" //access modifier
    private var player2 = ""

    override fun showMessageTurnPlayer(isPlayer1Turn: Boolean) {
        val mapPlayer = mapOf(true to 1, false to 2)
        val numberPlayer = mapPlayer[isPlayer1Turn]
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting,kertas,batu): ")
    }

    override fun readPlayerInput(isPlayer1Turn: Boolean) {
        val enteredString = readLine()!! //take the input from user

        if (enteredString.isEmpty()) return //penerapan kondisi

        if (enteredString.isNotEmpty()) {
//            println(enteredString)

            //handle user input
            when (enteredString.lowercase()) {
                "gunting", "kertas", "batu" -> {
                    if (isPlayer1Turn) player1 = enteredString
                    else player2 = enteredString
                }
                else -> {
                    showMessageTurnPlayer(isPlayer1Turn)
                    readPlayerInput(isPlayer1Turn)
                }
            }


        }
    }

    override fun calculate() {
        TODO("Not yet implemented")
    }


}