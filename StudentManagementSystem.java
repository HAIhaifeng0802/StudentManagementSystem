import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    /**
     * Main method - entry point of the Student Management System
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        loop: while (true) {
            System.out.println("----------Welcome to Student Management System----------");
            System.out.println("Please select an option:");
            System.out.println("1. Add Students");
            System.out.println("2. Delete Students");
            System.out.println("3. Change Student Details");
            System.out.println("4. Query Student");
            System.out.println("5. Exit");
            System.out.println("Please enter your choice:");

            Scanner sc = new Scanner(System.in);
            String choice = sc.next();

            switch (choice) {
                case "1" -> addStudent(students);
                case "2" -> deleteStudent(students);
                case "3" -> changeStudentDetails(students);
                case "4" -> queryStudent(students);
                case "5" -> {
                    System.out.println("Thank you for using Student Management System!");
                    break loop;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new student to the system with validation
     * @param students ArrayList of Student objects
     */
    public static void addStudent(ArrayList<Student> students) {
        System.out.println("Please enter the student details:");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter id: ");
            String id = sc.next();
            if (!contains(students, id)) {
                System.out.print("Enter name: ");
                String name = sc.next();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                System.out.print("Enter address: ");
                String address = sc.next();

                Student stu = new Student(id, name, age, address);
                students.add(stu);
                break;
            } else {
                System.out.println("Student already exists!");
            }
        }
        System.out.println("Student added successfully.");
    }

    /**
     * Deletes a student from the system
     * @param students ArrayList of Student objects
     */
    public static void deleteStudent(ArrayList<Student> students) {
        System.out.println("Delete Student");
        System.out.print("Enter id of student to delete: ");
        Scanner sc = new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(students, id);
        if (index >= 0) {
            students.remove(index);
            System.out.println("Student " + id + " deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    /**
     * Updates student details
     * @param students ArrayList of Student objects
     */
    public static void changeStudentDetails(ArrayList<Student> students) {
        System.out.println("Change Student Details");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id of student to change: ");
        String id = sc.next();
        int index = getIndex(students, id);
        if (index == -1) {
            System.out.println("Student not found.");
            return;
        }
        Student stu = students.get(index);
        System.out.print("Enter new name (press enter to keep current name): ");
        String newname = sc.next();
        if (!newname.isEmpty()) {
            stu.setName(newname);
        }
        System.out.print("Enter new age (press enter to keep current age): ");
        int newage = sc.nextInt();
        if (newage != 0) {
            stu.setAge(newage);
        }
        System.out.print("Enter new address (press enter to keep current address): ");
        String newaddress = sc.next();
        if (!newaddress.isEmpty()) {
            stu.setAddress(newaddress);
        }
        System.out.println("Student details updated successfully.");
    }

    /**
     * Displays all students in the system
     * @param students ArrayList of Student objects
     */
    public static void queryStudent(ArrayList<Student> students) {
        if (students.size() == 0) {
            System.out.println("No students found. Please add students first.");
        } else {
            System.out.println("id\tname\tage\taddress");
            for (int i = 0; i < students.size(); i++) {
                Student stu = students.get(i);
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
            }
        }
    }

    /**
     * Checks if a student with the given ID exists
     * @param students ArrayList of Student objects
     * @param id The student ID to check
     * @return true if student exists, false otherwise
     */
    public static boolean contains(ArrayList<Student> students, String id) {
        return getIndex(students, id) >= 0;
    }

    /**
     * Finds the index of a student in the ArrayList
     * @param students ArrayList of Student objects
     * @param id The student ID to find
     * @return The index of the student or -1 if not found
     */
    public static int getIndex(ArrayList<Student> students, String id) {
        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            if (stu.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
