package se.kth.sort;

import se.kth.sort.list.MyArrayList;
import se.kth.sort.list.MyLinkedList;
import se.kth.sort.list.MyList;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class App {

	public static void main(String[] args) throws NumberFormatException {
		if (args.length < 3) {
			printUsage();
			return;
		}

		Consumer<MyList<Integer>> sort;
		Supplier<MyList<Integer>> listConstructor;

		if (args[0].equalsIgnoreCase("LinkedList")) listConstructor = MyLinkedList::new;
		else listConstructor = MyArrayList::new;

		if(args[1].equalsIgnoreCase("Bubble")) sort = l -> bubbleSort(l);
		else if(args[1].equalsIgnoreCase("Quick")) sort = l -> quickSort(l);
		else sort = l -> insertSort(l);

		MyList<Integer> list = toIntList(Arrays.copyOfRange(args,2, args.length), listConstructor);
		sort.accept(list);
		print(list);
	}

	public static void printUsage() {
		System.out.println("Usage se.kth.sort.App <ListType> <SortAlgo> i0...in");
		System.out.println("\t\tListType in (LinkedList, ArrayList)");
		System.out.println("\t\tSortAlgo in (Bubble, Insert, Quick)");
	}

	public static MyList<Integer> toIntList(String[] in, Supplier<MyList<Integer>> listConstructor) throws NumberFormatException {
		MyList<Integer> result = listConstructor.get();
		for(String str: in) {
			result.add(Integer.parseInt(str));
		}
		return result;
	}

	public static void print(MyList<Integer> l) {
		boolean first =true;
		for(int i = 0; i < l.size(); i++) {
			if (first) first = false;
			else
				System.out.print(", ");
			System.out.print(l.get(i));
		}
		System.out.println();
	}

	public static void bubbleSort(MyList<Integer> l) {
		int n = l.size();
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (l.get(j) > l.get(j + 1)) {
					int temp = l.get(j);
					l.set(j, l.get(j + 1));
					l.set(j + 1, temp);
				}
			}
		}
	}
	public static void insertSort(MyList<Integer> l) {
		int n = l.size();
		for (int i = 1; i < n; ++i) {
			int key = l.get(i);
			int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
			while (j >= 0 && l.get(j) > key) {
				l.set(j+1, l.get(j));
				j = j - 1;
			}
			l.set(j+1, key);
		}
	}

	static int partition(MyList<Integer> list, int low, int high) {
		int pivot = list.get(high);
		int i = (low-1); // index of smaller element
		for (int j=low; j<high; j++) {
			// If current element is smaller than or
			// equal to pivot
			if (list.get(j) <= pivot) {
				i++;

				// swap arr[i] and arr[j]
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = list.get(i+1);
		list.set(i+1, list.get(high));
		list.set(high, temp);

		return i+1;
	}


	/* The main function that implements QuickSort()
	  arr[] --> Array to be sorted,
	  low  --> Starting index,
	  high  --> Ending index */
	static void quickSortRec(MyList<Integer> list, int low, int high) {
		if (low < high)
		{
            /* pi is partitioning index, arr[pi] is
              now at right place */
			int pi = partition(list, low, high);

			// Recursively sort elements before
			// partition and after partition
			quickSortRec(list, low, pi-1);
			quickSortRec(list, pi+1, high);
		}
	}

	public static void quickSort(MyList<Integer> list) {
		quickSortRec(list, 0, list.size()-1);
	}
}
