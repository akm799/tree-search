package uk.co.akm.test.demo

import org.junit.Assert
import org.junit.Test
import uk.co.akm.test.demo.impl.TreeNodeImpl

/**
 * Created by Thanos Mavroidis on 18/12/2018.
 */
class TreeSearchFunctionsTest {
    private val tree: TreeNode<Int>

    init {
        tree = testTree()
    }

    private fun testTree() : TreeNode<Int> {
        val n0 = TreeNodeImpl<Int>(0)

        val n1 = TreeNodeImpl<Int>(1)
        val n2 = TreeNodeImpl<Int>(2)
        val n3 = TreeNodeImpl<Int>(3)

        n0.addChild(n1)
        n0.addChild(n2)
        n0.addChild(n3)

        n1.addChild(4)
        n1.addChild(5)
        n1.addChild(6)

        n2.addChild(7)
        n2.addChild(8)
        n2.addChild(9)

        n3.addChild(10)
        n3.addChild(11)
        n3.addChild(12)

        return n0
    }

    @Test
    fun shouldFindRootWithoutRecursion() {
        val n0 = findNodeNonRecursive(0, tree)
        Assert.assertNotNull(n0)
        Assert.assertEquals(0, n0?.value)
        Assert.assertEquals(tree, n0)
    }

    @Test
    fun shouldFindNodeWithoutRecursion() {
        val n12 = findNodeNonRecursive(12, tree)
        Assert.assertNotNull(n12)
        Assert.assertEquals(12, n12?.value)
    }

    @Test
    fun shouldFindNotNodeWithoutRecursionWhenItDoesNotExist() {
        val none = findNodeNonRecursive(99, tree)
        Assert.assertNull(none)
    }

    @Test
    fun shouldFindRootWithRecursion() {
        val n0 = findNodeRecursive(0, tree)
        Assert.assertNotNull(n0)
        Assert.assertEquals(0, n0?.value)
        Assert.assertEquals(tree, n0)
    }

    @Test
    fun shouldFindNodeWithRecursion() {
        val n12 = findNodeRecursive(12, tree)
        Assert.assertNotNull(n12)
        Assert.assertEquals(12, n12?.value)
    }

    @Test
    fun shouldFindNotNodeWithRecursionWhenItDoesNotExist() {
        val none = findNodeRecursive(99, tree)
        Assert.assertNull(none)
    }
}