package code;
class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }
}

class TaskList {
    Task head = null;

    void addTask(Task t) {
        if (head == null) head = t;
        else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = t;
        }
    }

    Task searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    void traverseTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp.taskName);
            temp = temp.next;
        }
    }

    void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
    }
}

class TaskListTest {
    public static void main(String[] args) {
        TaskList list = new TaskList();
        list.addTask(new Task(1, "Design UI", "In Progress"));
        list.addTask(new Task(2, "Develop Backend", "Not Started"));
        list.addTask(new Task(3, "Test Application", "In Progress"));

        System.out.println("All Tasks:");
        list.traverseTasks();

        System.out.println("\nSearching for Task 2:");
        Task t = list.searchTask(2);
        if (t != null) {
            System.out.println("Found: " + t.taskName);
        } else {
            System.out.println("Not Found.");
        }

        System.out.println("\nDeleting Task 2:");
        list.deleteTask(2);

        System.out.println("\nAll Tasks after deletion:");
        list.traverseTasks();
    }
}
