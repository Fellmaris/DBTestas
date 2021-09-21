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
        if (user == null){
           return;
        }
        userInterface(scanner, operations, user);
    }

    private void userInterface(Scanner scanner, Operations operations, User user) {
        while (true) {
            System.out.println("Welcome " + user.getName() + user.getSurname() + "\n" +
                    "Your current balance is: " + user.getBalance());
            System.out.println("Would you like to leave or send money?");
            System.out.println("1.Send money");
            System.out.println("2. Leave");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    sendMoney(scanner, operations, user);
                    break;
                case 2:
                    return;
            }
        }
    }

    private void sendMoney(Scanner scanner, Operations operations, User user) {
        while (true) {
            System.out.println("How much money would you like to send?");
            double amount = scanner.nextDouble();
            if (amount > user.getBalance()) {
                System.out.println("You do not have enough funds.");
            } else {
                System.out.println("To whoom would you like to send the money?");
                String nameOfReciever = scanner.next();
                String surnameOfReciever = scanner.next();
                User reciever = operations.findUser(nameOfReciever,surnameOfReciever);
                reciever.setBalance(reciever.getBalance() + amount);
                user.setBalance(user.getBalance() - amount);
            }
        }
    }

    private void register(Scanner scanner, Operations operations) {
        System.out.println("Enter your name:");
        String name = scanner.next();
        System.out.println("Enter your surname:");
        String surname = scanner.next();
        System.out.println("Enter your balance");
        double balance = scanner.nextDouble();
        User user = new User(name,surname, balance);
        operations.InserUser(user.get_id(), user.name, user.surname, user.getBalance());
        System.out.println("User succesfuly created");
    }
}
