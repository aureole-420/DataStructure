/**
 * Created by yuhui on 12/5/17.
 */
public class testIteration {
    public static void main(String[] args){
        int[] someInts = new int[]{1, 2, 3};
        for (int x : someInts) {
            for (int y: someInts) {
                System.out.println("x: " + x +  ", y:" + y);
            }
        }
    }
}
