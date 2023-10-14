import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class BankManagementSystem {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phoneNumber;
    private String password,IDcardNum;
    private int accountNumber;
    private double balance;

    public BankManagementSystem() {
    }

    public BankManagementSystem(String firstName, String lastName, String address, String email, String phoneNumber, String password, int accountNumber, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getIDcardNum() {
        return IDcardNum;
    }

    public void setIDcardNum(String IDcardNum) {
        this.IDcardNum = IDcardNum;
    }

    public void createAccount() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String firstName, lastName, address, email, phoneNumber, password,IDcardNum,Sbalance;
        int accountNumber = rand.nextInt(1000000) + 100000;
        Double balance;

        System.out.print("Enter first name: ");
        firstName = sc.nextLine();

        while (firstName.matches(".*\\d.*")){
            System.out.println("No numbers allowed in name");
            System.out.print("Enter first name again: ");
            firstName = sc.nextLine();
        }


        System.out.print("Enter last name: ");
        lastName = sc.nextLine();
        while (lastName.matches(".*\\d.*")){
            System.out.println("No numbers allowed in name");
            System.out.print("Enter last name again: ");
            lastName = sc.nextLine();
        }


        System.out.print("Enter address: ");
        address = sc.nextLine();


        System.out.print("Enter email: ");
        email = sc.nextLine();
        while (email.contains(" ")) {
            System.out.println("No space is allowed");
            System.out.print("Enter email again: ");
            email = sc.nextLine();
        }


        System.out.print("Enter ID Card number[format: 1234512345678]: ");
        IDcardNum = sc.nextLine();
        if(IDcardNum.length()==13){
            while (IDcardNum.contains(" ")) {
                System.out.println("No space is allowed");
                System.out.print("Enter IDcardNum again: ");
                IDcardNum = sc.nextLine();
            }
            boolean Numeric=false;
            while (!Numeric) {
                try {
                    Long.parseLong(IDcardNum);
                    Numeric = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input Format- please enter only numeric characters.");
                    System.out.print("Enter IDcardNum again: ");
                    IDcardNum = sc.nextLine();
                }
            }
        }
        else {
            System.out.println("IDcardNum digits must be 13");
            System.out.print("Enter IDcardNum again: ");
            IDcardNum = sc.nextLine();
        }
        if(IDcardNum.length()<13){
            System.out.println("IDcardNum digits must be 13");
            System.out.print("Enter IDcardNum again: ");
            IDcardNum = sc.nextLine();
        }
        if(IDcardNum.length()>13){
            System.out.println("IDcardNum digits must be 13");
            System.out.print("Enter IDcardNum again: ");
            IDcardNum = sc.nextLine();
        }


        System.out.print("Enter phone number: ");
        phoneNumber = sc.nextLine();
        while(true){
            while (phoneNumber.contains(" ")) {
                System.out.println("No space is allowed");
                System.out.print("Enter Phone number again: ");
                phoneNumber = sc.nextLine();
            }
            boolean isNumeric=false;
            while (!isNumeric) {
                try {
                    Long.parseLong(phoneNumber);
                    isNumeric = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input - please enter only numeric characters.");
                    System.out.print("Enter a number: ");
                    phoneNumber = sc.nextLine();
                }
            }
            if(phoneNumber.length()!=11){
                System.out.println("phone number digits must be 11");
                System.out.print("Enter phone number again: ");
                phoneNumber = sc.nextLine();
            }
            else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter password (must be at least 8 characters long): ");
            password = sc.nextLine();
            while (password.contains(" ")) {
                System.out.println("No space is allowed");
                System.out.print("Enter password again: ");
                password = sc.nextLine();
            }
            if (password.length() < 8) {
                System.out.println("Password must be at least 8 characters long!");
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter initial balance (must be at least 100): ");
            Sbalance = sc.nextLine();
            while (Sbalance.contains(" ")) {
                System.out.println("No space is allowed");
                System.out.print("Enter amount again: ");
                Sbalance = sc.nextLine();
            }
            boolean isNum=false;
            while (!isNum) {
                try {
                    Integer.parseInt(Sbalance);
                    isNum = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input - please enter only numeric characters.");
                    System.out.print("Enter initial balance again (must be at least 100): ");
                    Sbalance = sc.nextLine();
                }
            }
            balance = Double.parseDouble(Sbalance);

            if (balance < 100) {
                System.out.println("Initial balance must be at least 100!");
            } else {
                break;
            }
        }

        String filename = accountNumber + ".txt";
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("Account number: " + accountNumber + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("First name: " + firstName + "\n");
            writer.write("Last name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone number: " + phoneNumber + "\n");
            writer.write("IDcardNum: "+IDcardNum+"\n");
            writer.write("Balance: " + balance + "\n");
            writer.close();
            System.out.println("Account created successfully. Your account number is " + accountNumber + ".");
        } catch (IOException e) {
            System.out.println("An error occurred while creating your account.");
            e.printStackTrace();
        }
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your account number and password");
        System.out.print("Account number: ");
        String SaccNum = scanner.nextLine();
        boolean isNumeric=false;
        while (!isNumeric) {
            try {
                Integer.parseInt(SaccNum);
                isNumeric = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input - please enter only numeric characters.");
                System.out.print("Enter account number again: ");
                SaccNum = scanner.nextLine();
            }
        }
        int accountNumber = Integer.parseInt(SaccNum);
        System.out.print("Password: ");
        String password = scanner.nextLine();
        while (password.contains(" ")) {
            System.out.println("No space is allowed");
            System.out.print("Enter password again: ");
            password = scanner.nextLine();
        }

        String filename = accountNumber + ".txt";
        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            int fileAccountNumber = Integer.parseInt(fileScanner.nextLine().split(": ")[1]);
            String filePassword = fileScanner.nextLine().split(": ")[1];

            if (accountNumber == fileAccountNumber && password.equals(filePassword)) {
                this.accountNumber=fileAccountNumber;
                this.password=filePassword;
                firstName = fileScanner.nextLine().split(": ")[1];
                lastName = fileScanner.nextLine().split(": ")[1];
                address = fileScanner.nextLine().split(": ")[1];
                email = fileScanner.nextLine().split(": ")[1];
                phoneNumber = fileScanner.nextLine().split(": ")[1];
                IDcardNum = fileScanner.nextLine().split(": ")[1];
                balance = Double.parseDouble(fileScanner.nextLine().split(": ")[1]);
                System.out.println("-----Login Successful-----\n\n Welcome, " + firstName + " " + lastName + "!");
                return true;
            } else {
                System.out.println("Incorrect account number or password.");
                return false;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid");
            return false;
        }
    }


    public void editInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which information would you like to edit?");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Address");
        System.out.println("4. Email");
        System.out.println("5. Phone number");
        System.out.println("6. IDcardNum");
        System.out.println("7. Password");
        String choice = scanner.next();
        scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.print("New first name: ");
                firstName = scanner.nextLine();

                while (firstName.matches(".*\\d.*")){
                    System.out.println("No numbers allowed in name");
                    System.out.print("Enter first name again: ");
                    firstName = scanner.nextLine();
                }
                break;
            case "2":
                System.out.print("New last name: ");
                lastName = scanner.nextLine();

                while (lastName.matches(".*\\d.*")){
                    System.out.println("No numbers allowed in name");
                    System.out.print("Enter first name again: ");
                    lastName = scanner.nextLine();
                }
                break;
            case "3":
                System.out.print("New address: ");
                address = scanner.nextLine();
                break;
            case "4":
                System.out.print("New email: ");
                email = scanner.nextLine();
                while (email.contains(" ")) {
                    System.out.println("No space is allowed");
                    System.out.print("Enter email again: ");
                    email = scanner.nextLine();
                }
                break;
            case "5":
                System.out.print("Enter phone number: ");
                phoneNumber = scanner.nextLine();
                while(true){
                    while (phoneNumber.contains(" ")) {
                        System.out.println("No space is allowed");
                        System.out.print("Enter Phone number again: ");
                        phoneNumber = scanner.nextLine();
                    }
                    boolean isNumeric=false;
                    while (!isNumeric) {
                        try {
                            Long.parseLong(phoneNumber);
                            isNumeric = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input - please enter only numeric characters.");
                            System.out.print("Enter a number: ");
                            phoneNumber = scanner.nextLine();
                        }
                    }
                    if(phoneNumber.length()!=11){
                        System.out.println("phone number digits must be 11");
                        System.out.print("Enter phone number again: ");
                        phoneNumber = scanner.nextLine();
                    }
                    else {
                        break;
                    }
                }
                break;
            case "6":
                System.out.print("Enter IDcardNum number[format: 1234512345678]: ");
                IDcardNum = scanner.nextLine();
                if(IDcardNum.length()==13){
                    while (IDcardNum.contains(" ")) {
                        System.out.println("No space is allowed");
                        System.out.print("Enter IDcardNum again: ");
                        IDcardNum = scanner.nextLine();
                    }
                    boolean Numeric=false;
                    while (!Numeric) {
                        try {
                            Long.parseLong(IDcardNum);
                            Numeric = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input Format- please enter only numeric characters.");
                            System.out.print("Enter IDcardNum again: ");
                            IDcardNum = scanner.nextLine();
                        }
                    }
                }
                else {
                    System.out.println("IDcardNum digits must be 13");
                    System.out.print("Enter IDcardNum again: ");
                    IDcardNum = scanner.nextLine();
                }
                if(IDcardNum.length()<13){
                    System.out.println("IDcardNum digits must be 13");
                    System.out.print("Enter IDcardNum again: ");
                    IDcardNum = scanner.nextLine();
                }
                if(IDcardNum.length()>13){
                    System.out.println("IDcardNum digits must be 13");
                    System.out.print("Enter IDcardNum again: ");
                    IDcardNum = scanner.nextLine();
                }
                break;
            case "7":
                while (true) {
                    System.out.print("Enter password (must be at least 8 characters long): ");
                    password = scanner.nextLine();
                    while (password.contains(" ")) {
                        System.out.println("No space is allowed");
                        System.out.print("Enter password again: ");
                        password = scanner.nextLine();
                    }
                    if (password.length() < 8) {
                        System.out.println("Password must be at least 8 characters long!");
                    } else {
                        break;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        String filename = accountNumber + ".txt";
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone Number: " + phoneNumber + "\n");
            writer.write("IDcardNum: "+ IDcardNum +"\n");
            writer.write("Balance: " + balance + "\n");
            writer.close();
            System.out.println("Information updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating information.");
        }
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the amount to withdraw: ");
        String Samount = scanner.nextLine();

        while (Samount.contains(" ")) {
            System.out.println("No space is allowed");
            System.out.print("Enter amount again: ");
            Samount = scanner.nextLine();
        }

        boolean isNumeric=false;
        while (!isNumeric) {
            try {
                Integer.parseInt(Samount);
                isNumeric = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input - please enter only numeric characters.");
                System.out.print("Enter account number again: ");
                Samount = scanner.nextLine();
            }
        }
        double amount = Double.parseDouble(Samount);

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        if (balance < amount) {
            System.out.println("Insufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("Transaction successful.");


        String filename = "TransactionWithdrawSlip_" + accountNumber + ".txt";
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file, true);
            writer.write("Withdrawal of " + amount + " on " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
            writer.write("Current balance: " + balance + "\n");
            writer.close();
            System.out.println("Transaction record updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating transaction record.");
        }

        String filename1 = accountNumber + ".txt";
        try {
            File file = new File(filename1);
            FileWriter writer = new FileWriter(file);
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone Number: " + phoneNumber + "\n");
            writer.write("IDcardNum: "+ IDcardNum + "\n");
            writer.write("Balance: " + balance + "\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Error in updating");
        }
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the amount to deposit: ");
        String Samount = scanner.nextLine();

        while (Samount.contains(" ")) {
            System.out.println("No space is allowed");
            System.out.print("Enter email again: ");
            Samount = scanner.nextLine();
        }

        boolean isNumeric=false;
        while (!isNumeric) {
            try {
                Integer.parseInt(Samount);
                isNumeric = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input - please enter only numeric characters.");
                System.out.print("Enter account number again: ");
                Samount = scanner.nextLine();
            }
        }
        double amount = Double.parseDouble(Samount);

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance += amount;
        System.out.println("Transaction successful.");



        String filename = "TransactionDepositSlip_"+ accountNumber + ".txt";
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file, true);
            writer.write("Deposit of " + amount + " on " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
            writer.write("Current balance: " + balance + "\n");
            writer.close();
            System.out.println("Transaction record updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating transaction record.");
        }

        String filename1 = accountNumber + ".txt";
        try {
            File file = new File(filename1);
            FileWriter writer = new FileWriter(file);
            writer.write("Account Number: " + accountNumber + "\n");
            writer.write("Password: " + password + "\n");
            writer.write("First Name: " + firstName + "\n");
            writer.write("Last Name: " + lastName + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Phone Number: " + phoneNumber + "\n");
            writer.write("IDcardNum: "+ IDcardNum + "\n");
            writer.write("Balance: " + balance + "\n");
            writer.close();
        }catch (IOException e){
            System.out.println("Error in updating");
        }
    }


    public void checkBalance() {
        try (BufferedReader reader = new BufferedReader(new FileReader(accountNumber + ".txt"))) {
            System.out.println("Your current balance is: Rs" + balance);
        } catch (IOException e) {
            System.out.println("Error accessing account data: " + e.getMessage());
        }
    }
}

public class task3{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("YOU MUST HAVE AN ACCOUNT TO LOGIN");

        boolean point=true;
        while (point){
            BankManagementSystem acc = new BankManagementSystem();
            System.out.print("\033[42m");//bg green
            System.out.print("\033[30m");//font black

            System.out.println("\n--BANK ATM SIMULATOR--");
            System.out.print("\033[31m");// font red
            System.out.println("Developed By Murtaza Hussain\n\n");

            System.out.print("\033[30m");
            System.out.println("----------Welcome to BANK ATM SIMULATOR----------\n\n");

            System.out.println("Select an option: ");
            System.out.println("1) Account Sign in");
            System.out.println("2) Account Log in");
            System.out.println("3) EXIT");

            String option1 = sc.next();

            switch (option1){
                case "1":
                    acc.createAccount();
                    break;
                case "2":
                    if(acc.login()){

                        boolean flag = true;
                        while (flag){
                            System.out.println("\nSelect an option: \n");
                            System.out.println("1) Cash Deposit: ");
                            System.out.println("2) Cash Withdrawal");
                            System.out.println("3) Balance Enquiry");
                            System.out.println("4) Logout");

                            String option2=sc.next();

                            switch (option2){
                                case "1":
                                    acc.deposit();
                                    break;
                                case "2":
                                    if(acc.login())
                                        acc.withdraw();
                                    break;
                                case "3":
                                    acc.checkBalance();
                                    break;
                                case "4":
                                    flag = false;
                                    break;
                                default:
                                    System.out.println("Invalid Entry");
                            }
                        }
                    }
                    break;
                case "3":
                    point = false;
                    System.out.print("\033[31m");// font red
                    System.out.println("Developed By Murtaza Hussain\n\n");
                    break;
                default:
                    System.out.println("invalid Entry");
            }
        }
    }
}