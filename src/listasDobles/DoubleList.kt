package listasDobles

class Node(var id: String) {
    var next: Node? = null
    var before: Node? = null
}

class DoubleList {
    private var head: Node? = null
    private var tile: Node? = null

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

    fun showASC() {
        if (head != null) {
            var current = head

            while (current != null) {
                println("The ID: ${current.id}")

                current = current.next
            }
        } else {
            println("The list is empty.")
        }
    }

    fun showDSC() {
        if (head != null) {
            var current = tile

            while (current != null) {
                println("The ID: ${current.id}")

                current = current.before
            }
        } else {
            println("The list is empty.")
        }
    }

    fun update(auxId: String) {
        if (head != null) {
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
        if (head != null) {
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
        } else {
            println("The list is empty.")
        }
    }

    private fun search(auxId: String): Node? {
        var current = head

        while (current != null) {
            if (auxId == current.id) {
                return current
            }

            current = current.next
        }

        return null
    }
}