package csu.csci325;

/**
 * Created by Kaitlyn on 12/1/2016.
 */
public class SinglyLinkedListNode<T> {
    private T mData;
    private SinglyLinkedListNode<T> mNext;

    public SinglyLinkedListNode(T data) {
        mData = data;
    }

    public T getData() {
        return mData;
    }
    public void setNext(SinglyLinkedListNode<T> next) {
        mNext = next;
    }
    public SinglyLinkedListNode<T> getNext() {
        return mNext;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode<Integer> start = new SinglyLinkedListNode<Integer>(10);
        SinglyLinkedListNode<Integer> next = new SinglyLinkedListNode<Integer>(15);
        start.setNext(next);
    }
}
