public class CircularLinkedListDeque<E>{

	public class Node<E>{
		public E item;
		public Node<E> prev;
		public Node<E> next;

		public Node(E i, Node<E> pr, Node<E> nx){
			item = i;
			prev = pr;
			next = nx;
		}
	}


	private Node<E> sentinel;
	private int size;

	public CircularLinkedListDeque(){
		size = 0;
		sentinel = new Node<>(null,null,null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}

	public void addFirst(E Item){
		size = size +1;
		Node<E> temp = new Node<>(Item,null,null);
		Node<E> p = sentinel.next;
		temp.prev = sentinel;
		temp.next = p;
		p.prev = temp;
		sentinel.next = temp;
	}


	public void addLast(E Item){
		size =size+1;
		Node<E> temp = new Node<>(Item,null,null);
		Node<E> p = sentinel.prev;
		temp.prev = p;
		temp.next =sentinel;
		p.next = temp;
		sentinel.prev = temp;
	}

	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		Node<E> p = sentinel.next;
		int n = 0;
		while(n<size){
			System.out.print(p.item+" ");
			n = n+1;
			p = p.next;
		}
		System.out.println(" ");
	}

	public E removeFirst(){
		if (size == 0){
			return null;
		}else{
			size = size-1;
			Node<E> p = sentinel.next;
			sentinel.next = p.next;
			p.prev = sentinel;
			E a = p.item;

			p.next = null;
			p.prev = null;

			return a;
		}
	}

	public E removeLast(){
		if (size ==0){
			return null;
		}else{
			size = size-1;
			Node<E> p = sentinel.prev;
			sentinel.prev = p.prev;
			p.next = sentinel;
			E a = p.item;

			p.next = null;
			p.prev = null;

			return a;
		}
	}

	public E get(int index){
		if (index <0 || (index+1)>size){
			return null;
		}else{
			int n = 0;
			Node<E> p = sentinel.next;
			while(n<index){
				p = p.next;
				n = n+1;
			}
			return p.item;
		}
	}

	public Node<E> getRecursiveHelper(int index, Node<E> node){
		if (index == 0){
			return node;
		}else{
			return getRecursiveHelper(index-1,node.next);
		}
	}

	public E getRecursive(int index){
		if (index<0 || (index+1)>size){
			return null;
		}
		return getRecursiveHelper(index,sentinel.next).item;
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
		int d = a.getRecursive(1);
		System.out.println("The second item of Deque a is "+d);

	}		



}