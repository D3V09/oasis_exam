/* 
Laptop with Browser Icon
The project should be capable of the following functionalities.

1.Login
2.Update Profile and Password
3.Selecting answers for MCQs
4.Timer and auto submit
5.Closing session and Logout
 */

import java.util.*;

class User {
    String username;
    String password;
    public User(String string, String string2) {
        username = string;
        password = string2;
    }
}

public class student {

    static User[] users = {
        new User("Darshan", "darsh2003"),
        new User("coderlife", "coder")
    };

    static User currentUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Select Answers for MCQs");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfileAndPassword(scanner);
                    break;
                case 3:
                    selectMCQAnswers(scanner);
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                currentUser = user;
                System.out.println("Login successful");
                return;
            }
        }
        System.out.println("Invalid username or password");
    }

    static void updateProfileAndPassword(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please login first");
            return;
        }
        
        System.out.println("Updating profile and password for user: " + currentUser.username);
        
        System.out.print("Enter new profile information: ");
        String newProfileInfo = scanner.nextLine();
        
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        currentUser.password = newPassword;
        
        System.out.println("Profile and password updated successfully");
    }
    
    static void selectMCQAnswers(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please login first");
            return;
        }
        
        System.out.println("Selecting MCQ answers for user: " + currentUser.username);
        
        System.out.println("Question 1: What is 2 + 2?");
        System.out.println("a) 3");
        System.out.println("b) 4");
        System.out.println("c) 5");
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();
        
        System.out.println("Answer for Question 1: " + answer1);
        
        System.out.println("MCQ answers submitted successfully");
    }
    

    static void logout() {
        currentUser = null;
        System.out.println("Logged out");
    }
}

