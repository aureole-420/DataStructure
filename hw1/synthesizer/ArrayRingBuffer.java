// TODO: Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer;
import synthesizer.AbstractBoundedQueue;

import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    public Iterator<T> iterator(){
        return new keyIterator();
    }

    private class keyIterator implements Iterator<T>{
        private int wizardPosition;

        public keyIterator(){
            wizardPosition = 0;
        }

        private int helperActualPosition(){
            return (wizardPosition+first)%capacity;
        }

        public boolean hasNext(){
            if (wizardPosition>=0 && wizardPosition < capacity){
                return true;
            } else{
                return false;
            }
        }

        public T next(){
            T returnVal = rb[helperActualPosition()];
            wizardPosition += 1;
            return returnVal;
        }
    }

    protected int plusOne(int n){
        if (n == capacity-1){
            return 0;
        }else {
            return n+1;
        }
    }

    protected int minusOne(int n){
        if (n==0){
            return capacity-1;
        }else{
            return n-1;
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()){
            throw new RuntimeException("Ring Buffer Overflow!");
        }
        rb[last] = x;
        fillCount +=1;
        last = plusOne(last);
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()){
            throw new RuntimeException("Ring Buffer Underflow.");
        }
        T oldestItem = rb[first];
        rb[first] = null;
        first = plusOne(first);
        fillCount -=1;
        return oldestItem;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    public static void main(String[] args){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        int a = arb.dequeue();
        System.out.println(a);
    }
}
