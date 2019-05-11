package se.kth.sort.list;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements Iterable<E>, MyList<E> {
	private int size;
	private static final int DEFAULT_CAPACITY = 2;
	private Object elements[];

	public MyArrayList() {
		elements = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	public void add(E e) {
		if (size == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}


	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size );
		}
		return (E) elements[i];
	}

	@SuppressWarnings("unchecked")
	public void set(int i, E e) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + size );
		}
		elements[i] = e;
	}

	public int size() {return size;}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			int i = 0;
			@Override
			public boolean hasNext() {
				return i < size;
			}

			@Override
			public E next() {
				return (E) elements[i++];
			}
		};
	}
}
