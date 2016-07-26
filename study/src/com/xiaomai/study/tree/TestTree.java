/*
 * @(#)TestTree.java    Created on 2016年7月26日
 * Copyright (c) 2016 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.xiaomai.study.tree;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author yanlq
 * @version 创建时间：2016年7月26日 上午10:44:16
 */
public class TestTree {
    public static void main(String[] args) {
        Integer[] array = { 2, 4, 6, 8, 3, 3, 5, 7, 9, 3, 5, 6, 7, 9, 0 };
        Tree<Integer> integerTree = new Tree<Integer>();
        integerTree.setArray(array);
        integerTree.createBinTree();
        System.out.println("前序遍历");
        integerTree.preOrderTraverse(integerTree.getNodeList().get(0));
        System.out.println();
        System.out.println("中序遍历");
        integerTree.inOrderTraverse(integerTree.getNodeList().get(0));
        System.out.println();
        System.out.println("后序遍历");
        integerTree.postOrderTraverse(integerTree.getNodeList().get(0));
        System.out.println();
        System.out.println("拆解成一个假链表");
        integerTree.resolveToFakeList(integerTree.getNodeList().get(0));
        Node<Integer> node = integerTree.getNodeList().get(0);
        while (node != null) {
            System.out.println(node.getData());
            System.out.println(node.getLeft() == null ? null : node.getLeft().getData());
            node = node.getRight();
        }
//        String fileName = "D://test.txt";
//        System.out.println("先序遍历序列化到文件" + fileName);
//        StringBuffer sb = integerTree.writeBinaryTree(integerTree.getNodeList().get(0));
//        try {
//            // 打开一个随机访问文件流，按读写方式
//            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
//            // 文件长度，字节数
//            long fileLength = randomFile.length();
//            // 将写文件指针移到文件尾。
//            randomFile.seek(fileLength);
//            randomFile.writeBytes(sb.toString());
//            randomFile.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("最近公共父节点");
        node =integerTree.lowestCommonAncestor(integerTree.getNodeList().get(0),new Integer(4),new Integer(6));
        System.out.println(node.getData());
        System.out.println("堆化");
        integerTree.heapify();
        for(Integer i:array){
        	System.out.print(i+" ");
        }
        System.out.println();
    }
}
