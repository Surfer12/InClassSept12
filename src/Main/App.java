package Main;

import HelperMethods.NodeOfLinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        NodeOfLinkedList list = new NodeOfLinkedList(10); // Create a new linked list with initial node data 10
        list.insertAtBeginning(20); // Insert 20 at the beginning
        list.insertAtEnd(30); // Insert 30 at the end
        list.insertAtBeginning(40); // Insert 40 at the beginning

        System.out.println("Display using direct method:");
        list.displayCurrentLinkedListByNode(); // Display using the direct method

        System.out.println("Display using iterator:");
        list.displayUsingIterator(); // Display using the iterator
    }
}
