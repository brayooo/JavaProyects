package co.edu.uptc.entity;

public class Node <T>{

    private T obj;
    private Node<T> next;

    public Node() {
    }

    public Node(T obj, Node<T> next) {
        this.obj = obj;
        this.next = next;
    }

    public T getObj() {
        return obj;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
