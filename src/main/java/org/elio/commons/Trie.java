package org.elio.commons;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;

		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (!node.containsKey(cur)) {
				node.put(cur, new TrieNode());
			}
			node = node.get(cur);
		}
		node.setEnd();
	}

	/**
	 * Returns if the word is in the trie
	 * 
	 * @param word
	 * @return
	 */
	public boolean search(String word) {
		TrieNode node = this.searchPrefix(word);
		return node != null && node.isEnd();
	}

	/**
	 * Returns whether any word in the trie starts with the given prefix
	 * 
	 * @param prefix
	 * @return
	 */
	public boolean startWith(String prefix) {
		TrieNode node = searchPrefix(prefix);
		return node != null;
	}

	public String getLongestCommonPrefix(String word) {
		TrieNode node = root;
		StringBuilder sb = new StringBuilder();
		for (char cur : word.toCharArray()) {
			if (node.containsKey(cur) && node.size() == 1 && !node.isEnd()) {
				sb.append(cur);
				node = node.get(cur);
			} else
				break;
		}
		return sb.toString();
	}

	TrieNode searchPrefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (node.containsKey(cur))
				node = node.get(cur);
			else
				return null;
		}
		return node;
	}
}
