class Student {
    private String name;
    private int id;
    private String grade;
    Student(String name, int id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }
    String getName() { return name; }
    int getId() { return id; }
    String getGrade() { return grade; }
    void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    void displayStudentDetails(String name, int id, String grade) {
        System.out.println("Name: " + name + ", ID: " + id + ", Grade: " + grade);
    }
}

class StudentController {
    private Student model;
    private StudentView view;
    StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

class MVCTest {
    public static void main(String[] args) {
        Student s = new Student("John", 1, "A");
        StudentView v = new StudentView();
        StudentController c = new StudentController(s, v);
        c.updateView();
    }
}