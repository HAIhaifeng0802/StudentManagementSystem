# Login Module Documentation

## Overview
The Login module is a critical component of the Student Management System, responsible for user authentication, registration, and password management. It provides a secure entry point to the system and ensures only authorized users can access the student management functionalities.

## Features
- User login with username, password, and validation code
- User registration with username, password, person ID, and phone number validation
- Password reset functionality using personal information
- Input validation for all user-provided data
- Secure session establishment

## Class Structure
The Login class contains the following main components:

1. **Main Method** - Entry point of the application that displays the main menu and handles user choices
2. **User Authentication Methods**
   - `userLogin()` - Verifies user credentials
   - `validationCodeCheck()` - Generates and validates security codes
   - `getVlidationCode()` - Creates random validation codes
3. **User Management Methods**
   - `userRegister()` - Registers new users with validation
   - `forgetPassword()` - Resets user passwords using security information
4. **Validation Methods**
   - `usernameCheck()` - Validates username format and uniqueness
   - `personidCheck()` - Validates personal ID format
   - `phoneNumberCheck()` - Validates phone number format
   - `compositionCheck()` - Ensures username contains required character types
   - `numberInPhoneNumberCheck()` - Verifies phone numbers contain only digits
   - `numberInPersonidCheck()` - Verifies personal ID format rules
5. **Utility Methods**
   - `getIndex()` - Finds user index in the user list

## Data Flow
1. User is presented with login menu options
2. Depending on choice, system directs to appropriate functionality:
   - Login: Validates credentials and generates validation code
   - Registration: Collects and validates user information
   - Password Reset: Verifies identity and updates password
3. Upon successful login, user is directed to the Student Management System

## Dependencies
- `java.util.ArrayList` - For storing user objects
- `java.util.Random` - For generating validation codes
- `java.util.Scanner` - For user input handling
- `User` class - For user data structure
- `StudentManagementSystem` class - For post-login functionality

## Usage Instructions
1. Run the Login class to start the application
2. Choose from the available options:
   - Enter '1' to login with existing credentials
   - Enter '2' to register a new account
   - Enter '3' to reset a forgotten password
   - Enter '4' to exit the application
3. Follow the on-screen prompts to complete the selected operation
4. After successful login, the system will automatically launch the Student Management System

## Input Validation Rules
- **Username**: 3-15 characters, must contain both letters and numbers, unique
- **Password**: No specific format constraints (user must confirm password during registration)
- **Person ID**: 18 characters, cannot start with '0', last character can be a number or 'X'
- **Phone Number**: 11 digits, cannot start with '0', must contain only digits

## Error Handling
The system provides clear error messages for invalid inputs and guides users through correct data entry procedures. Login attempts are limited to 3 tries to prevent unauthorized access attempts.
