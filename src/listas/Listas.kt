package listas

const val CLEAR = "\u001b[H\u001b[2J"

class Node(var id: String, var next: Node? = null)

var list: Node? = null

fun main() {
    var option: Int
    var auxId: String

    do {
        print(CLEAR)

        println("Menu:")
        println("1. Insert.")
        println("2. Show.")
        println("3. Update.")
        println("4. Delete.")
        println("5. Exit.")
        println("Choose a option:")
        option = readLine()!!.toInt()

        print(CLEAR)

        when (option) {
            1 -> {
                println("Insert a ID:")
                auxId = readLine()!!

                insert(auxId)
            }
            2 -> {
                if (list != null) {
                    show()
                } else {
                    println("The list is empty.")
                }
            }
            3 -> {
                if (list != null) {
                    println("Insert a ID to update:")
                    auxId = readLine()!!

                    update(auxId)
                    //
                } else {
                    println("The list is empty.")
                }
            }
            4 -> {
                if (list != null) {
                    println("Insert a ID to delete:")
                    auxId = readLine()!!

                    remove(auxId)
                } else {
                    println("The list is empty.")
                }
            }
            5 -> println("Bye..")
            else -> println("\nWrong data, please try again.")
        }

        println("Press ENTER to continue...")
        readLine()
    } while (option != 5)
}

fun insert(auxId: String) {
    if (search(auxId) == null) {
        val newNode = Node(auxId)

        if (list == null) {
            list = newNode
            list!!.next = null
        } else {
            val aux = list
            list = newNode
            list!!.next = aux
        }
    } else {
        println("This ID already exists.")
    }
}

fun show() {
    var current = list

    while (current != null) {
        println("The id: ${current.id}")

        current = current.next
    }
}

fun update(auxId: String) {
    val searchId = search(auxId)

    if (searchId != null) {
        println("Insert the new Id:")
        val auxNew = readLine()!!

        if (search(auxNew) != null) {
            searchId.id = auxNew
        } else {
            println("Already exist a person with this ID: $auxNew.")
        }
    } else {
        println("Exist no one person with the ID: $auxId.")
    }
}

fun remove(auxId: String) {
    val searchId = search(auxId)

    if (searchId != null) {
        if (searchId == list) {
            val aux: Node? = list!!.next
            list = aux
        } else {
            var current = list
            var before: Node? = null

            while (current != null) {
                if (auxId == current.id) {
                    before!!.next = current.next
                    break
                }

                before = current
                current = current.next
            }
        }
    } else {
        println("Exist no one person with de ID: $auxId")
    }
}

fun search(auxId: String): Node? {
    var current = list

    while (current != null) {
        if (auxId == current.id) {
            return current
        }

        current = current.next
    }

    return null
}