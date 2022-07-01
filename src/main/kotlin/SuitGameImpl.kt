class SuitGameImpl(private val titleGame: String) : Game(titleGame), SuitGame {
    internal var player1 = "" //access modifier
    internal var player2 = ""
    private var isPlayer1Turn = false
    private var isCpu = false
    val optionSuitGame = arrayOf("GUNTING", " KERTAS ", " BATU")

    fun startGame(isPlayer1Turn: Boolean) {
        this.isPlayer1Turn = isPlayer1Turn
        showMessageInputan()
        readPlayerInput()

    }

    override fun showMessageVersus() {
        print("Apakah anda ingin lawan CPU? (y/n): ")

        val enteredString = readLine()!! //take the input from user

        if (enteredString.isEmpty()) return //penerapan kondisi

        if (enteredString.isNotEmpty()) {

        }
    }

    override fun showMessageInputan() {
        val mapPlayer = mapOf(true to 1, false to 2)
        val numberPlayer = mapPlayer[isPlayer1Turn]
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting/kertas/batu): ")
    }

    override fun readPlayerInput() {
        val enteredString = readLine()!! //take the input from user

        if (enteredString.isEmpty()) {
            println("Mohon inputkan sesuatu!")
            showMessageInputan()
            readPlayerInput()
        }

        if (enteredString.isNotEmpty()) {
            val inputFromUser = enteredString.trim().uppercase()
            when (inputFromUser) {

                "GUNTING", "KERTAS", "BATU" -> {
                    if (isPlayer1Turn) player1 = inputFromUser
                    else player2 = inputFromUser
                }
                else -> {
                    showMessageInputan() //jika inputan bukan dari GUNTING,KERTAS, BATU maka tampilkan pesan inputan
                    readPlayerInput()
                }
            }
        }
    }

    override fun showResult() {
        val result = when {
            super.isDraw(player1, player2) -> "DRAW!"
            super.isWin(player1, player2) -> "Pemain 1 Menang!"
            else -> "Pemain 2 Menang!"
        }

        println()
        println("Hasil: ")
        print(result)
    }

    override fun setScore(saveScore: (suitGame: SuitGameImpl) -> Unit) {
        saveScore(this)
    }


}