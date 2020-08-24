package arboles.kotlin

fun main() {
    val miTree = Tree()
    var option: Int
    var data: Int

    do {
        println("Menu:")
        println("1. Insert.")
        println("2. Remove.")
        println("3. Find.")
        println("4. Show pre-order.")
        println("5. Show in-order.")
        println("6. Show post-order.")
        println("7. Show level-order.")
        println("8. Exit.")
        println("Choose one:.")
        option = readLine()!!.toInt()

        when (option) {
            1 -> {
                println("\nInsert a new element:")
                data = readLine()!!.toInt()
                miTree.add(data)
            }
            2 -> {
                println("\nInsert the element to remove:")
                data = readLine()!!.toInt()
                miTree.delete(data)
            }
            3 -> {
                println("\nInsert a element to search:")
                data = readLine()!!.toInt()
                miTree.containsNode(data)
            }
            4 -> miTree.traversePreOrder(miTree.getRoot())
            5 -> miTree.traverseInOrder(miTree.getRoot())
            6 -> miTree.traversePostOrder(miTree.getRoot())
            7 -> miTree.traverseLevelOrder()
            8 -> println("Bye...")
            else -> println("\\nWrong data, please try again.")
        }

        println("\n\nPress ENTER to continue...")
        readLine()
    } while (option != 8)
}