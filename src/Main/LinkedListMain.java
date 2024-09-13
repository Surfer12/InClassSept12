package Main;

import HelperMethods.NodeOfLinkedList;
import java.util.Optional;

public class LinkedListMain {
	public static void main(String[] args) {
		// Create a new linked list
		NodeOfLinkedList linkedList = new NodeOfLinkedList(10);
		
		// Insert elements at the beginning
		linkedList.insertAtBeginning(20);
		linkedList.insertAtBeginning(30);
		
		// Insert elements at the end
		linkedList.insertAtEnd(40);
		linkedList.insertAtEnd(50);
		
		// Display the current linked list
		System.out.println("Linked List after insertions:");
		linkedList.displayCurrentLinkedListByNode();
		
		// Delete from the beginning
		linkedList.deleteFromBeginning(linkedList.getHead());
		System.out.println("Linked List after deleting from the beginning:");
		linkedList.displayCurrentLinkedListByNode();
		
		// Delete from the end
		linkedList.deleteFromEnd(linkedList.getHead());
		System.out.println("Linked List after deleting from the end:");
		linkedList.displayCurrentLinkedListByNode();
		
		// Insert at a specific position
		linkedList.insertAtPosition(1, linkedList.getHead().get(), 25);
		System.out.println("Linked List after inserting 25 at position 1:");
		linkedList.displayCurrentLinkedListByNode();
		
		// Delete by value
		linkedList.deleteByValue(40);
		System.out.println("Linked List after deleting value 40:");
		linkedList.displayCurrentLinkedListByNode();
		
		// Display using iterator
		System.out.println("Linked List using iterator:");
		linkedList.displayUsingIterator();
	}
}
