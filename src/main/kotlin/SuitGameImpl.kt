class SuitGameImpl(private val titleGame: String) : Game(titleGame), SuitGame {
    internal var player1 = "" //access modifier
    internal var player2 = ""
    private var isPlayer1Turn = false
    private var isCpu = false
    val dataSuitArray = arrayOf("GUNTING", "KERTAS", "BATU")
    val dataDecisionArray = arrayOf("Y", "N")

    fun startGame(isPlayer1Turn: Boolean) {
        this.isPlayer1Turn = isPlayer1Turn
        printMessageInputan()
        readPlayerInput()

    }

    override fun showMessageVersus() {
        println("Apakah anda ingin lawan CPU? (y/n): ")

        val enteredString = readLine()!! //take the input from user

        handleMessageAlert(dataDecisionArray)

        if (enteredString.isNotEmpty()) {
            val inputFromUser = enteredString.trim().uppercase()
            when (inputFromUser) {
                "Y", "N" -> {
                    if (isPlayer1Turn) player1 = inputFromUser
                    else player2 = inputFromUser
                }
                else -> {
                    handleMessageAlert(dataDecisionArray)
                }
            }

        }
    }

    override fun printMessageInputan() {
        val mapPlayer = mapOf(true to 1, false to 2)
        val numberPlayer = mapPlayer[isPlayer1Turn]
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting/kertas/batu): ")
    }

    override fun readPlayerInput() {
        val enteredString = readLine()!! //take the input from user

        validateEmptyInput(enteredString)

        if (enteredString.isNotEmpty()) {
            val inputFromUser = enteredString.trim().uppercase()
            when (inputFromUser) {
                "GUNTING", "KERTAS", "BATU" -> {
                    if (isPlayer1Turn) player1 = inputFromUser
                    else player2 = inputFromUser
                }
                else -> {
                    handleMessageAlert(dataSuitArray)
                }
            }
        }
    }

    private fun handleMessageAlert(arrayString: Array<String>) {
        var spesificWord = ""

        var i = 0
        while (i < arrayString.size) {
            if (i > 0) { //jika index lebih dari 0 , maka gabungkan string "/"
                spesificWord += "/"
            }
            spesificWord += arrayString[i]
            i++
        }

        println("Mohon inputkan ($spesificWord)")
        println("NB : BISA HURUF BESAR SEMUA ATAU KECIL SEMUA")
        printMessageInputan() //jika inputan bukan dari GUNTING,KERTAS, BATU maka paksa user untuk menginputkan / print masukan pemain 1
        readPlayerInput()
    }

    private fun validateEmptyInput(enteredString: String) {
        if (enteredString.isEmpty()) {
            handleMessageAlert(dataSuitArray)
            printMessageInputan()
            readPlayerInput()
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