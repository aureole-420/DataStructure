/** If you project is set up properly, this file should execute. 
* One thing you might consider is to try printing out the sequence of
* operations */
public class StudentArrayDequeLauncher {
    public static void main(String[] args) {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        OperationSequence o_s = new OperationSequence();

        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                DequeOperation d_o = new DequeOperation("addLast",i);
                o_s.addOperation(d_o);
            } else {
                sad1.addFirst(i);
                DequeOperation d_o = new DequeOperation("addFirst",i);
                o_s.addOperation(d_o);
            }
        }

        sad1.printDeque();
        System.out.println(o_s.toString());
        /* Helpful challenge: Modify this file so that it outputs the list of
           operations as a String. Use the OperationSequence class. */
    }
} 
