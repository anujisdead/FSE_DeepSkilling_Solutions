package code;
class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int id, String name, String pos, double sal) {
        this.employeeId = id;
        this.name = name;
        this.position = pos;
        this.salary = sal;
    }
}

class EmployeeSystem {
    Employee[] employees = new Employee[100];
    int count = 0;

    void addEmployee(Employee e) {
        employees[count++] = e;
    }

    Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) return employees[i];
        }
        return null;
    }

    void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name);
        }
    }

    void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                count--;
                break;
            }
        }
    }
}

class EmployeeTest {
    public static void main(String[] args) {
        EmployeeSystem es = new EmployeeSystem();
        es.addEmployee(new Employee(101, "Alice", "Developer", 80000));
        es.addEmployee(new Employee(102, "Bob", "Manager", 95000));
        es.addEmployee(new Employee(103, "Charlie", "Analyst", 70000));

        System.out.println("All Employees:");
        es.traverseEmployees();

        System.out.println("\nSearching for Employee 102:");
        Employee e = es.searchEmployee(102);
        if (e != null) {
            System.out.println("Found: " + e.name);
        } else {
            System.out.println("Not Found.");
        }

        System.out.println("\nDeleting Employee 102:");
        es.deleteEmployee(102);

        System.out.println("\nAll Employees after deletion:");
        es.traverseEmployees();
    }
}
