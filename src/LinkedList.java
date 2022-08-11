public class LinkedList <T> {
    LinkNode<T> head;

    private int length = 0;//to store length of list
    LinkedList() {this.head = null; } //default constructor
    //method to add node at the end of list
    void add(T data)
    {
        //create new node with given value
        LinkNode<T> temp = new LinkNode<>(data);
        //check if list is empty and assign new value to head node
        if (this.head == null) {
            head = temp;
            //if there is already a list
        } else {
            //temp node for traversal
            LinkNode<T> X = head;
            //iterating to the end
        while (X.next != null) {
            X = X.next;
        }
        //add new value node at the end of the list
            X.next = temp;
        }
        length++; //increase length after insertion
    }
    //method to add new node at any given position
    void add(int position, T data) {
        //check if position is valid
        if (position > length + 1) {
            System.out.println("Position Unavailable in LinkedList");
            return;
        }
        //if new position is head then replace head node
        if (position == 1) {
            //temporary node that stores previous head value
            LinkNode<T> temp = head;

            //assign new node value to the head node
            head = new LinkNode<T>(data);
            //new head node pointing to old head node
            head.next = temp;

            return;
        }
        //temp node
        LinkNode<T> temp = head;
        //dummy node with null value that stores previous node
        LinkNode<T> prev = new LinkNode<T>(null);
        //iterating to the given position
        while (position - 1 > 0) {
            //assign previous node
            prev = temp;
            //incrementing next node
            temp = temp.next;
            //decreasing position counter
            position--;
        }
        //previous node now points to new value
        prev.next = new LinkNode<T>(data);
        //new value points to former current node
        prev.next.next = temp;
    }
    //method to remove a node from list
    void remove(T key)
    // in a Singly Linked-List we
    // cannot go backwards from a node, we use a dummy
    // node to represent the previous node. In case of
    // head node, since there is no previous node, the
    // previous node is assigned to null.
    {
        //dummy null node
        LinkNode<T> prev = new LinkNode<>(null);
        //dummy node pointing to head node
        prev.next = head;
        //next node points ahead of current node
        LinkNode<T> next = head.next;
        //temporary node
        LinkNode<T> temp = head;
        //bool to check if the value to be deleted exists or not
        boolean exists = false;
        //if head node needs to be deleted
        if (head.data == key) {
            head = head.next;
            exists = true;
        }
        while (temp.next != null) {
            // We convert value to be compared into Strings
            // and then compare using
            // String1.equals(String2) method

            // Comparing value of key and current node
            if (String.valueOf(temp.data).equals(
                    String.valueOf(key))) {

                // If node to be deleted is found previous
                // node now points to next node skipping the
                // current node
                prev.next = next;
                // node to be deleted exists
                exists = true;
                // As soon as we find the node to be deleted
                // we exit the loop
                break;
            }
            //previous node now points to current node
            prev = temp;
            //current node now points to next node
            temp = temp.next;
            //next node points to the node ahead of current node
            next = temp.next;
        }
        //comparing the last node with the given key value
        if(exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {
            //if found, last node is skipped over
            prev.next = null;

            exists = true;
        }
        //if node to be deleted exists
        if(exists) {
            //length of linkedlist reduced
            length--;
        }
        //if node to be deleted does not exist
        else {
            System.out.println("Given value is not present in linked list");
        }
    }
    //method to clear the entire linkedlist
    void clear()
    {
        //head points to null
        head = null;
        //length is 0 again
        length = 0;
    }
    //method returns if a list is empty or not
    boolean empty()
    {
        //check if head node points to null
        if(head == null) {
            return true;
        }
        return false;
    }
    //method returns the length
    int length() {return this.length; }
    //method to display list
    public String toString()
    {
        String S = "{ ";
                LinkNode<T> X = head;
        if (X == null)
            return S + " }";
        while (X.next != null) {
            S += String.valueOf(X.data) + " -> ";
            X = X.next;
        }
        S += String.valueOf(X.data);
        return S + " }";
    }
}
