package PA3;

public class BST {

	protected BSTNode root;
	protected int size;

	public BST() {
		root = null;
		size = 0;
	}

	public BSTNode search(int key) { // complete this method
		BSTNode tmp = root;
		while(tmp != null) {
			if(tmp.value == key) {
				return tmp;
			} else if(tmp.value < key) {
				tmp = tmp.right;
			} else {
				tmp = tmp.left;
			}
		}
		return null;
	}

	public BSTNode insert(int val) { // complete this method
		if(getSize() == 0) {
			root = new BSTNode(val);
			size++;
			return root;
		}
		BSTNode tmp = root;
		BSTNode parent = null;
		while(tmp != null) {
			if(tmp.value == val) {
				return null;
			} else if(tmp.value < val) {
				parent = tmp;
				tmp = tmp.right;
			} else {
				parent = tmp;
				tmp = tmp.left;
			}
		}
		BSTNode newNode = new BSTNode(val);
		newNode.parent = parent;
		if(parent.value > val) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
		size++;
		return newNode;
	}

	public boolean remove(int val) { // complete this method
		BSTNode nodeToBeDeleted = search(val);
		if(nodeToBeDeleted == null) {
			return false;
		}
		if(nodeToBeDeleted.left != null && nodeToBeDeleted.right != null) {
			BSTNode maxNode = findMax(nodeToBeDeleted.left);
			nodeToBeDeleted.value = maxNode.value;
			nodeToBeDeleted = maxNode;
		}
		if(nodeToBeDeleted.left == null && nodeToBeDeleted.right == null) {
			removeLeaf(nodeToBeDeleted);
		} else {
			removeNodeWithOneChild(nodeToBeDeleted);
		}
		size--;
		return true;
	}

	private void removeLeaf(BSTNode leaf) { // complete this method
		if(leaf.equals(root)) {
			root = null;
		} else {
			BSTNode parent = leaf.parent;
			if(leaf.value <= parent.value) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			leaf.parent = null;
		}
	}

	private void removeNodeWithOneChild(BSTNode node) { // complete this method
		BSTNode child = null;
		if(node.left != null) {
			child = node.left;
			node.left = null;
		} else {
			child = node.right;
			node.right = null;
		}
		if(node.equals(root)) {
			root = child;
			child.parent = null;
		} else {
			if(node.value <= node.parent.value) {
				node.parent.left = child;
			} else {
				node.parent.right = child;
			}
			child.parent = node.parent;
			node.parent = null;
		}
	}

	private static BSTNode findMin(BSTNode node) {
		if (null == node)
			return null;
		while (node.left != null)
			node = node.left;
		return node;
	}

	private static BSTNode findMax(BSTNode node) {
		if (null == node)
			return null;
		while (node.right != null)
			node = node.right;
		return node;
	}

	private static int getHeight(BSTNode node) {
		if (node == null)
			return 0;
		else
			return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	private void print(BSTNode node) {
		if (null != node) {
			System.out.print(node.toString() + " ");
			print(node.left);
			print(node.right);
		}
	}

	public int getHeight() {
		return getHeight(root);
	}

	public void print() {
		print(root);
	}

	public int getSize() {
		return size;
	}
}
