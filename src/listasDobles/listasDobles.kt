package listasDobles

const val CLEAR = "\u001b[H\u001b[2J"

class Node(var id: String, var next: Node? = null, var before: Node? = null)

var head: Node? = null
var tile: Node? = null

fun main() {
    var option: Int
    var auxId: String

    do {
        print(listas.CLEAR)

        println("Menu:")
        println("1. Insert.")
        println("2. Show ASC.")
        println("3. Show DSC.")
        println("4. Update.")
        println("5. Delete.")
        println("6. Exit.")
        println("Choose a option:")
        option = readLine()!!.toInt()

        print(CLEAR)

        print(listas.CLEAR)

        when (option) {
            1 -> {
                println("Insert a ID:")
                auxId = readLine()!!

                insert(auxId)
            }
            2 -> {
                if (head != null) {
                    show()
                } else {
                    println("The list is empty.")
                }
            }
            3 -> {
                if (head != null) {
                    show(1)
                } else {
                    println("The list is empty.")
                }
            }
            4 -> {
                if (head != null) {
                    println("Insert a ID to update:")
                    auxId = readLine()!!

                    update(auxId)
                } else {
                    println("The list is empty.")
                }
            }
            5 -> {
                if (head != null) {
                    println("Insert a ID to delete:")
                    auxId = readLine()!!

                    remove(auxId)
                } else {
                    println("The list is empty.")
                }
            }
            6 -> println("Bye..")
            else -> println("\nWrong data, please try again.")
        }

        println("Press ENTER to continue...")
        readLine()
    } while (option != 6)
}

fun insert(auxId: String) {
    if (search(auxId) == null) {
        val newNode = Node(auxId)

        if (head == null) {
            head = newNode
            head!!.next = null
            head!!.before = null
            tile = head
        } else {
            tile!!.next = newNode
            newNode.next = null
            newNode.before = tile
            tile = newNode
        }
    } else {
        println("Already exist a person with this ID: $auxId")
    }
}

fun show(option: Int = 0) {
    var current = if (option == 0) head else tile

    while (current != null) {
        println("The ID: ${current.id}")

        current = if (option == 0) current.next else current.before
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
        if (searchId.next == null && searchId.before == null) {
            head = null
        } else if (searchId.next != null && searchId.before == null) {
            head = head!!.next
            head!!.before = null
        } else if (searchId.next == null && searchId.before != null) {
            tile = tile!!.before
            tile!!.next = null
        } else {
            searchId.before?.next = searchId.next
            searchId.next?.before = searchId.before
        }
    } else {
        println("Exist no one person with the ID: $auxId.")
    }
}

fun search(auxId: String): Node? {
    var current = head

    while (current != null) {
        if (auxId == current.id) {
            return current
        }

        current = current.next
    }

    return null
}