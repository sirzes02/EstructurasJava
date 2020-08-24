package listas.kotlin

fun main() {
    var option: Int
    var auxId: String
    val miList = List()

    do {
        println("Menu:")
        println("1. Insert.")
        println("2. Show.")
        println("3. Update.")
        println("4. Delete.")
        println("5. Exit.")
        println("Choose a option:")
        option = readLine()!!.toInt()

        when (option) {
            1 -> {
                println("Insert a ID:")
                auxId = readLine()!!

                miList.insert(auxId)
            }
            2 -> miList.show()
            3 -> {
                println("Insert a ID to update:")
                auxId = readLine()!!

                miList.update(auxId)
            }
            4 -> {
                println("Insert a ID to delete:")
                auxId = readLine()!!

                miList.remove(auxId)
            }
            5 -> println("Bye..")
            else -> println("\nWrong data, please try again.")
        }

        println("Press ENTER to continue...")
        readLine()
    } while (option != 5)
}
