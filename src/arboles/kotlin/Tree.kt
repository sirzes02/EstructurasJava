package arboles.kotlin

import java.util.*

class Node(var value: Int) {
    var right: Node? = null
    var left: Node? = null
}

class Tree {
    private var root: Node? = null

    fun add(value: Int) {
        root = addRecursive(root, value)
    }

    private fun addRecursive(current: Node?, value: Int): Node? {
        when {
            current == null -> return Node(value)
            value < current.value -> current.left = addRecursive(current.left, value)
            value > current.value -> current.right = addRecursive(current.right, value)
        }
        return current
    }

    fun containsNode(value: Int): Boolean {
        return containsNodeRecursive(root, value)
    }

    private fun containsNodeRecursive(current: Node?, value: Int): Boolean {
        return if (current == null) {
            false
        } else if (value == current.value) {
            true
        } else {
            if (value < current.value) {
                containsNodeRecursive(current.left, value)
            } else {
                containsNodeRecursive(current.right, value)
            }
        }
    }

    fun delete(value: Int) {
        root = deleteRecursive(root, value)
    }

    private fun deleteRecursive(current: Node?, value: Int): Node? {
        return when {
            current == null -> null
            value == current.value -> {
                if (current.left == null && current.right == null) {
                    null
                } else if (current.right == null) {
                    current.left
                } else if (current.left == null) {
                    current.right
                } else {
                    val smallestValue = findSmallestValue(current.right)
                    current.value = smallestValue
                    current.right = deleteRecursive(current.right, smallestValue)
                    current
                }
            }
            value < current.value -> {
                current.left = deleteRecursive(current.left, value)
                current
            }
            else -> {
                current.right = deleteRecursive(current.right, value)
                current
            }
        }
    }

    private fun findSmallestValue(root: Node?): Int {
        return if (root!!.left == null) root.value else findSmallestValue(root.left)
    }

    fun traverseInOrder(node: Node?) {
        if (node != null) {
            traverseInOrder(node.left)
            print(" ${node.value}")
            traverseInOrder(node.right)
        }
    }

    fun traversePreOrder(node: Node?) {
        if (node != null) {
            print(" ${node.value}")
            traversePreOrder(node.left)
            traversePreOrder(node.right)
        }
    }

    fun traversePostOrder(node: Node?) {
        if (node != null) {
            traversePostOrder(node.left)
            traversePostOrder(node.right)
            print(" ${node.value}")
        }
    }

    fun traverseLevelOrder() {
        if (root == null) {
            return
        }

        val nodes: Queue<Node> = LinkedList()
        nodes.add(root)

        while (!nodes.isEmpty()) {
            val node = nodes.remove()

            print(" ${node.value}")

            if (node.left != null) {
                nodes.add(node.left)
            } else if (node.right != null) {
                nodes.add(node.right)
            }
        }
    }

    fun getRoot(): Node? {
        return root
    }
}