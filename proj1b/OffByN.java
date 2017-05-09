/**
 * Created by yuhui on 10/5/17.
 */
public class OffByN implements CharacterComparator {
    private int diffN;
    public OffByN (int N){
        diffN = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int d = x-y;
        if (d == diffN || d==-diffN){
            return true;
        }else{
            return false;
        }
    }

}
