public class SSList{
	private class IntNode{
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n){
			this.item = i;
			this.next = n;
		}
	}


	private IntNode first;

	public SSList(){
		first = null;
	}

	public void addFirst(int x){
		first = new IntNode(x,first);
	}

	public void insert(int i, int position){

		if (position == 0){
			first = addFirst(i);
		}else{
			int n = 0;
			IntNode p = first;
			while (n<position-1){
				p = p.next;
				n = n+1;
			}
			IntNode newNode = new IntNode(i, p.next);
			p.next = newNode;
		}
	}
}