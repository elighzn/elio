package org.elio.commons;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TrieTest {

	@Test
	void testGetLongestCommonPrefix() {
		Trie trie = new Trie();
		
		trie.insert("abab");
		trie.insert("aba");
		trie.insert("");
		Assert.assertEquals("", trie.getLongestCommonPrefix("abab"));
		
		trie = new Trie();
		
		trie.insert("flower");
		trie.insert("flow");
		trie.insert("flight");
		
		Assert.assertEquals("fl", trie.getLongestCommonPrefix("flower"));
	}

}
