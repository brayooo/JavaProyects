package co.edu.uptc.model;


import co.edu.uptc.pojo.NodeLib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree202022012<T> {

    NodeLib<T> header;
    public NodeLib<T> previous;
    private Comparator<T> comparator;


    public BinaryTree202022012(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public void add(T info) {
        NodeLib<T> aux = new NodeLib<T>(info);
        if (header == null) {
            header = aux;
        } else {
            NodeLib<T> tmp = search(aux);
            if(comparator.compare(info, tmp.getInfo() ) >= 0 ){
                tmp.setMayorAndEqual(aux);
            }
            else {
                tmp.setLess(aux);
            }

        }
    }
    private NodeLib<T> search(NodeLib<T> nodeLib) {
        NodeLib<T> aux = header;
        boolean isFound = false;
        while (!isFound) {
            if (comparator.compare(nodeLib.getInfo(),aux.getInfo()) < 0) {
                if (aux.getLess() != null) {
                    aux = aux.getLess();
                } else {
                    isFound = true;
                }
            } else {
                if (aux.getMayorAndEqual() != null) {
                    aux = aux.getMayorAndEqual();
                } else {
                    isFound = true;
                }
            }
        }
        return aux;
    }

    public NodeLib<T> search(T info) {
        NodeLib<T> aux = header;
        NodeLib<T> found = null;
        boolean isFound = false;
        while (!isFound) {
            if (comparator.compare(info,aux.getInfo()) < 0) {
                if (info == aux.getInfo()) {
                    found = aux;
                    isFound = true;
                } else {
                    previous = aux;
                    aux = aux.getLess();
                }
            } else {
                if (info == aux.getInfo()) {
                    found = aux;
                    isFound = true;
                } else {
                    previous = aux;
                    aux = aux.getMayorAndEqual();
                }
            }
        }
        return found;
    }

    public void delete(T info) {
        NodeLib<T> delete = search(info);
        NodeLib<T> aux = header;
        if (aux == delete) {
            if(delete.getLess() != null && delete.getMayorAndEqual() != null){
                header = delete.getLess();
                header.setMayorAndEqual(delete.getMayorAndEqual());
            }else {
                if(delete.getLess() != null){
                    header = delete.getLess();
                }else {
                    header = delete.getMayorAndEqual();
                }
            }
        } else {
            if (delete.getLess() != null && delete.getMayorAndEqual() != null) {
                if (previous.getMayorAndEqual() != null) {
                    previous.setMayorAndEqual(null);
                    if (comparator.compare(delete.getLess().getInfo(), previous.getInfo()) > 0) {
                        add(delete.getMayorAndEqual());
                        delete.setMayorAndEqual(null);
                    }else {
                        add(delete.getLess());
                        delete.setLess(null);
                    }if(comparator.compare(delete.getLess().getInfo(), previous.getInfo()) > 0){
                        add(delete.getLess());
                        delete.setLess(null);
                    }
                }
            } else {
                if (delete.getLess() == null && delete.getMayorAndEqual() == null) {
                    if (previous.getLess() != null && previous.getLess() == delete) {
                        previous.setLess(null);
                    } else {
                        previous.setMayorAndEqual(null);
                    }
                } else {
                    if (delete.getLess() != null) {
                        previous.setLess(null);
                        previous.setLess(delete.getLess());
                        delete.setLess(null);
                    } else {
                        previous.setMayorAndEqual(null);
                        previous.setMayorAndEqual(delete.getMayorAndEqual());
                        delete.setMayorAndEqual(null);
                    }
                }
            }
        }
    }

    public void add(NodeLib<T> nodeLib) {
        if (header == null) {
            header = nodeLib;
        } else {
            NodeLib<T> tmp = search(nodeLib);
            if (comparator.compare(nodeLib.getInfo(), tmp.getInfo())>= 1) {
                tmp.setMayorAndEqual(nodeLib);
            } else {
                tmp.setLess(nodeLib);
            }

        }
    }

    public void showTree() {
        showTreePreOrder(header);
    }

    public void showTreePreOrder(NodeLib<T> nodeLib) {
        if (nodeLib.getLess() != null) {
            showTreePreOrder(nodeLib.getLess());
        }
        System.out.println(nodeLib.getInfo());
        if (nodeLib.getMayorAndEqual() != null) {
            showTreePreOrder(nodeLib.getMayorAndEqual());
        }
    }

    public void getData(NodeLib<T> nodeLib, List<T> list) {
        if (nodeLib.getLess() != null) {
            getData(nodeLib.getLess(),list);
        }
        list.add(nodeLib.getInfo());
        if (nodeLib.getMayorAndEqual() != null) {
            getData(nodeLib.getMayorAndEqual(),list);
        }
    }

    public void initData(List<T> list){
        getData(header,list);
    }

    public List<T> getList() {
        List<T> list = new ArrayList<>();
        initData(list);
        return list;
    }

    public NodeLib<T> getHeader() {
        return header;
    }

}
