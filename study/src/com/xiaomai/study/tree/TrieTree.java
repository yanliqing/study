package com.xiaomai.study.tree;
/**
 * 字典树
 * @author yanlq
 * @version 创建时间：2016年7月26日 上午10:44:16
 */
public class TrieTree {
	private TrieNode root=new TrieNode();

	/**
	 * 字典树插入元素
	 * @param word
	 */
	public void insert(String word){
		TrieNode root = this.root;
		char  item;
		 for (int i = 0; i < word.length(); i++) {
			  item =  word.charAt(i);
			  if(!root.getMap().containsKey(item)){
				  root.getMap().put(item, new TrieNode());
			  }
			  root =  (TrieNode) root.getMap().get(item);
		 }
		 root.setLeaf(true);
	}
	/**
	 * 字典树搜索
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		TrieNode root = this.root;
		int i=0;
		char  item;
		for(int j=0;j<word.length();j++){
			item = word.charAt(j);
			if(!root.getMap().containsKey(item)){
				return false;
			}
			else{
				i++;
				TrieNode trieNode =(TrieNode) root.getMap().get(item);
				if(i==word.length()&&trieNode.isLeaf()){
					return true;
				}
				root =trieNode;
			}
		}
		return false;
	}
	/**
	 * 根据前缀判断字典树是否存在改前缀字符串
	 * @param prefix
	 * @return
	 */
	public boolean startWith(String prefix){
		TrieNode root = this.root;
		for(int i=0;i<prefix.length();i++){
			char item =prefix.charAt(i);
			if(!root.getMap().containsKey(item)){
				return false;
			}else{
				root = (TrieNode)root.getMap().get(item);
			}
		}
		return true;
	}
}
