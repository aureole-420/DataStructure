public class IntList{
	public int first;
	public IntList rest;

	// constructor
	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}

	public static void main(String[] args){
		IntList L = new IntList(1,null);
		System.out.println(L.first);
	}
}