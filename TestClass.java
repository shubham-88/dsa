package dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TestClass {

	public static void main(String[] args)throws Exception {
		Trie trie = new Trie();

		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		String[] db_query = name.split("\\ ");
		int db_count = Integer.valueOf(db_query[0]);
		int q_count = Integer.valueOf(db_query[1]);

		while (db_count > 0) {
			String dbentry = s.nextLine();
			String[] db_column = dbentry.split("\\ ");
			String column_1 = db_column[0];
			Integer column_2 = Integer.parseInt(db_column[1]);
			trie.insert(column_1, column_2);
			db_count--;
		}

		while (q_count >= 0) {
			String qentry = s.nextLine();
			Set<Integer> values = trie.find(qentry.trim());
			System.out.println(values);
			System.out.println(values.isEmpty() ? -1 : values.toArray()[0]);
			values.clear();
			q_count--;
		}
		s.close();

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
	}

	static class Trie {
		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		void insert(String input1, Integer input2) {
			TrieNode current = root;
			for (int i = 0; i < input1.length(); i++) {
				current = current.getKids().computeIfAbsent(input1.charAt(i), c -> new TrieNode());
			}
			current.setPrio(input2);
			current.setWord(true);
		}

		Set<Integer> find(String input) {
			TrieNode current = root;
			Set<Integer> res = new TreeSet<>((v1, v2) -> v2.compareTo(v1));
			StringBuffer str = new StringBuffer();
			for (int i = 0; i < input.length(); i++) {
				current = current.getKids().get(input.charAt(i));
				if (null == current)
					return res;
				else
					str = str.append(input.charAt(i));
			}

			printSugg(current, str, res);
			return res;
		}

		public void printSugg(TrieNode current, StringBuffer input, Set<Integer> values) {
			if (current.isWord()) {
				values.add(current.getPrio());
			}

			if (current.getKids() != null && current.getKids().size() > 0) {
				for (Character newCurrent : current.getKids().keySet()) {
					printSugg(current.getKids().get(newCurrent), input.append(newCurrent), values);
					input.setLength(input.length() - 1);
				}
			} else {
				return;
			}

		}

	}

}
