package Main;

import HelperMethods.NodeOfLinkedList;
import java.util.Optional;
import java.util.function.Supplier;

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

        System.out.println("Insert at position 2:");
        list.insertAtPosition(2, list.head.get(), 50); // Insert 50 at position 2
        list.displayCurrentLinkedListByNode(); // Display the updated list

        System.out.println("Delete by value 30:");
        list.deleteByValue(30); // Delete the node with value 30
        list.displayCurrentLinkedListByNode(); // Display the updated list

        System.out.println("Insert with while after 40:");
        list.insetWithWhile(60, 40); // Insert 60 after the node with value 40
        list.displayCurrentLinkedListByNode(); // Display the updated list

        System.out.println("Is the list empty? " + list.isEmpty()); // Check if the list is empty

        System.out.println("Delete from beginning:");
        list.deleteFromBeginning(list.head); // Delete the first node
        list.displayCurrentLinkedListByNode(); // Display the updated list

        System.out.println("Delete from end:");
        list.deleteFromEnd(list.head); // Delete the last node
        list.displayCurrentLinkedListByNode(); // Display the updated list

        // Example of using a Supplier
        Supplier<NodeOfLinkedList> listSupplier = () -> new NodeOfLinkedList(100);
        NodeOfLinkedList newList = listSupplier.get(); // Create a new list using the supplier
        newList.insertAtBeginning(200);
        newList.displayCurrentLinkedListByNode();

        // Example of a Singleton (not applicable in this case)
        // Singletons are typically used for classes that should have only one instance.
        // Since NodeOfLinkedList is not designed to be a singleton, this example is not relevant.
    }
}
