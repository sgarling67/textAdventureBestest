package csu.csci325;

/**
 * Created by Kaitlyn on 12/1/2016.
 */
public class LinkedList<T> implements List<T> {
    private SinglyLinkedListNode<T> mFront, mBack;
    private int mSize;

    public LinkedList() {
        mFront = mBack = null;
        mSize = 0;
    }

    @Override
    public void add(int idx, T object) {
        // We consider three cases:
        // 1) Adding to the front
        if (idx == 0) {
            addFront(object);
            return;
        }
        // 2) adding to the back
        if (idx == mSize) {
            addBack(object);
            return;
        }
        // 3) adding in the middle
        // 3a) Go to idx
        SinglyLinkedListNode<T> rover = mFront;
        for (int i = 1; i < idx; i++) {
            rover = rover.getNext();
        }
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(object);
        // 3b) Insert at that idx
        node.setNext(rover.getNext());
        rover.setNext(node);
        mSize++;
    }

    @Override
    public void addFront(T object) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(object);
        node.setNext(mFront);
        mFront = node;
        mSize++;
        if (mBack == null) {
            mBack = mFront;
        }
    }

    @Override
    public void addBack(T object) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(object);
        if (mBack != null) {
            mBack.setNext(node);
        }
        mBack = node;
        mSize++;
        if (mFront == null) {
            mFront = mBack;
        }
    }

    @Override
    public void remove(T object) {
        int idx = contains(object);
        remove(idx);
    }

    @Override
    public void remove(int idx) {
        SinglyLinkedListNode<T> prev = mFront;

        // Cases if idx is 0.
        if (idx == 0) {
            if (mFront == mBack) {
                mFront = mBack = null;
                return;
            }
            mFront = mFront.getNext();
            return;
        }


        // Find the previous node.
        for (int i = 0; i < idx - 1; i++) {
            prev = prev.getNext();
        }

        // Check if we are removing the last element.
        if (mBack == prev.getNext()) {
            mBack = prev;
            mBack.setNext(null);
            return;
        }

        // We need to link around.
        prev.setNext(prev.getNext().getNext());
    }

    @Override
    public T get(int idx) {
        SinglyLinkedListNode<T> rover = mFront;
        for (int i = 0; i < idx; i++) {
            rover = rover.getNext();
        }
        return rover.getData();
    }

    @Override
    public boolean isEmpty() {
        return (mFront == mBack && mFront == null);
    }

    @Override
    public int size() {
        return mSize;
        
    }

    @Override
    public int contains(T object) {
        int index = 0;// Stores the location of the object;
        for (SinglyLinkedListNode<T> rover = mFront; rover != null; rover = rover.getNext()) {
            if (rover.getData().equals(object)) {
                return index;
            }
            index++;
        }
        return 0;
    }
    public static void main(String args[]) {
        List<String> ia = new LinkedList<>();
        System.out.println(ia.isEmpty());
        ia.add(0, "John");
        ia.add(1, "Paul");
        ia.add(2, "Mark");
        ia.add(3, "George");
        System.out.println(ia.get(1));
        ia.remove("Paul");
        System.out.println(ia.get(1));
        ia.remove(0);
        System.out.println(ia.get(1));
        System.out.println(ia.isEmpty());
        System.out.println(ia.size());
    }
}
