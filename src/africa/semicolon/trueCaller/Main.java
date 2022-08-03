package africa.semicolon.trueCaller;

import africa.semicolon.trueCaller.controllers.UserController;
import africa.semicolon.trueCaller.dto.requests.AddContactRequest;
import africa.semicolon.trueCaller.dto.requests.RegisterRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
@SpringBootApplication

public class Main {
    private static final Scanner keyboardInput = new Scanner(System.in);
    private static final UserController userController = new UserController();
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        displayMainMenu();
    }

    private static void displayMainMenu() {
        // prompt user with menu
        // if user selects a, b , c , d direct them

        String mainMenuPrompt = """
                 ----------------------------------------
                | Welcome to TrueCaller!                 |
                | 1. Register                            |
                | 2. Add Contact To A User               |
                | 3. Find contact belonging to a user    |
                 ----------------------------------------
                """;
        System.out.println(mainMenuPrompt);
        String userInput = keyboardInput.nextLine();
        switch (userInput.charAt(0)) {
            case '1' -> createAnAccount();
            case '2' -> addContactToAUser();
            case '3' -> findContactBelongingToAUser();
        }
    }

    private static void createAnAccount () {
            RegisterRequest request = new RegisterRequest();
            request.setUsername(input("Enter The UserName"));
//            request.setLastName(input("Enter The Last Name"));
//            request.setPhoneNumber(input("Enter The Phone Number"));
            request.setEmail(input("Enter The Email"));
            request.setPassword(input("Enter The Password"));
            userController.registerUser(request);
            System.out.println("Registration Success!!!");
            displayMainMenu();
        }

        private static void addContactToAUser(){
            AddContactRequest contactRequest = new AddContactRequest();
            contactRequest.setEmail(input("Enter Contact Email"));
            contactRequest.setUserEmail(input("Enter Your Email"));
            contactRequest.setFirstName(input("Enter Contact First Name"));
            contactRequest.setLastName(input("Enter Contact Last Name"));
            contactRequest.setPhoneNumber(input("Enter Contact Phone Number"));
            userController.addContact(contactRequest);
            System.out.println("Contact Has Been Saved !!!");
            displayMainMenu();

    }
    private static void findContactBelongingToAUser(){
        var contacts = userController.findContactBelongingTo(input("Enter Your Email"));
        for(var contact : contacts){
            System.out.println(contact.toString());
            displayMainMenu();
        }
    }

        public static String input (String prompt){
            System.out.println(prompt);
            return keyboardInput.nextLine();
        }
    }
