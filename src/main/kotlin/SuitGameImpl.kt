class SuitGameImpl(private val titleGame: String) : Game(titleGame), SuitGame {
    internal var player1 = "" //access modifier
    internal var player2 = ""
    private var isPlayer1Turn = false
    private var isCpu = false
    val dataSuitArray = arrayOf("GUNTING", "KERTAS", "BATU")
    val dataDecisionArray = arrayOf("Y", "N")

    fun startGame(isPlayer1Turn: Boolean) {
        this.isPlayer1Turn = isPlayer1Turn
        printMessageInputanPlayer()
        readPlayerInput()
    }

    override fun showMessageVersusCpu() {
        print("Apakah anda ingin lawan CPU? (y/n): ")

        val enteredString = readLine()!!.uppercase() //take the input from user
        Utils.validateEmptyInput(enteredString) { isEmpty ->
            if (isEmpty) {
                Utils.handleMessageAlert(dataSuitArray)
            } else {
                when (enteredString) {
                    "Y" -> isCpu = true
                    "N" -> isCpu = false
                    else -> {
                        Utils.handleMessageAlert(dataDecisionArray)
                        showMessageVersusCpu() //paksa print statement "ingin lawan cpu" ini kembali, ketika inputan tidak memenuhi kondisi
                    }
                }
            }
        }

    }

    override fun printMessageInputanPlayer() {
        val mapPlayer = mapOf(true to 1, false to 2)
        val numberPlayer = mapPlayer[isPlayer1Turn]
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting/kertas/batu): ")
    }

    override fun readPlayerInput() {
        val enteredString = readLine()!! //take the input from user

//        validateEmptyInput(enteredString)

        if (enteredString.isNotEmpty()) {
            val inputFromUser = enteredString.trim().uppercase()
            when (inputFromUser) {
                "GUNTING", "KERTAS", "BATU" -> {
                    if (isPlayer1Turn) player1 = inputFromUser
                    else player2 = inputFromUser
                }
                else -> {
//                    handleMessageAlert(dataSuitArray)
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