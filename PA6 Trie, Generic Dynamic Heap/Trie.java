package PA6;

public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode(0);
	}

	private TrieNode locus(String str) { // complete this method
		TrieNode tmp = root;
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode child = tmp.edges.get(c);
			if(child == null) {
				return tmp;
			} else {
				tmp = child;
			}
		}
		return tmp;
	}

	public void insert(String str) { // complete this method
		TrieNode parent = locus(str);
		int depth = parent.depth;
		for(int i = depth; i < str.length(); i++) {
			char c = str.charAt(i);
			TrieNode child = new TrieNode(i + 1);
			parent.edges.put(c, child);
			parent = child;
		}
	}

	public boolean search(String str) { // complete this method
		TrieNode tmp = locus(str);
		if(tmp.depth == str.length()) {
			return true;
		}
		return false;
	}
}
