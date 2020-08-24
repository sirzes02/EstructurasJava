package listas.kotlin

class Node(var id: String) {
    var next: Node? = null
}

class List {
    private var list: Node? = null

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
        if (list != null) {
            var current = list

            while (current != null) {
                println("The id: ${current.id}")

                current = current.next
            }
        } else {
            println("The list is empty.")
        }
    }

    fun update(auxId: String) {
        if (list != null) {
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
        } else {
            println("The list is empty.")
        }
    }

    fun remove(auxId: String) {
        if (list != null) {
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
        } else {
            println("The list is empty.")
        }
    }

    private fun search(auxId: String): Node? {
        var current = list

        while (current != null) {
            if (auxId == current.id) {
                return current
            }

            current = current.next
        }

        return null
    }
}