import java.util.Scanner;
public class accountDriver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //creating an array of accounts
        Account[] account = new Account[20];
        int numOfAccounts = 0;

        int choice;

        do{
            choice = menu(keyboard);
            System.out.println();

            if(choice == 1){
                account[numOfAccounts++] = createAccount(keyboard);
            }else if(choice == 2){
                doDeposit(account, numOfAccounts, keyboard);
            }else if(choice == 3){
                doWithdraw(account, numOfAccounts, keyboard);
            }else if(choice == 4) {
                applyInterest(account, numOfAccounts, keyboard);
            }else{
                System.out.println("Goodbye");
            }
            System.out.println();
        }while(choice != 5);
    }

    /**
     * Account choice
     * @param keyboard
     * @return choice
     */
    public static int accountMenu(Scanner keyboard){
        System.out.println("Select account type: ");
        System.out.println("1. Checking account");
        System.out.println("2. Savings account");

        int choice;

        do{
            System.out.println("Enter choice: ");
            choice = keyboard.nextInt();
        }while(choice<1 || choice>2);

        return choice;
    }
    /*
    searches for the existence of the user entered account number
     */
    public static int searchAccount(Account account[], int count, int accountNumber){
        for(int i=0; i<count; i++){
            if(account[i].getAccountNumber() == accountNumber){
                return i;
            }
        }
        return -1;
    }

    /*
    Function to perform deposit on a selected account
     */
    public static void doDeposit(Account account[], int count, Scanner keyboard){
        //getting the account number
        System.out.println("Enter account number: ");
        int accountNumber = keyboard.nextInt();

        //searching for the account
        int index = searchAccount(account, count, accountNumber);

        if(index >= 0){
            //getting amount to be deposited
            System.out.println("Enter the amount to be deposited: ");
            double amount = keyboard.nextDouble();

            account[index].deposit(amount);
        }else{
            System.out.println("No such account exists with account number: "+accountNumber);
        }
    }

    /*
    Fucntion to perform withdrawal on a selected account
     */
    public static void doWithdraw(Account account[], int count, Scanner keyboard){
        //getting the account number
        System.out.println("Enter account number: ");
        int accountNumber = keyboard.nextInt();

        //searching for the account
        int index = searchAccount(account, count, accountNumber);

        if(index >= 0){
            //getting amount to be deposited
            System.out.println("Enter the amount to be withdrawn: ");
            double amount = keyboard.nextDouble();

            account[index].withdraw(amount);
        }else{
            System.out.println("No such account exists with account number: "+accountNumber);
        }
    }

    /*
    function to apply the interest rate
     */
    public static void applyInterest(Account account[], int count, Scanner keyboard){
        //getting the account number
        System.out.println("Enter account number: ");
        int accountNumber = keyboard.nextInt();

        //searching for the account
        int index = searchAccount(account, count, accountNumber);

        if(index >= 0){
            //must be an instance of savings account
            if(account[index] instanceof savingsAccount){
                ((savingsAccount)account[index]).applyInterest();
            }
        }else{
            System.out.println("No such account exists with account number: "+accountNumber);
        }
    }

    /**
     * Function to create a new account
     */
    public static Account createAccount(Scanner keyboard){
        Account account = null;
        int choice = accountMenu(keyboard);

        int accountNumber;
        System.out.print("Enter account number: ");
        accountNumber = keyboard.nextInt();
        if(choice == 1){                                        //checking account
            System.out.println("Enter transaction fee: ");
            double fee = keyboard.nextDouble();

            account = new checkingAccount(accountNumber,fee);
        }else{                                                  //savings account
            System.out.println("Enter interest rate: ");
            double ir = keyboard.nextDouble();

            account = new savingsAccount(accountNumber, ir);
        }

        return account;
    }

    /**
     * Menu to display options for the user to select from
     * @param keyboard
     * @return choice
     */
    public static int menu(Scanner keyboard){
        System.out.println("Bank account menu: ");
        System.out.println("1. Create new account");
        System.out.println("2. Deposit funds");
        System.out.println("3. Withdraw funds");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do{
            System.out.println("Enter choice: ");
            choice = keyboard.nextInt();
        }while(choice<1 || choice>5);

        return choice;
    }
}
