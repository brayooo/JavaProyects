package co.edu.uptc.model;

import co.edu.uptc.entity.Node;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class ListUptc<T> implements List<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private boolean isModifyIterator = false;

    public ListUptc(){
    }
    
    // TESTEADO
    @Override
    public int size() {
        Node<T> tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    // TESTEADO
    @Override
    public boolean isEmpty() {
        return size() > 0 ? false : true;
    }

    //TESTADO
    @Override
    public boolean contains(Object o) {
        Node<T> tmp = head;
        while (tmp != null) {
            if (tmp.getObj().equals(o))
                return true;
            tmp = tmp.getNext();
        }
        return false;
    }

    //TESTEADO
    @Override
    public Iterator<T> iterator() {
        isModifyIterator = false;
        Iterator<T> it = new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current == null ? false : current != null;
            }

            @Override
            public T next() {
                if (isModifyIterator) {
                    throw new ConcurrentModificationException();
                }
                Node<T>aux = current;
                current = current.getNext();
                return aux.getObj();
            }
        };
        return it;
    }

    @Override
    public void forEach(Consumer action) {
        List.super.forEach(action);
    }

    //TESTADO
    @Override
    public Object[] toArray() {
        Object[] aux = new Object[size()];
        Node<T> tmp = head;
        int i = 0;
        while (tmp != null) {
            aux[i] = tmp.getObj();
            tmp = tmp.getNext();
            i++;
        }
        return aux;
    }

    @Override
    public Object[] toArray(IntFunction generator) {
        return List.super.toArray(generator);
    }

