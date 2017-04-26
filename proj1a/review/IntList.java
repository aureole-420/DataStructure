public class IntList{
	public int first;
	public IntList rest;

	// constructor
	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}

	public static IntList dSquare1(IntList L){
		IntList ptr = L;
		while (ptr != null){
			ptr.first = ptr.first*ptr.first;
			ptr = ptr.rest;
		}
		return L;
	}

	public static void dSquare2(IntList L){
		while (L!=null){
			L.first = L.first * L.first;
			L = L.rest;
		}
	}

	public static void main(String[] args){
		IntList L0 = new IntList(1,null);
		IntList L1 = new IntList(2,L0);
		System.out.println(L1.first);
		//IntList Ls = IntList.dSquare1(L1);
		//System.out.println(Ls.first);
		//System.out.println(Ls.rest.first);
		IntList.dSquare2(L1);
		System.out.println(L1.first);
		System.out.println(L1.rest.first);
	}
}