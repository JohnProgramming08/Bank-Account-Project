import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean program_running = true;
        while (program_running) {
            double balance = getBalance();
            int choice = homeMenu(balance, sc);
            switch (choice) {
                case 1:
                    // Withdraw the amount chosen and save it to the files
                    try {
                        double amount = withdrawMenu(balance, sc);
                        balance -= amount;
                        File balanceFile = new File("balance.txt");
                        FileWriter balanceFileWriter = new FileWriter(balanceFile);
                        balanceFileWriter.write(String.valueOf(balance));
                        balanceFileWriter.close();
                        
                        File transactionsFile = new File("transaction_list.txt");
                        FileWriter transactionsFileWriter = new FileWriter(transactionsFile, true);
                        transactionsFileWriter.write(String.valueOf(amount) + " withdrawn\n");
                        transactionsFileWriter.close();
                    }
                    catch (Exception e) {
                        System.out.println("An error occurred.");
                    }
                    break;
                    
                case 2:
                    // Deposit the amount chosen and save it to the files
                    try {
                        double amount = depositMenu(balance, sc);
                        balance += amount;
                        File balanceFile = new File("balance.txt");
                        FileWriter balanceFileWriter = new FileWriter(balanceFile);
                        balanceFileWriter.write(String.valueOf(balance));
                        balanceFileWriter.close();

                        File transactionsFile = new File("transaction_list.txt");
                        FileWriter transactionsFileWriter = new FileWriter(transactionsFile, true);
                        transactionsFileWriter.write(String.valueOf(amount) + " deposited\n");
                        transactionsFileWriter.close();
                    }
                    catch (Exception e) {
                        System.out.println("An error occurred.");
                    }
                    break;
                    
                case 3:
                    // Output the transactions list
                    transactionList(balance, sc);
                    break;
                    
                case 4:
                    // Exit the program
                    program_running = false;
            }
        }
    }

    public static double getBalance() {
        // Returns the users balance
        try {
            File balanceFile = new File("balance.txt");
            Scanner fileReader = new Scanner(balanceFile);
            double balance = fileReader.nextDouble();
            fileReader.close();
            return balance;
        }
        catch (Exception e) {
            System.out.println("There was an error reading your balance.");
            return 0.00;
        }
    }
    
    public static int homeMenu(double balance, Scanner sc) {
        // Output the menu and return their selection
        System.out.println("==========");
        System.out.println("MENU");
        System.out.println("==========");
        System.out.println("BALANCE: £" + balance);
        System.out.println("(1)  WITHDRAW FUNDS");
        System.out.println("(2)  DEPOSIT FUNDS");
        System.out.println("(3)  TRANSACTION LIST");
        System.out.println("(4)  EXIT PROGRAM");
        System.out.println("==========");
        System.out.print("Enter your selection: ");
        return sc.nextInt();
    }

    public static double withdrawMenu(double balance, Scanner sc) {
        // Output the menu and return their selection
        System.out.println("==========");
        System.out.println("WITHDRAW FUNDS");
        System.out.println("==========");
        System.out.println("BALANCE: £" + balance);
        System.out.println("(1)  £10.00");
        System.out.println("(2)  £25.00");
        System.out.println("(3)  £50.00");
        System.out.println("(4)  £100.00");
        System.out.println("==========");
        System.out.print("Enter your selection: ");
        int choice = sc.nextInt();

        // Retun the amount to withdraw
        switch (choice) {
            case 1:
                return 10.00;

            case 2:
                return 25.00;

            case 3:
                return 50.00;

            case 4:
                return 100.00;
        }
        return 0.00;
    }

    public static double depositMenu(double balance, Scanner sc) {
        // Output the menu and return their selection
        System.out.println("==========");
        System.out.println("DEPOSIT FUNDS");
        System.out.println("==========");
        System.out.println("BALANCE: £" + balance);
        System.out.println("(1)  £10.00");
        System.out.println("(2)  £25.00");
        System.out.println("(3)  £50.00");
        System.out.println("(4)  £100.00");
        System.out.println("==========");
        System.out.print("Enter your selection: ");
        int choice = sc.nextInt();

        // Return the amount to deposit
        switch (choice) {
            case 1:
                return 10.00;

            case 2:
                return 25.00;

            case 3:
                return 50.00;

            case 4:
                return 100.00;
        }
        return 0.00;
    }

    public static void transactionList(double balance, Scanner sc) {
        // Output the transaction list
        System.out.println("==========");
        System.out.println("TRANSACTION LIST");
        System.out.println("==========");
        System.out.println("BALANCE: £" + balance);
        
        // Get the list of transactions from the file
        try {
            File transactionsFile = new File("transaction_list.txt");
            Scanner transactionsFileReader = new Scanner(transactionsFile);
            while (transactionsFileReader.hasNextLine()) {
                String transaction = transactionsFileReader.nextLine();
                System.out.println("£" + transaction);
            }
            transactionsFileReader.close();
        }
        catch (Exception e) {
            System.out.println("An error occured during the transaction list retrieval.");
        }
        System.out.println("==========");
    }
}