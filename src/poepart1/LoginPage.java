// @author Lerato Mokoena [ST10104238]
import java.util.Scanner;

public class LoginPage {
  private String username;
  private String password;
  private String firstName;
  private String lastName;

  // Constructors - Construct The Variables
  public LoginPage(String username, String password, String firstName, String lastName) 
  {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  // Method to check if username meets conditions
  public boolean checkUserName() 
  {
    return username.contains("_") && username.length() <= 5;
  }

  // Method to check if password meets conditions
  public boolean checkPasswordComplexity() 
  {
    return password.length() >= 8 &&
        password.matches(".*[A-Z].*") &&
        password.matches(".*\\d.*") &&
        password.matches(".*[!@#$%^&*()].*");
  }

  // Method to register user and return message
  public String registerUser() 
  {
    if (!checkUserName()) {
      return "Username is not formatted correctly, please make sure that your username contains an underscore and is no more than 5 characters in length.";
    } else if (!checkPasswordComplexity()) {
      return "Password is not formatted correctly, please make sure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
    } else {
      return "User registeration is successful.";
    }
  }

  // Method to check user login
  public boolean loginUser(String enteredUsername, String enteredPassword) 
  {
    return enteredUsername.equals(username) && enteredPassword.equals(password);
  }

  // Method to return login status message
  public String returnLoginStatus(boolean isLoggedIn) 
  {
    if (isLoggedIn) {
      return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
    } else {
      return "Username or password incorrect, please try again.";
    }
  }

  public static void main(String[] args) 
  {
    // Sample usage of the LoginPage class
    Scanner scanner = new Scanner(System.in);

    // Registration Method
    System.out.println("Enter username:");
    String username = scanner.nextLine();
    System.out.println("Enter password:");
    String password = scanner.nextLine();
    System.out.println("Enter first name:");
    String firstName = scanner.nextLine();
    System.out.println("Enter last name:");
    String lastName = scanner.nextLine();

    LoginPage user = new LoginPage(username, password, firstName, lastName);
    String registrationMessage = user.registerUser();
    System.out.println(registrationMessage);

    // Login Method
    System.out.println("Enter your username to login:");
    String enteredUsername = scanner.nextLine();
    System.out.println("Enter your password to login:");
    String enteredPassword = scanner.nextLine();

    boolean isLoggedIn = user.loginUser(enteredUsername, enteredPassword);
    String loginStatusMessage = user.returnLoginStatus(isLoggedIn);
    System.out.println(loginStatusMessage);
  }
}

