public class testIntList{
	public class IntList{
		public int first;
		public IntList rest;

		public static IntList(int f, IntList r){
			first = f;
			rest =r;
		}

		public static void printIntList(IntList L){
			IntList ptr = L;
			while(ptr != null){
				System.out.println(ptr.first);
				ptr = ptr.rest;
			}
		}

		
	}

	public static void main(String[] args){
		IntList L1 = new IntList(1,null);
		IntList L2 = new IntList(2,L1);
		IntList L3 = new IntList(3,L2);
		IntList.printIntList(L3);
	}
}