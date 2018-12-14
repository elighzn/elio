package org.elio.commons;

public class TrieNode {

	private TrieNode[] links;
	private final int R = 26;
	private boolean isEnd;
	private int size;

	public TrieNode() {
		links = new TrieNode[R];
		size = 0;
	}

	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
		size++;
	}

	public void setEnd() {
		this.isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}

	// was called getLinks
	public int size() {
		return size;
	}
}
