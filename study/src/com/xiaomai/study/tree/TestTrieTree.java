package com.xiaomai.study.tree;

public class TestTrieTree {
	public static void main(String[] args) {
		TrieTree trieTree = new TrieTree();
		trieTree.insert("xiaomai");
		trieTree.insert("xiaoqing");
		trieTree.insert("xiatian");
		trieTree.insert("dajia");
		trieTree.insert("dajie");
		trieTree.insert("dasao");
		System.out.println("字典树查找");
		System.out.println("xxx is exist "+trieTree.search("xxx"));
		System.out.println("xiaomai is exist "+trieTree.search("xiaomai"));
		System.out.println("daxiao is exist "+trieTree.search("daxiao"));
		System.out.println("dao is exist "+trieTree.search("dao"));
		System.out.println("dasao is exist "+trieTree.search("dasao"));
		System.out.println("字典树前缀查找");
		System.out.println("xxx is exist startwith "+trieTree.startWith("xxx"));
		System.out.println("xiao is exist startwith "+trieTree.startWith("xiao"));
		System.out.println("dajie is exist startwith "+trieTree.startWith("dajie"));
		System.out.println("sao is exist startwith "+trieTree.startWith("sao"));
		System.out.println("xiaoq is exist startwith "+trieTree.startWith("xiaoq"));
	}
}
