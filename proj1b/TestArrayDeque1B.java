import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {

    @Test
    public void testQuarter() {
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();

        OperationSequence fs = new OperationSequence();
        DequeOperation op;
        int count = 10;
        while (count >= 0) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne<0.5){
                student.addFirst(count);
                solution.addFirst(count);
                op = new DequeOperation("addFirst", count);
                fs.addOperation(op);
            }else{
                student.addLast(count);
                solution.addLast(count);
                op = new DequeOperation("addLast", count);
                fs.addOperation(op);
            }
            count--;
        }
        Integer a, b;
        for (int i = 0; i < 9; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if(numberBetweenZeroAndOne<0.5){
                a = student.removeLast();
                b = solution.removeLast();
                op = new DequeOperation("removeLast");
                fs.addOperation(op);
                assertEquals(fs.toString(), b, a);
            }else{
                a = student.removeFirst();
                b = solution.removeFirst();
                op = new DequeOperation("removeFirst");
                fs.addOperation(op);
                assertEquals(fs.toString(), b, a);
            }

        }
    }
}