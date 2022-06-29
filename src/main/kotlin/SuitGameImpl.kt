class SuitGameImpl(private val titleGame: String) : Game(titleGame), SuitGame {
    private var player1 = "" //access modifier
    private var player2 = ""
    private var isPlayer1Turn = false


    fun executeGame(isPlayer1Turn: Boolean){
        this.isPlayer1Turn = isPlayer1Turn
        showMessageTurnPlayer()
        readPlayerInput()
    }

    override fun showMessageTurnPlayer() {
        val mapPlayer = mapOf(true to 1, false to 2)
        val numberPlayer = mapPlayer[isPlayer1Turn]
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting/kertas/batu): ")
    }

    override fun readPlayerInput() {
        val enteredString = readLine()!! //take the input from user

        if (enteredString.isEmpty()) return //penerapan kondisi

        if (enteredString.isNotEmpty()) {
//            println(enteredString)

            //handle user input
            when (enteredString.trim().lowercase()) {
                "gunting", "kertas", "batu" -> {
                    if (isPlayer1Turn) player1 = enteredString
                    else player2 = enteredString
                }
                else -> {
                    showMessageTurnPlayer()
                    readPlayerInput()
                }
            }


        }
    }

    override fun calculate() {

    }


}