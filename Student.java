/**
 * Represents a student entity in the Student Management System
 * Contains student information including ID, name, age, and address
 */
public class Student {
    private String id;      // Student ID
    private String name;    // Student name
    private int age;        // Student age
    private String address; // Student address
    
    /**
     * Default constructor for Student class
     */
    public Student() {
    }

    /**
     * Parameterized constructor for Student class
     * @param id Student ID
     * @param name Student name
     * @param age Student age
     * @param address Student address
     */
    public Student(String id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Gets the student ID
     * @return The student ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the student ID
     * @param id The student ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the student name
     * @return The student name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the student name
     * @param name The student name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the student age
     * @return The student age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the student age
     * @param age The student age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets the student address
     * @return The student address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the student address
     * @param address The student address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
