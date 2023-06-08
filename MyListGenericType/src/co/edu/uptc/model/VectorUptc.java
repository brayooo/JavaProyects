package co.edu.uptc.model;

import co.edu.uptc.entity.Vector;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class VectorUptc implements List {

    Vector vec = new Vector();

    @Override
    public int size() {
        return vec.getMyVector().length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {
        List.super.forEach(action);
    }

    // TODO: 14/02/2023 test in the unitTest class
    @Override
    public Object[] toArray() {
        return vec.getMyVector();
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return List.super.toArray(generator);
    }

    @Override
    public boolean add(Object o) {
        Object[] tmp = new Object[vec.getMyVector().length+1];
        for (int i = 0; i < vec.getMyVector().length; i++) {
            tmp[i]=vec.getMyVector()[i];
        }
        for (int i = tmp.length-1; i < tmp.length; i++) {
            tmp[i]=o;
        }
        vec.setMyVector(tmp);
        return false;
    }

    @Override
    public void add(int index, Object element) {
        Object[] tmp = new Object[vec.getMyVector().length+1];
        for (int i = 0; i < index-1; i++) {
            tmp[i]=vec.getMyVector()[i];
        }
        for (int i = index; i < vec.getMyVector().length ; i++) {
            tmp[i+1] = vec.getMyVector()[i];
        }
        tmp[index]=element;
        vec.setMyVector(tmp);
    }

    @Override
    public boolean remove(Object o) {

        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        Object content = null;
        for (int i = 0; i < vec.getMyVector().length; i++) {
            if(index == i)
                content = vec.getMyVector()[i];
        }
        return content;
        //return vec.getMyVector()[index];
    }

    @Override
    public Object set(int index, Object element) {
        Object aux = vec.getMyVector()[index];
        vec.getMyVector()[index] = element;
        return aux;
    }

    @Override
    public Object remove(int index) {
        Object[] aux = vec.getMyVector();
        Object[] tmp = new Object[vec.getMyVector().length-1];
        int count = 0;
        for (int i = 0; i < vec.getMyVector().length; i++) {
            if(i != index){
                tmp[count] = vec.getMyVector()[i];
                count++;
            }
        }
        vec.setMyVector(tmp);
        return aux[index];
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream stream() {
        return List.super.stream();
    }

    @Override
    public Stream parallelStream() {
        return List.super.parallelStream();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
