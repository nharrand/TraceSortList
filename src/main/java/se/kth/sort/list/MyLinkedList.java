package se.kth.sort.list;

public class MyLinkedList<T> implements MyList<T> {
	int size;
	Node<T> head;

	@Override
	public void add(T e) {
		if (size == 0) {
			head = new Node<>(e);
		} else {
			Node<T> cur = head;
			while (cur.next() != null) {
				cur = cur.next();
			}
			cur.setNext(new Node<>(e));
		}
		size++;
	}

	@Override
	public T get(int i) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size );
		}
		Node<T> cur = head;
		for(int j = 0; j < i; j++) cur = cur.next();
		return cur.getVal();
	}

	@Override
	public void set(int i, T e) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size );
		}
		Node<T> cur = head;
		for(int j = 0; j < i; j++) cur = cur.next();
		cur.setVal(e);
	}

	@Override
	public int size() {
		return size;
	}

	class Node<T> {
		T val;
		Node<T> next;

		public Node(T e) {
			val = e;
		}

		public void setVal(T e) {
			val = e;
		}

		public T getVal() {
			return val;
		}

		public void setNext(Node<T> n) {
			next = n;
		}

		public Node<T> next() {
			return next;
		}
	}
}
