/**
 * Created by yuhui on 10/5/17.
 */
public class OffByOne implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y){
        int d = x-y;
        if (d == 1 || d == -1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        OffByOne obo = new OffByOne();
        System.out.println(obo.equalChars('a', 'b'));
        System.out.println(obo.equalChars('r', 'q'));
        System.out.println(obo.equalChars('a', 'e'));
        System.out.println(obo.equalChars('r', 'd'));
    }
}
