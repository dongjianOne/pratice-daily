package com.dong.tree.utils;

import com.dong.tree.model.TreeNode;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 树操作
 * </p>
 *
 * @author: dong
 * @Date: 17:31 2021/3/8
 */
public class TreeUtil {

    /**
     * 创建树(创建方式有多种)
     * @param
     * @return
     */
    public static List<TreeNode> createBinaryTree(List<Integer> arrs) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        for (int data : arrs) {
            nodes.add(new TreeNode(data));
        }
        //arrs.length / 2 - 1是确保最后一个节点的左右子节点都存在
        for (int parentIndex = 0; parentIndex < arrs.size() / 2 - 1; parentIndex++) {
            nodes.get(parentIndex).leftChild = nodes.get(parentIndex * 2 + 1);
            nodes.get(parentIndex).rightChild = nodes.get(parentIndex * 2 + 2);
        }
        int lastParentIndex = arrs.size() / 2 - 1;
        nodes.get(lastParentIndex).leftChild = nodes.get(lastParentIndex * 2 + 1);
        if(arrs.size() % 2 != 0){
            nodes.get(lastParentIndex).rightChild = nodes.get(lastParentIndex * 2 + 2);
        }
        return nodes;
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

    /**
     * 中序遍历：左-右-根
     * @param node
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * 后序遍历：左-右-根
     * @param node
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data + " ");
    }

    /**
     * 层序遍历(深度优先遍历)
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 出队
            root = queue.pop();
            System.out.print(root.data + " ");
            Optional.ofNullable(root.leftChild).ifPresent(queue::add);
            Optional.ofNullable(root.rightChild).ifPresent(queue::add);
        }
    }
}
