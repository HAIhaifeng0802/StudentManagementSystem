import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>(); // Create an ArrayList to store user objects

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Welcome to Student Management System");
            System.out.println("Please select an option:");
            System.out.println("1. User Login");
            System.out.println("2. User Register");
            System.out.println("3. User Forget Password");
            System.out.println("4. Exit");
            System.out.println("Please enter your choice:");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1" -> {
                if (userLogin(users)) { // Login successful
                    loggedIn = true; // Set flag to exit loop
                }
            }
                case "2" -> userRegister(users);
                case "3" -> forgetPassword(users);
                case "4" -> {
                    System.out.println("Thank you for using Student Management System!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        StudentManagementSystem.main(new String[0]);

    }

    /**
     * Handles password reset functionality
     * @param users ArrayList of User objects
     */
    public static void forgetPassword(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your username:");
        String username = sc.next();
        int index = getIndex(users, username);
        if (index >= 0) {
            System.out.println("Please enter your Person ID:");
            String personid = sc.next();
            if (personid.equals(users.get(index).getPersonID())) {
                System.out.println("Please enter your phone number:");
                String phoneNumber = sc.next();
                if (phoneNumber.equals(users.get(index).getPhoneNumber())) {
                    System.out.println("Please enter your new password:");
                    String newPassword = sc.next();
                    users.get(index).setPassword(newPassword);
                } else {
                    System.out.println("Phone number does not match.");
                    return;
                }
            } else{
                System.out.println("Username does not exist.");
                return;
            }

            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Username not found! Please register first!");
        }
    }

    /**
     * Handles user registration process with validation
     * @param users ArrayList of User objects
     */
    public static void userRegister(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        while (true) {
            System.out.println("Please set your username:");
            String username = sc.next();
            if (usernameCheck(users, username)) {
                user.setUsername(username);
                break;
            }
        }
        while (true) {
            System.out.println("Please set your password:");
            String password = sc.next();
            System.out.println("Please set your password again:");
            String password_again = sc.next();
            if (!password.equals(password_again)) {
                System.out.println("The two passwords are not the same! Please retry.");
            } else {
                System.out.println("Password set successfully!");
                user.setPassword(password_again);
                break;
            }
        }
        while (true) {
            System.out.println("Please enter your person ID:");
            String personid = sc.next();
            if (personidCheck(personid)) {
                System.out.println("Person ID available!");
                user.setPersonID(personid);
                break;
            }
        }
        while (true) {
            System.out.println("Please enter your phone number:");
            String phoneNumber = sc.next();
            if (phoneNumberCheck(phoneNumber)) {
                System.out.println("Phone number available!");
                user.setPhoneNumber(phoneNumber);
                break;
            }
        }
        users.add(user);
        System.out.println("User registered successfully!");
    }

    /**
     * Validates phone number format
     * @param phoneNumber The phone number to validate
     * @return true if phone number is valid, false otherwise
     */
    public static boolean phoneNumberCheck(String phoneNumber) {
        char ch = phoneNumber.charAt(0);

        if (phoneNumber.length() != 11) {
            System.out.println("Phone number must be 11 digits long.");
            return false;
        } else if (ch == '0') {
            System.out.println("Phone number cannot start with 0.");
            return false;
        } else if (!numberInPhoneNumberCheck(phoneNumber)) {
            System.out.println("Phone number can only contain numbers.");
            return false;
        }
        return true;
    }

    /**
     * Checks if phone number contains only digits
     * @param phoneNumber The phone number to check
     * @return true if phone number contains only digits, false otherwise
     */
    public static boolean numberInPhoneNumberCheck(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            if (!(ch >= '0' && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validates person ID format
     * @param personid The person ID to validate
     * @return true if person ID is valid, false otherwise
     */
    public static boolean personidCheck(String personid) {
        char ch = personid.charAt(0);

        if (personid.length() != 18) {
            System.out.println("Person ID must be 18 digits long.");
            return false;
        } else if (ch == '0') {
            System.out.println("Person ID cannot start with 0.");
            return false;
        } else if (!numberInPersonidCheck(personid)) {
            return false;
        }
        return true;
    }

    /**
     * Checks if person ID meets format requirements
     * @param personid The person ID to check
     * @return true if person ID meets requirements, false otherwise
     */
    public static boolean numberInPersonidCheck(String personid) {
        for (int i = 0; i < personid.length(); i++) {
            if (i != personid.length() - 1) {
                char ch = personid.charAt(i);
                if (ch < '0' || ch > '9') {
                    System.out.println("Person ID cannot contain letters.");
                    return false;
                }
            } else {
                if (personid.charAt(i) < '0' || personid.charAt(i) > '9') {
                    if (personid.charAt(i) == 'X' || personid.charAt(i) == 'x') {
                        return true;
                    } else {
                        System.out.println("Person ID must end with a number or an X.");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Handles user login process with validation
     * @param users ArrayList of User objects
     * @return true if login is successful, false otherwise
     */
    public static boolean userLogin(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Username:");
        String username = sc.next();
        
        for (int i = 0; i < 3; i++) {
            if (getIndex(users, username) >= 0) {
                System.out.println("Password:");
                String password = sc.next();
                if (users.get(getIndex(users, username)).getPassword().equals(password)) {
                    System.out.println("Password correct!");
                    if (validationCodeCheck()) { // Validation code correct
                        System.out.println("Login successful! Entering Student Management System...");
                        return true; // Login successful, return true
                    } else {
                        System.out.println("You can only try " + (2 - i) + " more times!");
                        continue;
                    }
                } else {
                    System.out.println("Password error!");
                    System.out.println("You can only try " + (2 - i) + " more times!");
                    continue;
                }
            } else {
                System.out.println("Username not found! Please register first!");
                return false; // Username does not exist, return false
            }
        }
        return false; // Three attempts failed, return false
    }

    /**
     * Generates and validates security code
     * @return true if validation code is correct, false otherwise
     */
    public static boolean validationCodeCheck() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Validation code:");
        String validationCode = getVlidationCode();
        System.out.println(validationCode);
        System.out.println("Please enter the validation code:");
        String input = sc.next();
        if (input.equals(validationCode)) {
            System.out.println("Validation code correct!");
            return true;
        } else {
            System.out.println("Validation code incorrect!");
        }
        return false;
    }

    /**
     * Generates a random validation code
     * @return The generated validation code
     */
    public static String getVlidationCode() {
        char[] chs = new char[62];
        for (int i = 0; i < 26; i++) {
            chs[i] = (char) ('A' + i);
            chs[i + 26] = (char) ('a' + i);
        }
        for (int i = 0; i < 10; i++) {
            chs[i + 52] = (char) ('0' + i);
        }

        String code = "";
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            int randidx = r.nextInt(chs.length);
            code = code + chs[randidx];
        }

        return code;
    }

    /**
     * Validates username format and uniqueness
     * @param users ArrayList of User objects
     * @param username The username to validate
     * @return true if username is valid, false otherwise
     */
    public static boolean usernameCheck(ArrayList<User> users, String username) {
        if (users.size() == 0) {
            if (getIndex(users, username) >= 0) {
                System.out.println("Username already exists!");
                return false;
            } else if (username.length() < 3 || username.length() > 15) {
                System.out.println("Username must be between 3 and 15 characters long.");
                return false;
            } else if (!compositionCheck(username)) {
                System.out.println("Username must contain letters and numbers.");
                return false;
            } else {
                System.out.println("Username available!");
            }
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (getIndex(users, username) >= 0) {
                    System.out.println("Username already exists!");
                    return false;
                } else if (username.length() < 3 || username.length() > 15) {
                    System.out.println("Username must be between 3 and 15 characters long.");
                    return false;
                } else if (!compositionCheck(username)) {
                    System.out.println("Username must contain letters and numbers.");
                    return false;
                } else {
                    System.out.println("Username available!");
                }
            }
        }
        return true;
    }

    /**
     * Checks if username contains both letters and numbers
     * @param username The username to check
     * @return true if username contains both letters and numbers, false otherwise
     */
    public static boolean compositionCheck(String username) {
        boolean hasLetter = false;
        boolean hasNumber = false;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            }
            if (c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
                hasLetter = true;
            }
            if (hasLetter && hasNumber) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds the index of a user in the ArrayList
     * @param users ArrayList of User objects
     * @param username The username to find
     * @return The index of the user or -1 if not found
     */
    public static int getIndex(ArrayList<User> users, String username) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }
}
