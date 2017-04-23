public class Tnode<E>{
	/** Test node for generic */
	public E item;
	public Tnode prev;
	public Tnode next;

	// constructor
	public Tnode(E i, Tnode pr, Tnode nx){
		item = i;
		prev = pr;
		next = nx;
	}	


	public static void main(String[] args){
		Tnode<Integer> a = new Tnode<>(2,null,null);
		System.out.println(a.item);
		//IntNode b = new IntNode(null,null,null);
		//System.out.println(b.item);
	}
}
