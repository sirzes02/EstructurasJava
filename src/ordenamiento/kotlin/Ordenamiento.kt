@file:Suppress("unused")

package ordenamiento.kotlin

import java.util.*
import kotlin.math.ln
import kotlin.math.pow


fun main() {
    val arr = intArrayOf(4, 8, 5, 10, 7, 10, 1, 9, 3, 20, -2, 6)
    val order = quickSort(arr, 0, arr.size - 1)

    for (i in order) {
        print("$i <> ")
    }
}

fun bubbleSort(arr: IntArray): IntArray {
    val length = arr.size
    var temp: Int

    for (i in 0 until length) {
        for (j in 1 until length - i) {
            if (arr[j - 1] > arr[j]) {
                temp = arr[j - 1]
                arr[j - 1] = arr[j]
                arr[j] = temp
            }
        }
    }

    return arr
}

fun selectionSort(arr: IntArray): IntArray {
    val length = arr.size
    var minIdx: Int
    var temp: Int

    for (i in 0 until length - 1) {
        minIdx = i

        for (j in i + 1 until length) {
            if (arr[j] < arr[minIdx]) {
                minIdx = j
            }
        }

        temp = arr[minIdx]
        arr[minIdx] = arr[i]
        arr[i] = temp
    }

    return arr
}

fun insertionSort(arr: IntArray): IntArray {
    val length = arr.size
    var key: Int
    var i: Int

    for (j in 1 until length) {
        key = arr[j]
        i = j - 1

        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i]
            i--
        }

        arr[i + 1] = key
    }

    return arr
}

fun shellSort(arr: IntArray): IntArray {
    val length = arr.size
    var jump: Int
    var aux: Int
    var change: Boolean

    jump = length / 2
    while (jump != 0) {
        change = true

        while (change) {
            change = false

            for (i in jump until length) {
                if (arr[i - jump] > arr[i]) {
                    aux = arr[i]
                    arr[i] = arr[i - jump]
                    arr[i - jump] = aux
                    change = true
                }
            }
        }

        jump /= 2
    }

    return arr
}

fun radixSort(arr: IntArray): IntArray {
    var max = 10
    val nBytes = 4
    val nColas = 2.toDouble().pow(nBytes).toInt()
    val cola: Array<Queue<Int>?> = arrayOfNulls(nColas)
    var div = 0
    var numCola: Int
    var j: Int

    for (i in 0 until nColas - 1) {
        cola[i] = LinkedList()
    }

    for (i in 0 until max) {
        for (number in arr) {
            if (i == 0 && number > max) {
                max = number
            }

            numCola = number shr div and 0xf
            cola[numCola]?.add(number)
        }

        div += nBytes
        j = 0

        for (c in cola) {
            if (c != null) {
                while (!c.isEmpty()) {
                    arr[j++] = c.remove()
                }
            }
        }

        if (i == 0) {
            max = ((ln(max.toDouble()) / ln(nColas.toDouble())) + 1).toInt()
        }
    }

    return arr
}

fun bucketSort(arr: IntArray, n: Int): IntArray {
    val b: Array<ArrayList<Int>?> = arrayOfNulls(n)
    var index = 0
    var idx: Int

    for (i in 0 until n) {
        b[i] = ArrayList()
    }

    for (i in 0 until n) {
        idx = arr[i] * n
        b[idx]?.add(arr[i])
    }

    for (i in 0 until n) {
        b[i]?.sort()
    }

    for (i in 0 until n) {
        for (j in b[i]?.indices!!) {
            arr[index++] = b[i]?.get(j)!!
        }
    }

    return arr
}

fun mergeSort(arr: IntArray): IntArray {
    var i = 0
    var j: Int
    var p: Int

    while (i < arr.size) {
        j = 0

        while (j < arr.size) {
            p = i shr 1
            merge(arr, j, j + p - 1, j + p, j + p + p - 1)

            j += i
        }

        i *= 2
    }
    merge(arr, 0, i / 2 - 1, i / 2, arr.size)

    return arr
}

fun merge(arr: IntArray, a: Int, b: Int, c: Int, d: Int) {
    val d1 = d.coerceAtMost(arr.size - 1)
    val mer: Array<Int?> = arrayOfNulls(d1 - a + 1)
    var idx = 0
    var a1 = a
    var c1 = c


    while (idx < mer.size) {
        if (if (a > b) false else (if (c > d) true else arr[a] <= arr[c])) {
            mer[idx++] = arr[a1++]
        } else {
            mer[idx++] = arr[c1++]
        }
    }

    for (i in mer.indices) {
        arr[a + 1] = mer[i]!!
    }
}

fun quickSort(arr: IntArray, izq: Int, der: Int): IntArray {
    val pivot = arr[izq]
    var i = izq
    var j = der
    var aux: Int

    while (i < j) {
        while (arr[i] <= pivot && i < j) {
            i++
        }

        while (arr[j] > pivot) {
            j--
        }

        if (i < j) {
            aux = arr[i]
            arr[i] = arr[j]
            arr[j] = aux
        }
    }

    arr[izq] = arr[j]
    arr[j] = pivot

    if (izq < j - 1) {
        quickSort(arr, izq, j - 1)
    }

    if (j + 1 < der) {
        quickSort(arr, j + 1, der)
    }

    return arr
}
