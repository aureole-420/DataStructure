public class LinkedListDeque<E>{
	/** Double Ended Queue
	* using two sentinels, one at the 
	* front, one at the end.*/

	// Node class for each Node in the Deque
	public class Node<E>{
		/** Instance variables */
		public E item; 		
		public Node<E> prev;
		public Node<E> next;

		/** ConstNode */
		public Node(E i, Node<E> pr, Node<E> nx){
			item = i;
			prev = pr;
			next = nx;
		}
	}

	/** Instance variables */
	private Node<E> sentF; // Front sentinel
	private Node<E> sentB;// Back sentinel
	private int size;

	/** Public constructor
	  * Creates an empty linked list deque. */
	public LinkedListDeque(){
		size = 0;
		sentF = new Node<>(null,null,null);
		sentB = new Node<>(null,null,null);
		sentF.next = sentB;
		sentB.prev = sentF;
	}


	public void addFirst(E Item){
		/** Adds an item to the front of the Deque. */
		size += 1;
		Node<E> temp = new Node<>(Item, null, null);
		Node<E> p = sentF.next;
		// Rebind
		temp.prev = sentF;
		temp.next = p;
		sentF.next = temp;
		p.prev = temp;
	}

	public void addLast(E Item){
		/** Adds an item to the back of the Deque. */
		size += 1;
		Node<E> temp = new Node<>(Item,null,null);
		Node<E> p = sentB.prev;
		// Rebind
		temp.prev = p;
		temp.next = sentB;
		sentB.prev = temp;
		p.next = temp;
	}

	public boolean isEmpty(){
		/** Returns true if deque is empty, false otherwise. */
		if (size == 0){
			return true;
		}
		return false;
	}

	public int size(){
		/** Returns the number of items in the Deque. */
		return size;
	}

	public void printDeque(){
		/** Prints the items in the Deque from first to last,
		  * separated by a space. */
		Node<E> p = sentF.next;
		while (p.next != null){
			System.out.print(p.item);
			System.out.print(" ");
			p = p.next;
		}
	}

	public E removeFirst(){
		/** Removes and returns the item at the front of the Deque.
		  * If no such item exists, returns null. */
		Node<E> p = sentF.next;
		if (p.next == null){
			/**  No first item. */
			return null;
		}else{
			size -= 1;
			sentF.next = p.next;
			sentF.next.prev = sentF;
			E a = p.item;

			/** put pointer p to garbage collection */
			p.next = null;
			p.prev = null;

			return a;
		}
	}

	public E removeLast(){
		/** Removes and returns the item at the back of the 
		  * Deque. If no such item exists, returns null. */
		Node<E> p = sentB.prev;
		if (p.prev == null){
			/** No last item. */
			return null;
		}else{
			size -= 1;
			sentB.prev = p.prev;
			sentB.prev.next = sentB;
			E a = p.item;
			p.next = null;
			p.prev = null;

			return a;
		}

	}

	public E get(int index){
		/** Gets the item at the given index, where 0 is the front, 
		  * 1 is the next item, and so forth. If no such item exists, 
		  * return null. Must not alter the deque! */
		
		if ((index<0)||(index+1 > this.size)){
			return null;
		}else{
			int n = 0 ;
			Node<E> p = sentF.next;
			while (n < index){
				p = p.next;
				n = n+1;
			}
			return p.item;
		}
	}

	// getRecursive method
	public Node<E> getRecursiveHelper(int index, Node<E> node){
		// helper
		if (index == 0){
			return node;
		}else{
			return getRecursiveHelper(index-1, node.next);
		}
	}

	public E getRecursive(int index){
		// wrapper
		/** Gets the item at the given index recursively. */
		if ((index<0)||(index+1 > this.size)){
			return null;
		}
		return getRecursiveHelper(index, sentF.next).item;
	
	}

	public static void main(String[] args){
		LinkedListDeque<Integer> a = new LinkedListDeque<>();
		a.addFirst(10);
		a.addFirst(12);
		a.addFirst(15);
		a.printDeque();
		System.out.println("Test removeFirst");
		int b = a.removeFirst();
		System.out.println("The first item of Deque a is "+b);
		a.printDeque();
		System.out.println("Test removeLast");
		a.addLast(100);
		a.printDeque();
		int c = a.removeLast();
		System.out.println("The last item of Deque a is "+c);
		System.out.println(c);
		System.out.println(a.get(2));
		a.addLast(500);
		a.printDeque();
		int d = a.getRecursive(2);
		System.out.println("The second item of Deque a is "+d);

	}
}	


