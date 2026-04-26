import java.util.*;
import java.io.*;

class Student {
    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Marks: " + marks;
    }
}

public class studentManagementSystem {

    static List<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        loadFromFile();

        while (true) {
            System.out.println("\n====== STUDENT MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Exiting... Data saved!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 🔹 Add Student
    static void addStudent() {
        System.out.println("\n--- Add Student ---");

        int id = getIntInput("Enter ID: ");

        // Check duplicate ID
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        sc.nextLine(); // fix buffer issue
        String name = sc.nextLine();

        int marks = getIntInput("Enter Marks: ");

        students.add(new Student(id, name, marks));
        saveToFile();

        System.out.println("Student added successfully!");
    }

    // 🔹 View Students
    static void viewStudents() {
        System.out.println("\n--- Student List ---");

        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 🔹 Delete Student
    static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");

        int id = getIntInput("Enter ID to delete: ");

        boolean removed = students.removeIf(s -> s.id == id);

        if (removed) {
            saveToFile();
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    // 🔹 Save to File (CSV)
    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                pw.println(s.id + "," + s.name + "," + s.marks);
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // 🔹 Load from File (SAFE)
    static void loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No previous data found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(",");

                    if (data.length != 3) continue;

                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int marks = Integer.parseInt(data[2].trim());

                    students.add(new Student(id, name, marks));

                } catch (Exception e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // 🔹 Safe Integer Input
    static int getIntInput(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.next(); // clear invalid input
            }
        }
    }
}