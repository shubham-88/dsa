package dsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriDataStructureTest {

	public static void main(String[] args) {

		Trie trie = new Trie();
		List<String> l = List.of("hello", "dog", "hell", "cat", "a", "hel", "help", "helps", "helping");
		for (String key : l) {
			trie.insert(key);
		}
		trie.find("hel");
	}

	static class TrieNode {
		private Map<Character, TrieNode> kids;
		private boolean isWord;
		private int prio;

		TrieNode() {
			kids = new HashMap<Character, TrieNode>();
			isWord = false;
		}

		public Map<Character, TrieNode> getKids() {
			return kids;
		}

		public boolean isWord() {
			return isWord;
		}

		public void setWord(boolean isWord) {
			this.isWord = isWord;
		}

		public int getPrio() {
			return prio;
		}

		public void setPrio(int prio) {
			this.prio = prio;
		}

		@Override
		public String toString() {
			return "TrieNode [kids=" + kids + ", isWord=" + isWord + "]";
		}
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		void insert(String input) {
			TrieNode current = root;
			for (int i = 0; i < input.length(); i++) {
				current = current.getKids().computeIfAbsent(input.charAt(i), c -> new TrieNode());
			}
			current.setWord(true);
		}

		boolean find(String input) {
			TrieNode current = root;
			for (int i = 0; i < input.length(); i++) {
				current = current.getKids().get(input.charAt(i));
				if (null == current)
					return false;
			}
			List<String> res = new ArrayList<String>();
			printSugg(res, current, input);
			System.out.println(res);
			return current.isWord();
		}

		// IMPortent
		public void printSugg(List<String> res, TrieNode current, String input) {
			if (current.isWord()) {
				res.add(input);
			}

			if (current.getKids() != null && current.getKids().size() > 0) {
				for (Character newCurrent : current.getKids().keySet()) {
					printSugg(res, current.getKids().get(newCurrent), input.concat(newCurrent + ""));
				}
			} else {
				return;
			}

		}

		@Override
		public String toString() {
			return "Trie [root=" + root + "]";
		}

	}
}
