package listasDobles.kotlin

fun main() {
    var option: Int
    var auxId: String
    val miList = DoubleList()

    do {
        println("Menu:")
        println("1. Insert.")
        println("2. Show ASC.")
        println("3. Show DSC.")
        println("4. Update.")
        println("5. Delete.")
        println("6. Exit.")
        println("Choose a option:")
        option = readLine()!!.toInt()

        when (option) {
            1 -> {
                println("Insert a ID:")
                auxId = readLine()!!

                miList.insert(auxId)
            }
            2 -> miList.showASC()
            3 -> miList.showDSC()
            4 -> {
                println("Insert a ID to update:")
                auxId = readLine()!!

                miList.update(auxId)
            }
            5 -> {
                println("Insert a ID to delete:")
                auxId = readLine()!!

                miList.remove(auxId)
            }
            6 -> println("Bye..")
            else -> println("\nWrong data, please try again.")
        }

        println("Press ENTER to continue...")
        readLine()
    } while (option != 6)
}
