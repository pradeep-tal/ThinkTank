package com.Trie;

public class Trie {

	private static int ALPHABET_SIZE = 26;

	static TrieNode root;

	public static void main(String[] args) {

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

		if (search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

	}

	static void insert(String key) {

		int level;

		int length = key.length();

		int index;
		
		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {

			index = key.charAt(level) - 'a';

			if (pCrawl.nodes[index] == null) {
				pCrawl.nodes[index] = new TrieNode();
			}

			pCrawl = pCrawl.nodes[index];
		}

		pCrawl.isEndOfWord = true;

	}

	static boolean search(String key) {

		int level;

		int length = key.length();

		int index;

		TrieNode head = root;

		for (level = 0; level < length; level++) {

			index = key.charAt(level) - 'a';

			if (head.nodes[index] == null) {
				return false;
			}

			head = head.nodes[index];
		}

		return head != null && head.isEndOfWord;

	}

	static class TrieNode {

		boolean isEndOfWord;

		TrieNode[] nodes = new TrieNode[26];

		public TrieNode() {

			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				nodes[i] = null;
			}

		}

	}

}
