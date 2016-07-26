/*
 * @(#)Node.java    Created on 2016年7月26日
 * Copyright (c) 2016 ZDSoft Networks, Inc. All rights reserved.
 * $Id$
 */
package com.xiaomai.study.tree;

/**
 * 树的节点
 *
 * @author yanlq
 * @version 创建时间：2016年7月26日 上午10:09:44
 */
public class Node<T> {

    private Node<T> left;
    private Node<T> right;
    private Object data;

    /**
     * @param left
     * @param right
     * @param data
     */
    public Node(Object data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
