package com.dong.tree.test;

import com.dong.tree.model.TreeNode;
import com.dong.tree.utils.TreeUtil;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author: dong
 * @Date: 17:56 2021/3/8
 */

public class BinaryTreeTest {

    public static void main(String[] args) {
        List<Integer> linkedList = Lists.newLinkedList();
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        // 创建树
        List<TreeNode> nodes = TreeUtil.createBinaryTree(linkedList);
        TreeNode node = nodes.get(0);
        int rootData = node.data;
        System.out.println(rootData + "  ");
        if (node.leftChild != null) {
            TreeNode treeNode = node.leftChild;
            System.out.println(treeNode.data);
            if (treeNode.leftChild != null) {
                System.out.println(treeNode.leftChild.data);
            }
            if (treeNode.rightChild != null) {
                System.out.println(treeNode.rightChild.data);
            }
        }
        if (node.rightChild != null) {
            System.out.println(node.rightChild.data);
        }
        System.out.println("-------------树的前序遍历-------------------");
        TreeUtil.proOrderTraversal(node);
        System.out.println("\n-----------树的中序遍历-------------------");
        TreeUtil.inOrderTraversal(node);
        System.out.println("\n-----------树的后序遍历-----------------");
        TreeUtil.postOrderTraversal(node);

        System.out.println("\n-----------树的层序遍历------------------");
        TreeUtil.levelOrder(node);

    }

    /**
     * 利用TreeMap构建一棵树
     * @return
     */
    static TreeMap<String, String> createTreeMap() {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");
        return map;
    }
}
