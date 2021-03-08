package com.dong.tree.test;

import com.dong.tree.model.TreeNode;
import com.dong.tree.utils.TreeUtil;
import com.google.common.collect.Lists;
import org.springframework.boot.actuate.endpoint.web.Link;

import java.util.LinkedList;
import java.util.List;

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
        LinkedList<Integer> linkedList = Lists.newLinkedList();
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(3);
        // 创建树
        TreeNode binaryTree = TreeUtil.createBinaryTree(linkedList);
        // 前序遍历树
        TreeUtil.proOrderTraversal(binaryTree);
    }
}
