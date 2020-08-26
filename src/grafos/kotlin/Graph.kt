package grafos.kotlin

import java.util.*
import kotlin.Comparator

class Edge(var weight: Int) {
    var next: Edge? = null
    var adjacent: Vertex? = null

}

class Vertex(var name: String) {
    var next: Vertex? = null
    var adjacent: Edge? = null

}

class PairVertexWeight(var origin: Vertex, var weight: Int)


class Graph {
    private var first: Vertex? = null

    fun initialize() {
        first = null
    }

    fun empty(): Boolean {
        return first == null
    }

    fun size(): Int {
        var cont = 0
        var aux = first

        while (aux != null) {
            cont++
            aux = aux.next
        }

        return cont
    }

    fun getVertex(name: String): Vertex? {
        var aux = first

        while (aux != null) {
            if (aux.name == name) {
                return aux
            }

            aux = aux.next
        }

        return null
    }

    fun insertVertex(name: String) {
        val newVertex = Vertex(name)

        if (empty()) {
            first = newVertex
        } else {
            var aux = first

            while (aux!!.next != null) {
                aux = aux.next
            }

            aux.next = newVertex
        }
    }

    fun insertEdge(origin: Vertex, destiny: Vertex, weight: Int) {
        val newEdge = Edge(weight)
        var aux = origin.adjacent

        if (aux == null) {
            origin.adjacent = newEdge
        } else {
            while (aux!!.next != null) {
                aux = aux.next
            }

            aux.next = newEdge
        }
        newEdge.adjacent = destiny
    }

    fun adjacentList() {
        var vertexAux = first
        var edgeAux: Edge?

        while (vertexAux != null) {
            print(vertexAux.name + "->")
            edgeAux = vertexAux.adjacent

            while (edgeAux != null) {
                if (edgeAux.adjacent != null) {
                    print(edgeAux.adjacent!!.name + "->")
                }

                edgeAux = edgeAux.next
            }

            vertexAux = vertexAux.next
            println()
        }
    }

    fun cancel() {
        first = null
    }

    fun removeEdge(origin: Vertex, destiny: Vertex) {
        var current = origin.adjacent
        var flag = false

        if (current == null) {
            println("The origin vertex have no edges.")
        } else if (current.adjacent === destiny) {
            origin.adjacent = current.next
        } else {
            var before: Edge? = null

            while (current != null) {
                if (current.adjacent === destiny) {
                    flag = true
                    assert(before != null)
                    before!!.next = current.next
                    break
                }

                before = current
                current = current.next
            }

            if (!flag) {
                println("Those two vertices aren't connected.")
            }
        }
    }

    fun removeVertex(vert: Vertex) {
        var current = first
        var aux: Edge?

        while (current != null) {
            aux = current.adjacent

            while (aux != null) {
                if (aux.adjacent === vert) {
                    removeEdge(current, aux.adjacent!!)
                    break
                }

                aux = aux.next
            }

            current = current.next
        }

        current = first

        if (vert === first) {
            first = first!!.next
        } else {
            var before: Vertex? = null

            while (current !== vert) {
                before = current
                current = current!!.next
            }

            before!!.next = current.next
        }
    }

    fun widthTravel(origin: Vertex) {
        var current: Vertex
        val currentQueue: Queue<Vertex> = LinkedList()
        val currentList: MutableList<Vertex> = LinkedList()
        var flag: Boolean
        var flag2: Boolean

        currentQueue.add(origin)

        while (!currentQueue.isEmpty()) {
            flag = false
            current = currentQueue.poll()

            for (vertex in currentList) {
                if (vertex === current) {
                    flag = true
                    break
                }
            }

            if (!flag && current != null) {
                print(current.name + ", ")

                currentList.add(current)

                var aux = current.adjacent

                while (aux != null) {
                    flag2 = false

                    for (vertex in currentList) {
                        if (aux.adjacent === vertex) {
                            flag2 = true
                            break
                        }
                    }

                    if (!flag2) {
                        currentQueue.add(aux.adjacent)
                    }

                    aux = aux.next
                }
            }
        }
    }

    fun depthTravel(origin: Vertex) {
        var current: Vertex
        val currentStack = Stack<Vertex>()
        val currentList: MutableList<Vertex> = LinkedList()
        var flag: Boolean
        var flag2: Boolean

        currentStack.push(origin)

        while (!currentStack.empty()) {
            flag = false
            current = currentStack.pop()

            for (vertex in currentList) {
                if (vertex === current) {
                    flag = true
                    break
                }
            }

            if (!flag && current != null) {
                print(current.name + ", ")

                currentList.add(current)

                var aux = current.adjacent

                while (aux != null) {
                    flag2 = false

                    for (vertex in currentList) {
                        if (aux.adjacent === vertex) {
                            flag2 = true
                            break
                        }
                    }

                    if (!flag2) {
                        currentStack.push(aux.adjacent)
                    }

                    aux = aux.next
                }
            }
        }
    }

