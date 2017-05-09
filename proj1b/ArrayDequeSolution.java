import java.util.LinkedList;

/**
 * Isn't this solution kinda... cheating? Yes.
 * The aesthete will be especially alarmed by the fact that this
 * supposed ArrayDeque is actually using a LinkedList. SAD!
 */
public class ArrayDequeSolution<Item> extends LinkedList<Item> implements Deque<Item>{
    @Override
    public void printDeque() {
        //System.out.println("dummy");
        for (int i = 0; i<this.size(); i+=1){
            System.out.println(get(i));
        }
    }

    public Item getRecursive(int i) {
        return get(i);
    }

    @Override
    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args){
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        ads.addFirst(1);
        ads.addLast(2);
        ads.addFirst(3);
        ads.printDeque();
        //System.out.println(ads.get(0));
        //System.out.println(ads.get(1));
    }
}
