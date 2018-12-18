package uk.co.akm.test.demo

/**
 * Created by Thanos Mavroidis on 18/12/2018.
 */

fun <T> findNodeRecursive(value: T, node: TreeNode<T>): TreeNode<T>? {
    if (node.value == value) {
        return node
    }

    node.children.forEach {
        val found = findNodeRecursive(value, it) // Recursive call
        if (found != null) {
            return found
        }
    }

    return null
}

fun <T> findNodeNonRecursive(value: T, root: TreeNode<T>): TreeNode<T>? {
    val excluded = mutableSetOf<T>()

    var moreToExclude = true
    while (moreToExclude) {
        val nExcludedAlready = excluded.size
        val found = findNodeNonRecursive(value, root, excluded)
        moreToExclude = (excluded.size > nExcludedAlready)

        if (found != null) {
            return found
        }
    }

    return null
}

private fun <T> findNodeNonRecursive(value: T, node: TreeNode<T>, excluded: MutableSet<T>): TreeNode<T>? {
    var test: TreeNode<T>? = node
    while (test != null) {
        if (test.value == value) {
            return test
        }

        excludeNodeIfLeafOrSpent(test, excluded)
        test = test.children.firstOrNull { !excluded.contains(it.value) }
    }

    return null
}

private fun <T> excludeNodeIfLeafOrSpent(node: TreeNode<T>, excluded: MutableSet<T>) {
    if (node.children.isEmpty() || node.children.asSequence().all { excluded.contains(it.value) }) {
        excluded.add(node.value)
    }
}