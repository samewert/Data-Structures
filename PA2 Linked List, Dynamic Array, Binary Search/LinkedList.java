package PA2;

public class LinkedList {

	public ListNode head, tail;
	public int size;

	public LinkedList() {
		head = tail = null;
		size = 0;
	}

	public void insertAfter(ListNode argNode, int value) { // complete this method
		ListNode newNode = new ListNode(value);
		newNode.next = argNode.next;
		argNode.next = newNode;
		if(this.tail.equals(argNode)) {
			this.tail = newNode;
		}
		size++;
	}

	public void deleteAfter(ListNode argNode) { // complete this method
		if(argNode.equals(this.tail)) {
			System.out.println("Cannot delete after tail.");
		} else if(argNode.next.equals(this.tail)) {
			argNode.next = null;
			this.tail = argNode;
			size--;
		} else {
			ListNode temp = argNode.next;
			argNode.next = temp.next;
			temp.next = null;
			size--;
		}
	}

	public void selectionSort() { // complete this method
		ListNode iNode = this.head;
		for(int i = 0; i < getSize() - 1; i++) {
			ListNode minNode = iNode;
			ListNode jNode = iNode.next;
			for(int j = i + 1; j < getSize(); j ++) {
				if(jNode.value < minNode.value) {
					minNode = jNode;
				}
				jNode = jNode.next;
			}
			if(minNode.value != iNode.value) {
				int temp = iNode.value;
				iNode.value = minNode.value;
				minNode.value = temp;
			}
			iNode = iNode.next;
		}
	}

	public boolean removeDuplicatesSorted() { // complete this method
		for(ListNode temp = this.head; temp.next != null; temp = temp.next) {
			if(temp.value > temp.next.value) {
				return false;
			}
		}
		
		ListNode temp = this.head;
		while(temp.next != null) {
			if(temp.value == temp.next.value) {
				deleteAfter(temp);
			} else {
				temp = temp.next;
			}
		}		
		return true;
	}

	public void pushOddIndexesToTheBack() { // complete this method
		ListNode temp = this.head;
		int length = getSize();
		for(int i = 0; i < length/2; i++) {
			this.insertAtEnd(temp.next.value);
			this.deleteAfter(temp);
			temp = temp.next;
		}
	}

	ListNode insertAtFront(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		size++;
		return newNode;
	}

	ListNode insertAtEnd(int value) {
		ListNode newNode = new ListNode(value);
		if (size == 0) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
		return newNode;
	}

	void deleteHead() {
		if (0 == size) {
			System.out.println("Cannot delete from an empty list");
		} else if (1 == size) {
			head = tail = null;
			size--;
		} else {
			size--;
			ListNode tmp = head;
			head = head.next;
			tmp.next = null;
			tmp = null;
		}
	}

	public ListNode getNodeAt(int pos) {
		if (pos < 0 || pos >= size || 0 == size) {
			System.out.println("No such position exists");
			return null;
		} else {
			ListNode tmp = head;
			for (int i = 0; i < pos; i++)
				tmp = tmp.next;
			return tmp;
		}
	}

	void printList() {
		if (size == 0)
			System.out.println("[]");
		else {
			ListNode tmp = head;
			String output = "[";
			for (int i = 0; i < size - 1; i++) {
				output += tmp.value + " -> ";
				tmp = tmp.next;
			}
			output += tail.value + "]";
			System.out.println(output);
		}
	}

	public int getSize() {
		return size;
	}
}
