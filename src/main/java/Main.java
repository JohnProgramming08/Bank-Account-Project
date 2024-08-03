import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public static int displayHomeMenu(double balance, Scanner sc) {
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

    public static int displayWithdrawMenu(double balance, Scanner sc) {
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
        return sc.nextInt();
    }

    public static int displayDepositMenu(double balance, Scanner sc) {
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
        return sc.nextInt();
    }

    public static void displayTransactionList(double balance, Scanner sc) {
        // Output the transaction list
        System.out.println("==========");
        System.out.println("TRANSACTION LIST");
        System.out.println("==========");
        System.out.println("BALANCE: £" + balance);
        
        // Get the list of transactions from the file
        try {
            File transactionList = new File("transaction_list.txt");
            Scanner FileReader = new Scanner(transactionList);
            while (FileReader.hasNextLine()) {
                String transaction = FileReader.nextLine();
                System.out.println(transaction);
            }
        }
        catch (Exception e) {
            System.out.println("An error occured during the transaction list retrieval.");
        }
        System.out.println("==========");
    }
}