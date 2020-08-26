package grafos.kotlin

fun main() {
    val miGraph = Graph()
    var name: String
    var origin: String
    var destiny: String
    var option: Int
    var weight: Int

    miGraph.initialize()

    miGraph.insertVertex("afghanistan")
    miGraph.insertVertex("albania")
    miGraph.insertVertex("algeria")
    miGraph.insertVertex("andorra")
    miGraph.insertVertex("angola")
    miGraph.insertVertex("argentina")
    miGraph.insertVertex("armenia")
    miGraph.insertVertex("australia")
    miGraph.insertVertex("austria")
    miGraph.insertVertex("azerbaijan")

    miGraph.insertEdge(miGraph.getVertex("afghanistan")!!, miGraph.getVertex("albania")!!, 800)
    miGraph.insertEdge(miGraph.getVertex("algeria")!!, miGraph.getVertex("afghanistan")!!, 400)
    miGraph.insertEdge(miGraph.getVertex("algeria")!!, miGraph.getVertex("andorra")!!, 300)
    miGraph.insertEdge(miGraph.getVertex("albania")!!, miGraph.getVertex("andorra")!!, 700)
    miGraph.insertEdge(miGraph.getVertex("andorra")!!, miGraph.getVertex("argentina")!!, 900)
    miGraph.insertEdge(miGraph.getVertex("andorra")!!, miGraph.getVertex("armenia")!!, 400)
    miGraph.insertEdge(miGraph.getVertex("andorra")!!, miGraph.getVertex("australia")!!, 350)
    miGraph.insertEdge(miGraph.getVertex("angola")!!, miGraph.getVertex("algeria")!!, 500)
    miGraph.insertEdge(miGraph.getVertex("angola")!!, miGraph.getVertex("albania")!!, 450)
    miGraph.insertEdge(miGraph.getVertex("angola")!!, miGraph.getVertex("BJX")!!, 250)
    miGraph.insertEdge(miGraph.getVertex("angola")!!, miGraph.getVertex("australia")!!, 500)
    miGraph.insertEdge(miGraph.getVertex("argentina")!!, miGraph.getVertex("azerbaijan")!!, 1200)
    miGraph.insertEdge(miGraph.getVertex("armenia")!!, miGraph.getVertex("azerbaijan")!!, 450)
    miGraph.insertEdge(miGraph.getVertex("australia")!!, miGraph.getVertex("azerbaijan")!!, 450)
    miGraph.insertEdge(miGraph.getVertex("australia")!!, miGraph.getVertex("austria")!!, 650)
    miGraph.insertEdge(miGraph.getVertex("austria")!!, miGraph.getVertex("angola")!!, 650)

    do {
        println("\nMenu:")
        println("1. Insert Vertex")
        println("2. Insert Edge")
        println("3. Adjacent list")
        println("4. Size")
        println("5. Remove vertex")
        println("6. remove Edge")
        println("7. Cancel")
        println("8. Width travel")
        println("9. Depth travel")
        println("10. First width")
        println("11. First depth")
        println("12. First better")
        println("13. Exit")
        println("Choose one:")
        option = readLine()!!.toInt()

        when (option) {
            1 -> {
                println("Insert the vertex name:")
                name = readLine()!!

                miGraph.insertVertex(name)
            }
            2 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the origin vertex name: ")
                    origin = readLine()!!
                    println("Insert the destiny vertex name: ")
                    destiny = readLine()!!
                    println("Insert the weight ")
                    weight = readLine()!!.toInt()

                    if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                        println("One of the vertex is invalid.")
                    } else {
                        miGraph.insertEdge(miGraph.getVertex(origin)!!, miGraph.getVertex(destiny)!!, weight)
                    }
                }
            }
            3 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    miGraph.adjacentList()
                }
            }
            4 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Size: " + miGraph.size())
                }
            }
            5 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the vertex name to remove: ")
                    name = readLine()!!

                    if (miGraph.getVertex(name) == null) {
                        println("Invalid vertex.")
                    } else {
                        miGraph.removeVertex(miGraph.getVertex(name)!!)
                    }
                }
            }
            6 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the origin vertex name: ")
                    origin = readLine()!!
                    println("Insert the destiny vertex name: ")
                    destiny = readLine()!!

                    if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                        println("Invalid vertices.")
                    } else {
                        miGraph.removeEdge(miGraph.getVertex(origin)!!, miGraph.getVertex(destiny)!!)
                    }
                }
            }
            7 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    miGraph.cancel()
                }
            }
            8 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the initial vertex name:")
                    name = readLine()!!

                    if (miGraph.getVertex(name) == null) {
                        println("That vertex is invalid.")
                    } else {
                        miGraph.widthTravel(miGraph.getVertex(name)!!)
                    }
                }
            }
            9 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the initial vertex name:")
                    name = readLine()!!

                    if (miGraph.getVertex(name) == null) {
                        println("That vertex is invalid.")
                    } else {
                        miGraph.depthTravel(miGraph.getVertex(name)!!)
                    }
                }
            }
            10 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the origin vertex name: ")
                    origin = readLine()!!
                    println("Insert the destiny vertex name: ")
                    destiny = readLine()!!

                    if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                        println("Invalid vertices.")
                    } else {
                        miGraph.firstWidth(miGraph.getVertex(origin)!!, miGraph.getVertex(destiny)!!)
                    }
                }
            }
            11 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the origin vertex name: ")
                    origin = readLine()!!
                    println("Insert the destiny vertex name: ")
                    destiny = readLine()!!

                    if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                        println("Invalid vertices.")
                    } else {
                        miGraph.firstDepth(miGraph.getVertex(origin)!!, miGraph.getVertex(destiny)!!)
                    }
                }
            }
            12 -> {
                if (miGraph.empty()) {
                    println("The graph is empty.")
                } else {
                    println("Insert the origin vertex name: ")
                    origin = readLine()!!
                    println("Insert the destiny vertex name: ")
                    destiny = readLine()!!

                    if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                        println("Invalid vertices.")
                    } else {
                        miGraph.firstBest(miGraph.getVertex(origin), miGraph.getVertex(destiny)!!)
                    }
                }
            }
            13 -> println("Bye...")
            else -> println("Error, choose a correct option.")
        }

    } while (option != 13)
}