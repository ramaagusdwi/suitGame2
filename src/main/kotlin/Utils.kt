class Utils {

    companion object {
        fun handleMessageAlert(arrayString: Array<String>) {
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
        }

        fun validateEmptyInput(
            enteredString: String,
            lambda1: (Boolean) -> Unit
        ) {
            var isEmpty = false
            if (enteredString.isEmpty()) {
                isEmpty = true
            }
            lambda1(isEmpty)
        }


    }


}