    fun firstWidth(origin: Vertex, destiny: Vertex) {
        val currentQueue: Queue<Vertex> = LinkedList()
        val currentStack = Stack<Pair<Vertex, Vertex>>()
        val currentList: MutableList<Vertex> = LinkedList()
        var current: Vertex
        var currentDestiny: Vertex
        var aux: Edge?
        var flag: Boolean
        var flag2: Boolean
        var flag3 = false

        currentQueue.add(origin)

        while (!currentQueue.isEmpty()) {
            flag = false
            current = currentQueue.poll()

            for (vertex in currentList) {
                if (current === vertex) {
                    flag = true
                    break
                }
            }

            if (!flag) {
                if (current === destiny) {
                    flag3 = true
                    currentDestiny = destiny

                    while (!currentStack.isEmpty()) {
                        print(currentDestiny.name + "<-")

                        while (!currentStack.empty() && currentStack.peek().component2() !== currentDestiny) {
                            currentStack.pop()
                        }

                        if (!currentStack.empty()) {
                            currentDestiny = currentStack.peek().component1()
                        }
                    }

                    break
                }

                currentList.add(current)

                aux = current.adjacent

                while (aux != null) {
                    flag2 = false

                    for (vertex in currentList) {
                        if (aux.adjacent === vertex) {
                            flag2 = true
                            break
                        }
                    }

                    if (!flag2) {
                        currentQueue.add(aux.adjacent)
                        currentStack.push(Pair(current, aux.adjacent!!))
                    }

                    aux = aux.next
                }
            }
        }
        if (!flag3) {
            println("There is no path between these two vertices.")
        }
    }

    fun firstDepth(origin: Vertex, destiny: Vertex) {
        var currentVertex: Vertex
        var currentDestiny: Vertex
        val currentStack = Stack<Vertex>()
        val currentList: MutableList<Vertex> = LinkedList()
        val currentStackPair = Stack<Pair<Vertex, Vertex>>()
        var aux: Edge?
        var flag: Boolean
        var flag2: Boolean
        var flag3 = false

        currentStack.push(origin)

        while (!currentStack.empty()) {
            flag = false
            currentVertex = currentStack.pop()

            for (vertex in currentList) {
                if (currentVertex === vertex) {
                    flag = true
                    break
                }
            }

            if (!flag) {
                if (currentVertex === destiny) {
                    flag3 = true
                    currentDestiny = destiny

                    while (!currentStackPair.empty()) {
                        print(currentDestiny.name + "<-")

                        while (!currentStackPair.empty() && currentStackPair.peek().component2() !== currentDestiny) {
                            currentStackPair.pop()
                        }

                        if (!currentStackPair.empty()) {
                            currentDestiny = currentStackPair.peek().component1()
                        }
                    }

                    break
                }

                currentList.add(currentVertex)

                aux = currentVertex.adjacent

                while (aux != null) {
                    flag2 = false

                    for (vertex in currentList) {
                        if (aux.adjacent === vertex) {
                            flag2 = true
                            break
                        }
                    }

                    if (!flag2) {
                        currentStack.push(aux.adjacent)
                        currentStackPair.push(Pair(currentVertex, aux.adjacent!!))
                    }

                    aux = aux.next
                }
            }
        }
        if (!flag3) {
            println("There is no path between these two vertices.")
        }
    }

    fun firstBest(origin: Vertex?, destiny: Vertex) {
        val costsList: MutableList<PairVertexWeight> = LinkedList()
        val orderList: MutableList<PairVertexWeight> = LinkedList()
        val currentStack = Stack<Pair<Vertex, Vertex>>()
        var currentVertex: Vertex
        var currentDestiny: Vertex
        var aux: Edge?
        var currentCost: Int
        var flag: Boolean
        var flag2 = false

        costsList.add(PairVertexWeight(origin!!, 0))
        orderList.add(PairVertexWeight(origin, 0))

        while (orderList.isNotEmpty()) {
            currentVertex = orderList[orderList.size - 1].origin
            currentCost = orderList[orderList.size - 1].weight
            orderList.removeAt(orderList.size - 1)

            if (currentVertex === destiny) {
                println("Cost: $currentCost")

                flag2 = true
                currentDestiny = destiny

                while (!currentStack.empty()) {
                    println(currentDestiny.name + "<-")

                    while (!currentStack.empty() && currentStack.peek().component2() !== currentDestiny) {
                        currentStack.pop()
                    }
                    if (!currentStack.empty()) {
                        currentDestiny = currentStack.peek().component1()
                    }
                }

                break
            }

            aux = currentVertex.adjacent

            while (aux != null) {
                flag = false
                currentCost += aux.weight

                for (vertexWeight in costsList) {
                    if (aux.adjacent === vertexWeight.origin) {
                        flag = true

                        if (currentCost < vertexWeight.weight) {
                            vertexWeight.weight = currentCost

                            for (pairVertexWeight in orderList) {
                                if (pairVertexWeight.origin === aux.adjacent) {
                                    pairVertexWeight.weight = currentCost
                                }
                            }

                            orderList.sortWith(Comparator.comparingInt { obj: PairVertexWeight -> obj.weight })
                            currentStack.push(Pair(currentVertex, aux.adjacent!!))
                            currentCost -= aux.weight
                        }
                    }
                }
                if (!flag) {
                    costsList.add(PairVertexWeight(aux.adjacent!!, currentCost))
                    orderList.add(PairVertexWeight(aux.adjacent!!, currentCost))
                    orderList.sortWith(Comparator.comparingInt { obj: PairVertexWeight -> obj.weight })
                    currentStack.push(Pair(currentVertex, aux.adjacent!!))
                    currentCost -= aux.weight
                }

                aux = aux.next
            }
        }
        if (!flag2) {
            println("There is no path between these two vertices.")
        }
    }
}
