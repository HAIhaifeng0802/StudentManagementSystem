/**
 * Represents a user entity in the Student Management System
 * Contains user authentication information
 */
public class User {
    private String username;    // User's login username
    private String password;    // User's login password
    private String personid;    // User's personal ID number
    private String phoneNumber; // User's phone number
    
    /**
     * Default constructor for User class
     */
    public User() {
    }
    
    /**
     * Parameterized constructor for User class
     * @param username User's login username
     * @param password User's login password
     * @param personid User's personal ID number
     * @param phoneNumber User's phone number
     */
    public User(String username, String password, String personid, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.personid = personid;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Gets the username
     * @return The username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Sets the username
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Gets the password
     * @return The password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Sets the password
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Gets the personal ID number
     * @return The personal ID number
     */
    public String getPersonID() {
        return personid;
    }
    
    /**
     * Sets the personal ID number
     * @param personid The personal ID number to set
     */
    public void setPersonID(String personid) {
        this.personid = personid;
    }
    
    /**
     * Gets the phone number
     * @return The phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Sets the phone number
     * @param phoneNumber The phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
