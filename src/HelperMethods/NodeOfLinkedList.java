package HelperMethods;

import java.util.Iterator;
import java.util.Optional;
import java.util.LinkedList;

/**
 * Represents a node in a singly linked list that can be iterated over.
 * Each node contains an integer value and a reference to the next node in the list.
 */
public class NodeOfLinkedList implements Iterable<Optional<Integer>> {

    /**
     * Constructor to create a new node with specified data.
     * 
     * @param data The data to be stored in the node.
     */
    public NodeOfLinkedList(int data) {
        this.data = Optional.of(data); // Data is stored in an Optional to handle null values
        this.next = Optional.empty(); // Next is initialized as empty
    }

    public Optional<NodeOfLinkedList> head; // Head of the linked list
    public Optional<Integer> data; // Data of the node
    public Optional<NodeOfLinkedList> next; // Next node in the linked list

    /**
     * Inserts a new node at the beginning of the linked list.
     * 
     * @param data The data for the new node.
     */
    public void insertAtBeginning(int data) {
        NodeOfLinkedList newNode = new NodeOfLinkedList(data); // Create a new node
        newNode.next = head; // New node points to the current head
        head = Optional.of(newNode); // New node becomes the new head
    }

    /**
     * Inserts a new node at the end of the linked list.
     * 
     * @param data The data for the new node.
     */
    public void insertAtEnd(int data) {
        NodeOfLinkedList newNode = new NodeOfLinkedList(data); // Create a new node
        if (!head.isPresent()) {
            head = Optional.of(newNode); // If the list is empty, the new node becomes the head
        } else {
            NodeOfLinkedList current = head.get(); // Start from the head
            while (current.next.isPresent()) { // Traverse to the end of the list
                current = current.next.get();
            }
            current.next = Optional.of(newNode); // Link the new node at the end of the list
        }
    }

    /**
     * Displays the current linked list starting from the head node.
     */
    public void displayCurrentLinkedListByNode() {
        Optional<NodeOfLinkedList> current = head; // Start from the head
        while (current.isPresent()) {
            System.out.print(current.get().data.get() + " -> "); // Print current node's data
            current = current.get().next; // Move to the next node
        }
        System.out.println("null"); // Indicate the end of the list
    }

    /**
     * Provides an iterator over the elements in this linked list.
     * 
     * @return an Iterator that can be used to iterate through the linked list
     *         elements.
     */
    @Override
    public Iterator<Optional<Integer>> iterator() {
        return new Iterator<Optional<Integer>>() {
            private Optional<NodeOfLinkedList> current = head; // Points to the head of the list initially

            /**
             * Determines if there are more elements in the list to iterate over.
             * 
             * @return true if there is at least one more element, false otherwise.
             */
            @Override
            public boolean hasNext() {
                return current.isPresent();
            }

            /**
             * Returns the next element in the iteration and advances the iterator.
             * 
             * @return the integer data of the current node.
             */
            @Override
            public Optional<Integer> next() {
                Optional<Integer> data = current.get().data; // Retrieve data from the current node
                current = current.get().next; // Move to the next node
                return data;
            }
        };
    }

    /**
     * Displays the elements of the linked list using the iterator.
     */
    public void displayUsingIterator() {
        Iterator<Optional<Integer>> it = iterator(); // Get the iterator
        while (it.hasNext()) {
            Optional<Integer> element = it.next();
            element.ifPresent(e -> System.out.print(e + " -> ")); // Print each element followed by '->'
        }
        System.out.println("null"); // Indicate the end of the list
    }

    public void insertAtPosition(int position, NodeOfLinkedList head, int data) {
        if (position < 0) {
            throw new IllegalArgumentException("Position cannot be negative");
        }
        NodeOfLinkedList newNode = new NodeOfLinkedList(data); // Create a new node from the data
        if (position == 0) { // If the position is 0, insert at the beginning
            newNode.next = Optional.of(head); // New node points to the current head
            head = newNode; // New node becomes the new head
        } else {
            NodeOfLinkedList current = head; // Start from the head
            for (int i = 0; i < position - 1 && current.next.isPresent(); i++) { // Traverse to the position
                current = current.next.get();
            }
            newNode.next = current.next; // New node points to the current node's next
            current.next = Optional.of(newNode); // Current node's next points to the new node
        }
    }

    public void deleteByValue(int data) {
        if (!head.isPresent()) {
            return; // If the list is empty, do nothing
        }
        if (head.get().data.get() == data) { // If the head node contains the data
            head = head.get().next; // Move the head to the next node
        } else {
            NodeOfLinkedList current = head.get(); // Start from the head
            while (current.next.isPresent() && current.next.get().data.get() != data) { // Traverse to the node containing the data
                current = current.next.get();
            }
            if (current.next.isPresent()) { // If the node containing the data is found
                current.next = current.next.get().next; // Remove the node by skipping it
            }
        }
    }

    public void insetWithWhile(int data, int dataToInsertAfter) {
        NodeOfLinkedList newNode = new NodeOfLinkedList(data);
        NodeOfLinkedList current = head.get();

        while (current.data.get() != dataToInsertAfter) {
            current = current.next.get();
        }
        newNode.next = current.next;
        current.next = Optional.of(newNode);
    }

    public boolean isEmpty() {
        return head.isEmpty();
    }
    
    public void deleteFromBeginning(Optional<NodeOfLinkedList> head) {
        if(head.isEmpty()) {
            return; // If the beginning is not present, do nothing
        }
        this.head = head.get().next; // Update this line to handle Optional correctly
    }
    // How can we delete from the end?
    public void deleteFromEnd(Optional<NodeOfLinkedList> head) {
        if(head.isEmpty()) {
            return; // If the list is empty, do nothing
        }
        if(head.get().next.isEmpty()) {
            this.head = Optional.empty(); // If the list has only one node, delete the head
        } else {
            NodeOfLinkedList current = head.get(); // Start from the head
            while(current.next.get().next.isPresent()) { // Traverse to the second last node
                current = current.next.get();
            }
            current.next = Optional.empty(); // Remove the last node by making the second last node point to null
        }
    }
}