import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
  }

  public static int display_menu(double balance, Scanner sc) {
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
}