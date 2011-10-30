package se.chalmers.hajo.debug.buffer;

import java.util.Random;

/**
 * A SortedBuffer is a buffer of limited size that keeps n nonnegative integers
 * sorted in ascending order. The elements are stored consecutively, with the
 * first element in position 0.
 * 
 * @author Uno Holmer
 * @version 2010-09-09
 */
public class SortedBuffer {
	private int size; // the number of stored elements
	private int[] buffer; // the elements

	/**
	 * Creates an empty buffer of the given capacity.
	 */
	public SortedBuffer(int capacity) {
		buffer = new int[capacity];
		size = 0;
	}

	/**
	 * Determine the number of elements stored in this buffer.
	 * 
	 * @return the number of elements.
	 */
	public int size() {
		return size;
	}

	/**
	 * Determine the capacity of this buffer. The capacity is a measure of the
	 * buffer's total allocated space, stored elements included.
	 * 
	 * @return the capacity of this buffer
	 */
	public int capacity() {
		return buffer.length;
	}

	/**
	 * Find the it'h element of this buffer. The call succeeds if the position
	 * of the specified element is within the range of the stored elements,
	 * otherwise it fails. The operation does not alter the contents of the
	 * buffer.
	 * 
	 * @param i
	 *            the position of the wanted element.
	 * @return the element at the specified position if the call succeeds, -1
	 *         otherwise.
	 */
	public int get(int i) {
		if (i < 0 || i >= size)
			return -1;
		else
			return buffer[i];
	}

	/**
	 * Insert a new element into this buffer. If the insertion does not violate
	 * the buffer's capacity it succeeds, otherwise it fails. If size returns n
	 * before the insertion, it will return n+1 after any successful insertion.
	 * The new element is inserted in any position that preserves ascending
	 * order among the n+1 elements.
	 * 
	 * @param x
	 *            the element to be inserted
	 * @return true if the insertion succeeds, false ow
	 */
	public boolean insert(int x) {
		if (x < 0 || size == buffer.length)
			return false;

		// find the insertion point and move elements
		int i = size;
		while (i > 0 && buffer[i] < x) {
			buffer[i] = buffer[i - 1];
			i--;
		}
		buffer[i] = x;
		size++;
		return true;
	}

	/**
	 * Remove an element from this buffer. The removal succeeds if the position
	 * of the specified element is within the range of the stored elements,
	 * otherwise it fails. After a successful removal, the remaining elements are
	 * packed in consecutive ascending order. If size returns n+1 before the
	 * removal, it will return n after any successful removal. The stored
	 * elements are left untouched in case of failure.
	 * 
	 * @param i
	 *            the position of the element to be removed
	 * @return true if the removal succeeds, false ow
	 */
	public boolean remove(int i) {
		if (i < 0 || i >= size)
			return false;

		for (int j = i; j < size - 1; j++)
			buffer[j] = buffer[j + 1];
		size--;
		return true;
	}

	/**
	 * Determine if the elements in this buffer are sorted in ascending order.
	 * 
	 * @return true if all elements are ordered, false otherwise.
	 */
	public boolean isOrdered() {
		for (int i = 0; i < size() - 1; i++)
			if (get(i) > get(i + 1))
				return false;

		return true;
	}
	
	// Bad to have here,just for now
	public static void main(String[] args){
		final Random r = new Random();
		final int MAX = 8;
		SortedBuffer sb = new SortedBuffer(MAX);
		for(int i = 0 ; i < MAX ; i++){
			sb.insert(r.nextInt(10)+1);
		}
		for(int i = 0 ; i < sb.size(); i++){
			System.out.println(sb.get(i));
		}
		System.out.println("Buffer is ordered " + sb.isOrdered());
		sb.remove(1);
		sb.remove(4);
		for(int i = 0 ; i < sb.size(); i++){
			System.out.println(sb.get(i));
		}
		System.out.println("Buffer is ordered " + sb.isOrdered());
		
	}
	
}
