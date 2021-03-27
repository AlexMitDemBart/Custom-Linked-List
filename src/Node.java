public class Node<T> {

    private final T data;
    private Node<T> nextNode;
    private Node<T> prevNode;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    public T getData() {
        return data;
    }
}
