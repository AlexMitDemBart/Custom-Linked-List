import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {}

    private Node<T> getLastNode(){
        if(head.getNextNode() == null){
            return head;
        }else{
            Node<T> node = head.getNextNode();
            while(node.getNextNode() != null){
                node = node.getNextNode();
            }
            return node;
        }
    }

    public T getFirst(){
        return head.getData();
    }

    public T getLast(){
        return tail.getData();
    }

    public void add(T element){
        addLast(element);
    }

    public void addFirst(T element){
        if(head == null){
            head = new Node<T>(element);
            tail = new Node<T>(element);
        }else{
            Node<T> newHead = new Node<T>(element);
            newHead.setNextNode(head);
            head.setPrevNode(newHead);
            head = newHead;
        }
    }

    public void addLast(T element){
        if(head == null){
            Node<T> newNode = new Node<T>(element);
            head = newNode;
            tail = newNode;
        }else{
            Node<T> newTail = new Node<T>(element);
            tail.setNextNode(newTail);
            newTail.setPrevNode(tail);
            tail = newTail;
        }
    }

    public int size(){
        int size = 1;

        if(head == null){
            return 0;
        }else{
            Node<T> node = head.getNextNode();
            while(node.getNextNode() != null){
                size++;
                node = node.getNextNode();
            }
            return size +1;
        }
    }

    public void remove(T element){
        if(head != null){
            if(!element.equals(head.getData()) && !element.equals(tail.getData())){
                Node<T> node = head.getNextNode();
                while(node.getNextNode() != null){
                    if(node.getData().equals(element)){
                        Node<T> nextNode = node.getNextNode();
                        Node<T> prevNode = node.getPrevNode();
                        prevNode.setNextNode(nextNode);
                        nextNode.setPrevNode(prevNode);
                    }
                    node = node.getNextNode();
                }
            }else{
                if(element.equals(head.getData())){
                    Node<T> nextNode = head.getNextNode();
                    nextNode.setPrevNode(null);
                    head = nextNode;
                }else{
                    Node<T> prevNode = tail.getPrevNode();
                    prevNode.setPrevNode(null);
                    tail = prevNode;
                }
            }
        }else{
            throw new NoSuchElementException("Element does not exist");
        }
    }

    public boolean contains(T element){
        if(head != null) {
            Node<T> node = head.getNextNode();
            while (node.getNextNode() != null) {
                if (node.getData().equals(element)) {
                    return true;
                }
                node = node.getNextNode();
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator(head);
    }

    private class CustomIterator implements Iterator<T>{

        private Node<T> current;
        private boolean cursorIsOnHead = true;

        public CustomIterator(Node<T> head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
           return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNextNode();
            return data;
        }
    }
}
