package com.xiaomai.study.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树节点
 * @author yanlq
 * @version 创建时间：2016年7月26日 上午10:44:16
 */
public class TrieNode {
	private Map map = new HashMap();
	private boolean isLeaf = false;
	
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public boolean isLeaf() {
		return isLeaf;
	}
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
	

}