//    @Override
//    public boolean add(Object o) {
//        Node node = new Node(o, null);
//        Node tmp = head;
//        if (head == null)
//            head = node;
//        else {
//            while (tmp.getNext() != null) {
//                tmp = tmp.getNext();
//            }
//            tmp.setNext(node);
//        }
//        isModifyIterator = true;
//        return true;
//    }


    @Override
    public boolean add(T o) {
        Node<T> node = new Node(o, null);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = tail.getNext();
        }
        isModifyIterator = true;
        return true;
    }

    // TESTEADO
    @Override
    public boolean remove(Object o) {
        Node<T> tmp = head;
        Node<T> aux = null;
        while (tmp != null) {
            if (tmp.getObj().equals(o)) {
                if (tmp == head) {
                    head = head.getNext();
                } else {
                    aux.setNext(aux.getNext().getNext());
                }
                isModifyIterator = true;
                return true;
            }
            aux = tmp;
            tmp = tmp.getNext();
        }
        return false;
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }


    // TESTADO
    @Override
    public void clear() {
        isModifyIterator = true;
        head = null;
    }

    @Override
    public T get(int index) {
        Node <T>tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return tmp.getObj();
    }
    @Override
    public T set(int index, T element) {
        Node<T> tmp = findPosition(index);
        T auxObj = tmp.getObj();
        tmp.setObj(element);
        return auxObj;
    }

    @Override
    public void add(int index, T element) {
        Node<T> node = new Node<>(element, null);
        if (index == 0) {
            node.setNext(head);
            head = node;
        } else {
            Node<T> tmp = findPosition(index - 1);
            node.setNext(tmp.getNext());
            tmp.setNext(node);
        }
        if (index > size() || index < size()) {
            throw new IndexOutOfBoundsException();
        }
        isModifyIterator = true;
    }

    @Override
    public T remove(int index) {
        Node <T>tmp = null;
        Node <T>aux = checkHead(index);
        if (aux == null) {
            tmp = findPosition(index);
            removeElement(findPosition(index - 1));
            aux = tmp;
        }
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        isModifyIterator = true;
        return aux.getObj();
    }

    private Node<T> checkHead(int index) {
        if (index == 0) {
            Node<T> aux = head;
            head = head.getNext();
            return aux;
        }
        return null;
    }

    private Node<T> findPosition(int index) {
        Node<T> tmp = head;
        Node<T> aux = null;
        int count = -1;
        while (tmp != null && count < index) {
            aux = tmp;
            count++;
            tmp = tmp.getNext();
        }
        if (index != count) {
            throw new IndexOutOfBoundsException();
        }
        return aux;
    }

    private void removeElement(Node<T> tmp) {
        if (tmp.getNext() != null)
            tmp.setNext(tmp.getNext().getNext());
        else
            tmp.setNext(null);
    }


    // TESTEADO
    @Override
    public int indexOf(Object o) {
        Node<T> tmp = head;
        int index = -1;
        int count = 0;
        while (tmp != null) {
            if (tmp.getObj().equals(o)) {
                return index = count;
            }
            count++;
            tmp = tmp.getNext();
        }
        return index;
    }

    // TESTEADO
    @Override
    public int lastIndexOf(Object o) {
        Node<T> tmp = head;
        int index = -1;
        int count = 0;
        while (tmp != null) {
            if (tmp.getObj().equals(o)) {
                index = count;
            }
            count++;
            tmp = tmp.getNext();
        }
        return index;
    }

    // TODO: 23/02/2023 ARREGLAR ADD 
    @Override
    public ListIterator<T> listIterator() {

        ListIterator<T> it = new ListIterator<>() {
            Node<T> current = head;
            Node <T>previous;
            Node <T>addAux = null;
            int nextIdx = 0;
            int prevIdx = 0;
            boolean isNext = false;
            boolean isHead = false;
            private void checkIndex() {
                if (nextIdx > 0)
                    nextIdx--;
            }
            @Override
            public boolean hasNext() {
                return current == null ? false : current != null;
            }

            @Override
            public T next() {
                Node<T> aux = null;
                if (head != null) {
                    aux = current;
                    previous = aux;
                    current = current.getNext();
                    nextIdx++;
                    isNext = true;
                }
                if (head == null) {
                    throw new NoSuchElementException();
                }
                return aux.getObj();
            }

            @Override
            public boolean hasPrevious() {
                return previous == null ? false : previous != null;
            }

            private Node<T> reAssignPrevious() {
                Node<T> tmp = head;
                Node<T> prevAux = null;
                while (tmp != previous) {
                    if (previous != null) {
                        prevAux = tmp;
                        tmp = tmp.getNext();
                    }
                }
                if (prevAux == null)
                    prevAux = head;
                return prevAux;
            }

            @Override
            public T previous() {
                Node<T> aux = null;
                if (previous != null && previous != head) {
                    aux = previous;
                    current = previous;
                }
                if(previous == head){
                    aux = current;
                }
                if (!isNext || previous==null) {
                    throw new NoSuchElementException();
                }
                checkIndex();
                return aux.getObj();
            }

            @Override
            public int nextIndex() {
                if (previous == null)
                    return nextIdx;
                else if (previous.getNext() != null) {
                    return nextIdx;
                } else
                    return size();
            }

            @Override
            public int previousIndex() {
                prevIdx = nextIdx - 1;
                if (previous != null)
                    return prevIdx;
                return -1;
            }

            @Override
            public void remove() {
                if (previous.getNext() != null && previous != head) {
                    previous.setNext(previous.getNext().getNext());
                    current.setNext(null);
                    current = previous.getNext();
                    previous = reAssignPrevious();
                } else if (previous == head && current == head) {//condicional que controla cuando se eliminam todos los elementos de la lista
                    head = null;
                    previous = null;
                    current =null;
                } else if (previous==head && previous.getNext() != null)  {//condicional que controla cuando elimino donde estaba parado
                    head = head.getNext();
                    previous = null;
                } else {
                    previous = reAssignPrevious();
                    previous.setNext(null);
                    current = previous;
                }
            }

            @Override
            public void set(T o) {
                if (previous != null) {
                    previous.setObj(o);
                } else if (current == head && current != null) {
                    current.setObj(o);
                } else
                    throw new IllegalStateException();
            }

            @Override
            public void add(T o) {
                Node newNode = new Node(o, null);
                if (!isNext) {
                    if (!isHead) {
                        newNode.setNext(head);
                        head = newNode;
                        addAux = head;
                        isHead = true;
                    } else {
                        newNode.setNext(addAux.getNext());
                        addAux.setNext(newNode);
                        addAux = addAux.getNext();
                    }
                } else if (previous.getNext() != null) {
                    newNode.setNext(current);
                    previous.setNext(newNode);
                    previous = newNode;
                } else {
                    previous.setNext(newNode);
                    previous = newNode;
                }
                nextIdx++;
            }
        };
        return it;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<T> it = new ListIterator<>() {
            Node <T>tmp = head;
            Node <T>current = searchIndex();
            Node <T>previous;
            int nextIdx = index;
            int prevIdx = 0;

            private void checkIndex() {
                if (nextIdx > 0)
                    nextIdx--;
            }

            @Override
            public boolean hasNext() {
                return current == null ? false : current != null;
            }

            private Node<T> searchIndex() {
                Node <T>currentAux;
                int count = 0;
                while (tmp != null && count != index) {
                    previous = tmp;
                    tmp = tmp.getNext();
                    count++;
                }
                if (count != index) {
                    throw new IndexOutOfBoundsException();
                }
                currentAux = tmp;
                return currentAux;
            }

            @Override
            public T next() {
                Node<T> aux;
                if (current != null) {
                    aux = current;
                    previous = aux;
                    current = current.getNext();
                } else {
                    throw new NoSuchElementException();
                }
                nextIdx++;
                return aux.getObj();
            }

            @Override
            public boolean hasPrevious() {
                return previous == null ? false : previous != null;
            }

            private Node<T> reAssignPrevious() {
                Node<T> tmp = head;
                Node<T>prevAux = null;
                while (tmp != previous) {
                    if (previous != null) {
                        prevAux = tmp;
                        tmp = tmp.getNext();
                    }
                }
                if (prevAux == null)
                    prevAux = head;
                return prevAux;
            }

            @Override
            public T previous() {
                Node<T> aux = null;
                if (previous != null && current != null) {
                    aux = current;
                    current = previous;
                }
                if (current == null) {
                    aux = previous;
                    current = previous;
                }
                if (previous == null) {
                    throw new NoSuchElementException();
                }
                previous = reAssignPrevious();
                checkIndex();
                return aux.getObj();
            }

            @Override
            public int nextIndex() {
                return nextIdx;
            }

            @Override
            public int previousIndex() {
                if (nextIdx == 0)
                    return -1;
                return prevIdx = nextIdx - 1;
            }

            @Override
            public void remove() {
                if (current.getNext() != null) {
                    current.setNext(null);
                } else if (previous == head) {
                    previous = null;
                    current = null;
                } else {
                    previous.setNext(null);
                    current = previous;
                    previous = reAssignPrevious();
                }
                nextIdx--;
            }

            @Override
            public void set(T o) {
                current.setObj(o);
            }

            @Override
            public void add(T o) {
                Node<T> newNode = new Node<>(o, null);
                if (previous != null) {
                    newNode.setNext(current);
                    previous.setNext(newNode);
                } else if (current == head) {
                    newNode.setNext(current);
                    head = newNode;
                } else if (current == null && previous == null) {
                    head = newNode;
                }
                previous = newNode;
                nextIdx++;
            }
        };
        return it;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T>list = new ListUptc<>();
        Node<T> tmp = head;
        int count = 0;
        while(tmp!=null){
            if(count >= fromIndex && count < toIndex){
                list.add(tmp.getObj());
            }
            tmp = tmp.getNext();
            count++;
        }
        if(fromIndex < 0 || toIndex > size()){
            throw new IndexOutOfBoundsException();
        }
        if(fromIndex > toIndex){
            throw new IllegalArgumentException();
        }
        return list;
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
    public boolean retainAll(Collection<?> c) {
        boolean flag = false;
        List<T> listAux = new ListUptc<>();
        for (Object obj : c) {
            if (findNode((T) obj) != null) {
                flag = true;
                listAux.add((T) obj);
            }
        }
        clear();
        addAll(listAux);
        return flag;
    }

    private Node<T> findNode(T object) {
        Node <T>tmp = head;
        while (tmp != null && tmp.getObj() != object) {
            tmp = tmp.getNext();
        }
        return tmp == null ? null : tmp.getObj() == object ? tmp : null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean flag = true;
        for (Object co : c) {
            flag = remove(co);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean flag = false;
        for (Object obj: c) {
            if(add((T) obj)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean flag = false;
        for (Object obj: c) {
            if(contains(obj)){
                flag = true;
            }else {
                return flag = false;
            }
        }
        return flag;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        Object[]array;
        if (a.length > size()) {
            int size = (a.length + size()) - size();
            array = new Object[size];
        } else {
            array = new Object[size()];
        }
        array = assignListValues(array, a);
        return (T1[]) array;
    }

    private Object[] assignListValues(Object[] listArray, Object[] aux) {
        Node <T>tmp = head;
        Node<T> auxNode = null;
        int i = 0;
        while (tmp != null) {
            auxNode = tmp;
            listArray[i] = tmp.getObj();
            tmp = tmp.getNext();
            i++;
        }
        if (auxNode.getNext() == null && aux.length >= listArray.length) {
            listArray[i] = null;
            i++;
        }
        for (int j = i; j < aux.length; j++) {
            listArray[j] = aux[j];
        }
        return listArray;
    }

}
