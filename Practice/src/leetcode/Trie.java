package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	class TrieNode {
		Map<Character, TrieNode>nodeMap;
		boolean isEndOfWord;
		public TrieNode() {
			nodeMap = new HashMap<>();
			isEndOfWord = false;
		}
	}
	
	private final TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	/**
	 * Add word recursively to a trie
	 * @param root
	 * @param word
	 * @param pos
	 */
	public void add(TrieNode root, String word, int pos) {
		if(pos == word.length()) {
			root.isEndOfWord = true;
			return;
		} else {
			char curr = word.charAt(pos);
			TrieNode n = root.nodeMap.get(curr);
			if(n == null) {
				n = new TrieNode();
				root.nodeMap.put(curr, n);
			}
			add(n, word, pos+1);
		}
	}
	
	/**
	 * Add word iteratively to a trie
	 * @param root
	 * @param word
	 */
	public void add(TrieNode root, String word) {
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = curr.nodeMap.get(c);
			if(node == null) {
				node = new TrieNode();
				curr.nodeMap.put(c, node);
			}
			curr = node;
		}
		curr.isEndOfWord = true;
	}
	
	/**
	 * Search a word recursively in a trie
	 * @param root
	 * @param word
	 * @param pos
	 * @return
	 */
	public boolean search(TrieNode root, String word, int pos) {
		if(pos == word.length()) {
			return root.isEndOfWord;
		} else {
			TrieNode n = root.nodeMap.get(word.charAt(pos));
			if(n == null) return false;
			return search(n, word, pos+1);
		}
	}
	
	/**
	 * Search iteratively in a trie
	 * @param root
	 * @param word
	 * @return
	 */
	public boolean search(TrieNode root, String word) {
		TrieNode curr = root;
		for(int i = 0; i < word.length(); i++) {
			TrieNode node = curr.nodeMap.get(word.charAt(i));
			if(node == null) return false;
			curr = node;
		}
		return curr.isEndOfWord;
	}
	
	/**
	 * Search for a prefix recursively in a trie
	 * @param root
	 * @param prefix
	 * @param pos
	 * @return
	 */
	public boolean startsWith(TrieNode root, String prefix, int pos) {
		if(pos == prefix.length()) {
			return true;
		}
		else {
			TrieNode n = root.nodeMap.get(prefix.charAt(pos));
			if(n == null) return false;
			return startsWith(n, prefix, pos+1);
		}
	}
	
	/**
	 * Search for a prefix iteratively in a trie 
	 * @param root
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(TrieNode root, String prefix) {
		TrieNode curr = root;
		int i = 0;
		for(i = 0; i < prefix.length(); i++) {
			TrieNode node = curr.nodeMap.get(prefix.charAt(i));
			if(node == null) return false;
			curr = node;
		}
		return i == prefix.length();
	}
	
	/**
	 * Delete a word from Trie recursively
	 * @param root
	 * @param word
	 * @param pos
	 * @return
	 */
	public boolean delete(TrieNode root, String word, int pos) {
		//We reached end of word
		if(pos == word.length()) {
			//Check if the word exists by checking isEndOfWord for last character
			if(!root.isEndOfWord) return false;
			//Else we are deleting the word, and return if we can get rid of the trie node.
			return root.nodeMap.isEmpty();
		}
		TrieNode node = root.nodeMap.get(word.charAt(pos));
		
		//Word does not exist
		if(node == null) return false;
		
		//Call recursively for the next character of the word
		boolean shouldBeDeleted = delete(node, word, pos+1);
		
		//If this is true we know, we can safely delete the map entry in current one.
		//Then return if it's safe to delete the current trie altogether.
		if(shouldBeDeleted) {
			root.nodeMap.remove(word.charAt(pos));
			return root.nodeMap.isEmpty();
		}
		return false;
	}
	
	public static void main(String arg[]) {
		Trie t = new Trie();
		t.add(t.root, "apple", 0);
		t.add(t.root, "ape", 0);
		t.add(t.root,  "banana", 0);
		t.add(t.root, "peach", 0);
		t.add(t.root, "pear");
		t.add(t.root, "peat");
		t.delete(t.root, "apple", 0);
		t.delete(t.root, "peat", 0);
		t.delete(t.root, "banana", 0);
		System.out.println(t.search(t.root, "apple", 0));
		System.out.println(t.search(t.root, "pear", 0));
		System.out.println(t.search(t.root, "ape"));
		System.out.println(t.search(t.root, "banana", 0));
		System.out.println(t.search(t.root, "peat", 0));
		System.out.println(t.startsWith(t.root, "ap", 0));
		System.out.println(t.startsWith(t.root, "pal", 0));
		System.out.println(t.startsWith(t.root, "le", 0));
		System.out.println(t.startsWith(t.root, "", 0));
		System.out.println(t.startsWith(t.root, "peat"));
		//t.printTrie(t.root);
	}
}
