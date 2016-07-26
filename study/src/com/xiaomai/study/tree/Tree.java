/*
 * @(#)Tree.java    Created on 2016年7月26日
 * Copyright (c) 2016 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.xiaomai.study.tree;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 树
 *
 * @author yanlq
 * @version 创建时间：2016年7月26日 上午10:21:28
 */
public class Tree<T> {

    private List<Node<T>> nodeList = null;
    private File file = null;// 序列化反序列化文件
    private StringBuffer buffer = new StringBuffer();
    private T[] array;

    public void createBinTree() {
        nodeList = new LinkedList<Node<T>>();
        // 将数组转换成node节点
        for (int index = 0; index < array.length; index++) {
            nodeList.add(new Node<T>(array[index]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).setLeft(nodeList.get(parentIndex * 2 + 1));
            // 右孩子
            nodeList.get(parentIndex).setRight(nodeList.get(parentIndex * 2 + 2));
        }
        // 单独对最后一个父节点做处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).setLeft(nodeList.get(lastParentIndex * 2 + 1));
        // 右孩子
        if (array.length % 2 == 1) {
            // 右孩子
            nodeList.get(lastParentIndex).setRight(nodeList.get(lastParentIndex * 2 + 2));
        }

    }

    /**
     * 前序遍历
     *
     * @param node
     */
    public void preOrderTraverse(Node<T> node) {
        if (node != null) {
            System.out.print(node.getData());
            System.out.print(" ");
            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
        }
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void inOrderTraverse(Node<T> node) {
        if (node != null) {
            inOrderTraverse(node.getLeft());
            System.out.print(node.getData());
            System.out.print(" ");
            inOrderTraverse(node.getRight());
        }
    }

    /**
     * 后序遍历
     *
     * @param node
     */
    public void postOrderTraverse(Node<T> node) {
        if (node != null) {
            postOrderTraverse(node.getLeft());
            postOrderTraverse(node.getRight());
            System.out.print(node.getData());
            System.out.print(" ");
        }
    }

    /**
     * 拆解成一个假链表
     *
     * @param node
     */
    public Node<T> resolveToFakeList(Node<T> node) {
        if (node != null) {
            Node<T> leftTail = resolveToFakeList(node.getLeft());// 左子树生成的子链表尾节点
            Node<T> rightTail = resolveToFakeList(node.getRight());// 右子树生成的子链表尾节点
            if (leftTail != null) {
                leftTail.setRight(node.getRight());// 左子树尾节点的右孩子指向父节点的右孩子
                node.setRight(node.getLeft());// 节点的右孩子指向节点的左孩子（即左子树的根节点）
            }
            node.setLeft(null);
            if (rightTail != null) {
                return rightTail;
            }
            else if (leftTail != null) {
                return leftTail;
            }
            else {
                return node;
            }
        }
        return null;
        // 头一定是二叉树的根节点，尾是右子树的尾（如果右子树不空）或者（如果右子树空，左子树不空）或者根（如果左右子树都是空）。
    }

    /**
     * 序列化二叉树
     *
     * @param node
     */
    public StringBuffer writeBinaryTree(Node<T> node) {
        if (node != null) {
            buffer.append(node.getData() + " ");
            writeBinaryTree(node.getLeft());
            writeBinaryTree(node.getRight());
        }
        else {
            buffer.append("# ");
        }
        return buffer;
    }
    /**
     * 最近公共父节点
     * @param root
     * @param a
     * @param b
     * @return
     */
    public Node<T> lowestCommonAncestor(Node<T> root,Object a,Object b){
    	if(root==null||root.getData().equals(a)||root.getData().equals(b)){
    		return root;
    	}
    	Node<T> left = lowestCommonAncestor(root.getLeft(), a, b);
    	Node<T> right = lowestCommonAncestor(root.getRight(), a, b);
    	if(left!=null&&right!=null){
    		return root;
    	}else{
    		return left==null?right:left;
    	}
    }
    
    /**
     * 
     */
    public void heapify() {
    	int left;
    	int right;
    	int minPos;
		for(int i=(array.length-1)/2;i>=0;i--){
			while(i<array.length){
				left = i*2+1;
				right = i*2+2;
				minPos=i;
				if(left<array.length&&(Integer)array[left]<(Integer)array[minPos]){
					minPos=left;
				}
				if(right<array.length&&(Integer)array[right]<(Integer)array[minPos]){
					minPos=right;
				}
				if((minPos-i)==0){
					break;
				}else{
					T x=array[i];
					array[i]=array[minPos];
					array[minPos] = x;
					i=minPos;
				}
			}
		}
	}
    
    public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public List<Node<T>> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node<T>> nodeList) {
        this.nodeList = nodeList;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}
