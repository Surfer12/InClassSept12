Additional Linked List Real Life Example

Here are some real-life examples of different types of linked lists implemented in Java, demonstrating their usage in various scenarios:

### 1. Singly Linked List - Playlist Management

A singly linked list can be used to manage a music playlist where each song points to the next song.

```java
public class Playlist {
    private static class Song {
        String title;
        Song next;

        Song(String title) {
            this.title = title;
            this.next = null;
        }
    }

    private Song head;

    public void addSong(String title) {
        Song newSong = new Song(title);
        if (head == null) {
            head = newSong;
        } else {
            Song current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newSong;
        }
    }

    public void play() {
        Song current = head;
        while (current != null) {
            System.out.println("Playing: " + current.title);
            current = current.next;
        }
    }
}
```

### 2. Doubly Linked List - Browser History

A doubly linked list can be used to manage browser history, allowing navigation both forward and backward.

```java
public class BrowserHistory {
    private static class WebPage {
        String url;
        WebPage next;
        WebPage prev;

        WebPage(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }

    private WebPage current;

    public void visit(String url) {
        WebPage newPage = new WebPage(url);
        if (current != null) {
            current.next = newPage;
            newPage.prev = current;
        }
        current = newPage;
    }

    public void goBack() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        }
    }

    public void goForward() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        }
    }
}
```

### 3. Circular Linked List - Round-Robin Task Scheduling

A circular linked list can be used for round-robin scheduling, where tasks are cycled through repeatedly.

```java
public class TaskScheduler {
    private static class Task {
        String name;
        Task next;

        Task(String name) {
            this.name = name;
        }
    }

    private Task head;
    private Task tail;

    public void addTask(String name) {
        Task newTask = new Task(name);
        if (head == null) {
            head = newTask;
            tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void execute() {
        Task current = head;
        do {
            System.out.println("Executing task: " + current.name);
            current = current.next;
        } while (current != head);
    }
}
```

These examples illustrate how different types of linked lists can be applied to solve various problems in software development.