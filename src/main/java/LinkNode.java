public class LinkNode<T> {
    T data; //value of the node
    LinkNode<T> next; //address of the next node

    //parametrized constructor
    LinkNode(T data) {
        this.data = data;
        this.next = null;
    }
}
