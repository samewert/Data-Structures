package PA6;

import java.util.Hashtable;

public class TrieNode {

	public Hashtable<Character, TrieNode> edges;
	public int depth;

	public TrieNode(int depth) {
		edges = new Hashtable<Character, TrieNode>();
		this.depth = depth;
	}
}