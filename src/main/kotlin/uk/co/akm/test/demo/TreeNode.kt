package uk.co.akm.test.demo

/**
 * Created by Thanos Mavroidis on 18/12/2018.
 */
interface TreeNode<out T> {

    val value: T

    val children: Collection<TreeNode<T>>
}