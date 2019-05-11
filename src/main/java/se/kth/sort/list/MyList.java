package se.kth.sort.list;

public interface MyList<T> {
	void add(T e);
	T get(int i);
	void set(int i, T e);
	int size();
}
