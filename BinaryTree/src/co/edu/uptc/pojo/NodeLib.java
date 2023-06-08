package co.edu.uptc.pojo;

public class NodeLib<T> {

    private T info;
    private NodeLib<T> less;
    private NodeLib<T> mayorAndEqual;

    public NodeLib(T info, NodeLib<T> less, NodeLib<T> mayorAndEqual) {
        this.info = info;
        this.less = less;
        this.mayorAndEqual = mayorAndEqual;
    }

    public NodeLib() {
    }

    public NodeLib(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NodeLib<T> getLess() {
        return less;
    }

    public NodeLib<T> getMayorAndEqual() {
        return mayorAndEqual;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setLess(NodeLib<T> less) {
        this.less = less;
    }

    public void setMayorAndEqual(NodeLib<T> mayorAndEqual) {
        this.mayorAndEqual = mayorAndEqual;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
