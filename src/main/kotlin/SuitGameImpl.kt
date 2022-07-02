import kotlin.random.Random

class SuitGameImpl(private val titleGame: String) : Game(titleGame), SuitGame {
    internal var suitChoose1 = "" //access modifier
    internal var suitChoose2 = ""
    private var isPlayer1Turn = false
    val playerArray = arrayOf("pemain1", "pemain2")
    val dataSuitArray = arrayOf("GUNTING", "KERTAS", "BATU")
    val dataDecisionArray = arrayOf("Y", "N")
    var playerNumber: Int = 0
    var playerName: String = ""

    fun startGame() {
        if (isCpu) {
            val random = Random.nextInt(0, 3)
            suitChoose2 =
                dataSuitArray[random] //memilih random dari pilih (gunting/keras/batu) disimpan ke var suitChosse2
            playerArray[1] = "CPU"
        }
        for (index in 0 until playerArray.size) {
            playerNumber = index + 1
            playerName = playerArray[index]
            if (playerName == "CPU") {
                printMessageInputanPlayer(playerNumber, playerArray[index], suitChoose2)
            } else {
                printMessageInputanPlayer(playerNumber, playerArray[index], "")
            }

            //seting giliran pemain 1 jika index sama dengan 0
            this.isPlayer1Turn = index == 0
            if (playerArray[index] != "CPU") readPlayerInput()
        }

    }

    override fun showMessageVersusCpu() {
        print("Apakah anda ingin lawan CPU? (y/n): ")
        val enteredString = readLine()!!.uppercase() //take the input from user
        Utils.validateEmptyInput(enteredString) { isEmpty ->
            if (isEmpty) {
                println()
                println("Inputan tidak boleh kosong!")
                Utils.handleMessageAlert(dataDecisionArray)
                showMessageVersusCpu()
            } else {
                when (enteredString) {
                    "Y" -> isCpu = true
                    "N" -> isCpu = false
                    else -> {
                        println("Inputan tidak sesuai dengan opsi pilihan!")
                        Utils.handleMessageAlert(dataDecisionArray)
                        println()
                        showMessageVersusCpu() //paksa print statement "ingin lawan cpu" ini kembali, ketika inputan tidak memenuhi kondisi
                    }
                }
            }
        }
    }

    override fun printMessageInputanPlayer(numberPlayer: Int, namePlayer: String, answer: String) {
        print("$numberPlayer. Masukan pemain $numberPlayer (gunting/kertas/batu): $answer")
    }

    override fun readPlayerInput() {
        val enteredString = readLine()!! //take the input from user
        val inputFromUser = enteredString.trim().uppercase()
        Utils.validateEmptyInput(inputFromUser) { isEmpty ->
            if (isEmpty) {
                println("Inputan tidak boleh kosong!")
                Utils.handleMessageAlert(dataSuitArray)
                printMessageInputanPlayer(playerNumber, playerName, "")
                readPlayerInput()
            } else {
                when (inputFromUser) {
                    "GUNTING", "KERTAS", "BATU" -> {
                        if (isPlayer1Turn) suitChoose1 = inputFromUser
                        else suitChoose2 = inputFromUser
                    }
                    else -> {
                        println("Inputan tidak sesuai dengan opsi pilihan!")
                        Utils.handleMessageAlert(dataSuitArray)
                        printMessageInputanPlayer(playerNumber, playerName, "")
                        readPlayerInput()
                    }
                }
            }
        }
    }

    override fun showResult() {
        val result = when {
            super.isDraw(suitChoose1, suitChoose2) -> "DRAW!"
            super.isWin(suitChoose1, suitChoose2) -> "Pemain 1 Menang!"
            else -> if (isCpu) "Komputer menang " else "Pemain 2 Menang!"
        }
        println()
        print("Hasil: ")
        println(result)
    }

    override fun setScore(saveScore: (suitGame: SuitGameImpl) -> Unit) {
        saveScore(this)
    }
}