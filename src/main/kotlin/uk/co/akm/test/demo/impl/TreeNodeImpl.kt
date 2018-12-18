package uk.co.akm.test.demo.impl

import uk.co.akm.test.demo.TreeNode

/**
 * Created by Thanos Mavroidis on 18/12/2018.
 */
class TreeNodeImpl<T>(override val value: T) : TreeNode<T> {
    private val childrenList = ArrayList<TreeNode<T>>()

    override val children: Collection<TreeNode<T>>
        get() = childrenList

    fun addChild(value: T) : TreeNodeImpl<T> {
        val child = TreeNodeImpl(value)
        childrenList.add(child)

        return child
    }

    fun addChild(child: TreeNode<T>) {
        childrenList.add(child)
    }
}