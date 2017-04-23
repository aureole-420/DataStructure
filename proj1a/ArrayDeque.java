public class ArrayDeque<E>{
	/** Implement Double Ended Queue using an Array. */
	private E[] items;
	private int size;
	private int nextFirst; // addFirst item to nextFirst
	private int nextLast; // addLast item to nextLast
	private double R; // Usage ratio: R = size/items.length.
	private int RFACTOR = 2;

	//////////////////////////////////////////////////
	////////////////// Helper methods/////////////////
	//////////////////////////////////////////////////

	// calRatio method 
	private void updateRatio(){
		R = (double) size / (double) (items.length);
	}


	// minusOne method
	private int minusOne(int index){// helper method
		int r = (index-1) % items.length;
		if (r<0){
			return r+items.length;
		} else{
			return r;
		}
	}
	// plusOne method
	private int plusOne(int index){ // helper method
		int r = (index+1)%items.length;
		return r;
	}


	/** Double array size when array is FULL. */
	private E[] resize(int CAPACITY){
		E[] newDeque = (E[]) new Object[CAPACITY*RFACTOR];
		
		// copy item in items to newDeque
		int n = 0;
		int firstIndex = plusOne(nextFirst);
		while (n < size){
			newDeque[n] = items[(firstIndex+n)%items.length];
			n = n+1;
		} 

		return newDeque;
	}


	/** Half array size when usage ratio is low. */
	private E[] reduceSize(int CAPACITY){

		E[] newDeque = (E[]) new Object[CAPACITY/RFACTOR];

		// copy item in items to newDeque
		int n = 0;
		int firstIndex = plusOne(nextFirst);
		while (n <size){
			newDeque[n] = items[(firstIndex+n)%items.length];
			n = n+1;
		}

		return newDeque;
	}

	// isFull method
	/** Return true if ArrayDeque is full,
	  * otherwise false. */
	private boolean isFull(){

		if (size == items.length){
			return true;
		}else{
			return false;
		}
	}

	/** Return true is Usage ratio R is low. */
	private boolean isLowUsageRatio(){

		if (items.length >= 16 && R <0.25){
			return true;
		}else{
			return false;
		}

	}

	/** Check if Array size need to be adjusted.
	  * if Yes, double or half the ArrayDeque,
	  * otherwise do nothing. */
	private void checkArraySize(){

		if (isFull()){// double the ArrayDeque
			items = resize(items.length);
			nextFirst = items.length-1;
			nextLast = size;
			updateRatio();
		}else if(isLowUsageRatio()){//Half the arraDeque
			items = reduceSize(items.length);
			nextFirst = items.length-1;
			nextLast = size;
			updateRatio();
		} // else do nothing

	}

	/////////////////////////////////////////////////
	////////////////// public  methods //////////////
	/////////////////////////////////////////////////

	/** Constructor */
	public ArrayDeque(){

		size = 0;
		items = (E[]) new Object[8];
		nextFirst = 4;
		nextLast = 5;

		updateRatio();

	}

	/** Returns true if Deque is empty,
	  * false otherwise. */
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}else{
			return false;
		}
	}

	public int size(){
		return size;
	}

	/** Prints the items in the Deque from first to last, 
	  * separated by a space. */
	public void printDeque(){
		if (!isEmpty()){
			int n = 0;
			int front = plusOne(nextFirst);
			while (n<size){
				System.out.print(items[(front+n) % items.length]+" ");
				n = n+1;
			}
			System.out.println(" ");
		}
	}

	/** Prints the whole array that store the Deque. */
	public void printFullArray(){
		if (!isEmpty()){
			int n = 0;
			while(n<items.length){
				System.out.print(items[n]+" ");
				n = n+1;
			}
			System.out.println("\nSize: "+ size);
			System.out.println("items.length: "+ items.length);
			System.out.println("UsageRatio "+R);
			System.out.println(" ");

		}
	}

	/** addFirst method */
	public void addFirst(E x){
	 	// check if resize is needed
		checkArraySize();

	 	items[nextFirst] = x;
	 	size = size + 1;
	 	nextFirst = minusOne(nextFirst);
	 	updateRatio();
	 }

	 public void addLast(E x){
	 	// check if resize is needed
	 	checkArraySize();

	 	items[nextLast] = x;
	 	size = size+1;
	 	nextLast = plusOne(nextLast);
	 	updateRatio();
	 }

	 /** Removes and returns the item at the front of the Deque. 
	   * If no such item exists, returns null. */
	 public E removeFirst(){

	 	if (isEmpty()){ // Empty queue
	 		return null;
	 	}

	 	int firstIndex = plusOne(nextFirst);
	 	E firstItem = items[firstIndex];
	 	items[firstIndex] = null;
	 	nextFirst = firstIndex;
	 	size = size - 1;
	 	
	 	// check if resize is needed
	 	updateRatio();
	 	checkArraySize();	 	

	 	return firstItem;

	 }

	 /** Removes and returns the item at the end of the Deque.
	   * If no such item exists, returns null. */
	 public E removeLast(){
	 	if (isEmpty()){ // empty queue
	 		return null;
	 	}

	 	int lastIndex = minusOne(nextLast);
	 	E lastItem = items[lastIndex];
	 	items[lastIndex] = null;
	 	nextLast = lastIndex;
	 	size = size-1;

	 	// check if resize is needed
	 	updateRatio();
	 	checkArraySize();

	 	return lastItem;
	 }

	 /** Gets the item at the given index, where 0 is the front, 
	   * 1 is the next item, and so forth. If no such item exists,
	   * returns null. */
	 public E get(int index){
	 	if ( index<0 || index>(size-1) ){ // no such an item
	 		return null; 
	 	}
	 	// the index^{th} item starting from first
	 	int firstIndex = plusOne(nextFirst);
	 	return items[(firstIndex+index)%items.length];
	 }


	// tester
	public static void main(String[] args){
		ArrayDeque<Integer> a = new ArrayDeque<>();
		System.out.println(a.R);
		a.addFirst(10);
		a.addFirst(15);
		a.addLast(20);
		a.addLast(30);
		a.addLast(50);
		a.addLast(60);
		a.addLast(70);
		a.addLast(80);
		System.out.println("ArrayDeque a is: ");
		a.printDeque();


		// test resize()
		a.addLast(90);
		System.out.println("\nArrayDeque a is: ");
		a.printDeque();
		System.out.println("\nArray that holds a is:");
		a.printFullArray();

		// test reduceSize()
		a.removeFirst();
		a.removeFirst();
		a.removeFirst();
		a.removeFirst();
		a.removeFirst();
		a.removeFirst();
		System.out.println("\nArrayDeque a is: ");
		a.printDeque();
		System.out.println("\nArray that holds a is:");
		a.printFullArray();
		

		System.out.println("\n Whether ArrayDeque a is full: "+ a.isFull());
		int b = a.removeLast();
		System.out.println("\nThe last item of a is "+b);
		System.out.println("ArrayDeque a is:");
		a.printDeque();
		
		int c = a.removeFirst();
		System.out.println("\nThe first item of a is "+ c);
		System.out.println("ArrayDeque a is:");
		a.printDeque();
		System.out.println("\nThe second item of a is "+a.get(1));
		

	}



}