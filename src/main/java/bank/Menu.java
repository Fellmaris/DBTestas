package bank;

import actions.Operations;

import java.util.Scanner;

public class Menu {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Operations operations = new Operations();
        boolean running = true;
        while (running){
            System.out.println("1. Registration");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> register(scanner, operations);
                case 2 -> logIn(scanner, operations);
                case 3 -> running = false;
            }
        }
    }

    private void logIn(Scanner scanner, Operations operations) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your surname:");
        String surname = scanner.next();
        User user = operations.findUser(name, surname);
        if (user != null){
            System.out.println("Your current balance is: " + user.getBalance());
        } else {
            return;
        }
        userInterface(scanner, operations);
    }

    private void userInterface(Scanner scanner, Operations operations) {
        while (true) {
            System.out.println("Would you like to leave or send money?");
            System.out.println("1.Send money");
            System.out.println("2. Leave");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sendMoney(scanner, operations);
                    break;
                case 2:
                    return;
            }
        }
    }

    private void sendMoney(Scanner scanner, Operations operations) {
        System.out.println("");
    }

    private void register(Scanner scanner, Operations operations) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your surname:");
        String surname = scanner.next();
        operations.InserUser(name, surname);
    }
}
