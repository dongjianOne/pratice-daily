package com.dong.tree.utils;

import com.dong.tree.model.TreeNode;
import org.springframework.util.ObjectUtils;

import java.util.LinkedList;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 17:31 2021/3/8
 */
public class TreeUtil {

    /**
     * 创建树
     * @param list
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list) {
        TreeNode treeNode = null;
        if (ObjectUtils.isEmpty(list)) {
            return null;
        }
        // 取出第一个元素
        Integer data = list.removeFirst();
        if (!ObjectUtils.isEmpty(data)) {
            treeNode = new TreeNode(data);
            treeNode.leftChild = createBinaryTree(list);
            treeNode.rightChild = createBinaryTree(list);
        }
        return treeNode;
    }

    /**
     * 前序遍历：根-左-右
     * @param node
     */
    public static void proOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        proOrderTraversal(node.leftChild);
        proOrderTraversal(node.rightChild);
    }
}
