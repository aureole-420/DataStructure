import static org.junit.Assert.*;
import org.junit.Test;

public class Palindrome {

    public static Deque<Character> wordToDeque(String word){
        Deque<Character> result = new ArrayDequeSolution<>();
        for (int i = 0; i< word.length();i+=1){
            result.addLast(word.charAt(i));
        }
        return result;
    }

    /** isPalindrome method using methods of String class
     public static boolean isPalindrome(String word){
     if (word.length() == 0 || word.length() == 1){
     return true;
     }else{
     if (word.length()==2){
     return (word.charAt(0)==word.charAt(word.length()-1));
     }else{
     return (word.charAt(0)==word.charAt(word.length()-1)) && isPalindrome(word.substring(1,word.length()-1));
     }
     }

     }
     */

    // Helper method for the recursive isPalindrome method
    private static boolean isPalindromeHelper(Deque<Character> wd){
        int s = wd.size();
        if (s == 0 || s == 1){
            return true;
        }else{
            Character f = wd.removeFirst();
            Character l = wd.removeLast();
            return f.equals(l) && isPalindromeHelper(wd);
        }
    }

    public static boolean isPalindrome(String word){
        Deque<Character> wd = wordToDeque(word);
        return isPalindromeHelper(wd);
    }

    private static boolean isPalindromeHelper(Deque<Character> wd, CharacterComparator cc){
        int s = wd.size();
        if (s==0 || s==1){
            return true;
        }else{
            Character f = wd.removeFirst();
            Character l = wd.removeLast();
            return cc.equalChars(f,l) && isPalindromeHelper(wd,cc);
        }
    }

    public static boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> wd = wordToDeque(word);
        return isPalindromeHelper(wd,cc);
    }


    /**
    public static void main(String[] args){
        String w = "abc";
        System.out.println(w.length());
        System.out.println(Palindrome.isPalindrome(w));
        Deque<Character> wd = Palindrome.wordToDeque(w);
        wd.printDeque();

    }*/

    @Test
    public void testOffByOnePalindrome() {
        CharacterComparator obo = new OffByOne();

        String w1 = "abb";
        assertEquals(false,Palindrome.isPalindrome(w1));
        assertEquals(true,Palindrome.isPalindrome(w1,obo));

        String w2 = "aba";
        assertEquals(true, Palindrome.isPalindrome(w2));
        assertEquals(false, Palindrome.isPalindrome(w2,obo));
    }

    @Test
    public void testOffByNPalindrome() {
        CharacterComparator obn = new OffByN(2);

        String w1 = "abc";
        assertEquals(false,Palindrome.isPalindrome(w1));
        assertEquals(true,Palindrome.isPalindrome(w1,obn));

        String w2 = "aba";
        assertEquals(true, Palindrome.isPalindrome(w2));
        assertEquals(false, Palindrome.isPalindrome(w2,obn));
    }

    /**
     public static void main(String[] args){
         //CharacterComparator obo = new OffByOne();
         CharacterComparator obo = new OffByN(0);
         while(!StdIn.isEmpty()){
             String w = StdIn.readString();
             if (Palindrome.isPalindrome(w,obo) && w.length() >=4 ){
                 System.out.println(w);
                 }
             }
     }
     */
    

}
