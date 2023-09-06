import java.util.Scanner;
class BankAcc {
    private double bl;
    public BankAcc(double initbal) {
        this.bl = initbal;
    }
    public double getbl() {
        return bl;
    }
    public void deposit(double amount) {
        bl += amount;
    }
    public boolean withdraw(double amount) {
        if (bl >= amount) {
            bl -= amount;
            return true;
        } else {
            return false;
        }
    }
}
class ATM {
    private BankAcc BankAcc;
    public ATM(BankAcc BankAcc) {
        this.BankAcc = BankAcc;
    }
    public void dispMenu() {
        System.out.println("Welcome to the ATM Machine");
        System.out.println("1. Check bl");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void perTrans() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            dispMenu();
            System.out.print("Please select an option (1-4): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    double bl = BankAcc.getbl();
                    System.out.println("Your bl is: Rs." + bl);
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: Rs.");
                    double depositAmount = scanner.nextDouble();
                    BankAcc.deposit(depositAmount);
                    System.out.println("Deposit successful!");
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: Rs.");
                    double withdrawalAmount = scanner.nextDouble();
                    if (BankAcc.withdraw(withdrawalAmount)) {
                        System.out.println("Withdrawal is unsuccessful !");
                    } else {
                        System.out.println("You have insufficient balance in your A/c. Withdrawal is failed.");
                    }
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Thanks for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option. (1-4).");
            }
        }
        scanner.close();
    }
}
public class task3 {
    public static void main(String args[]) {
        BankAcc userAccount = new BankAcc(1000.0);
        ATM atm = new ATM(userAccount);
        atm.perTrans();
    }
}

