//checking account
public class checkingAccount extends Account{
    //default transaction fee (deducted for every transaction made on an account)
    private static double fees = 2.5;

    //default constructor
    public checkingAccount(){
        super();                //calling base class constructor
    }

    /**
     * Parameterized constructor to initialise CheckingAccount with a custom Account Number and a Customer Transaction Fee.
     */
    public checkingAccount(int accountNumber, double fee){
        super(accountNumber);
        fees = fee;
    }


    //abstract methods
    /**
     * Function to deposit funds into the account as long as the amount parameter is > 0
     *
     * Apply Transaction fee for the CheckingAccount and no fee for the savings account
     *
     * @param amount value to be deposited
     */
    public void deposit(double amount){
        //checking amount
        if(amount>0){
            balance += amount;
            System.out.printf("Amount of %.2f is deposited%n", amount);


            //apply transaction fee
            balance -= fees;
            System.out.printf("Fee of %.2f is applied %n", fees);
            System.out.printf("Current balance is: %.2f%n", balance);

        }else{
            System.out.println("A negative amount cannot be deposited!!!");
        }
    }

    /**
     * Function to withdraw funds from the Account as long as
     *  1. Amount to withdraw must be > 0
     *  2. Amount to withdraw must be <= balance
     *
     * @param amount value to be withdrawn
     */
    public void withdraw(double amount){
        //checking amount
        if(amount>0){
            //check if balance is sufficient
            if((amount+fees) <= balance){
                balance -= amount;
                System.out.printf("Amount of %.2f is withdrawn%n", amount);
                balance -= fees;
                System.out.printf("Fees of %.2f is applied%n", fees);
                System.out.printf("Current balance is: %.2f%n", balance);
            }else{
                System.out.println("Amount cannot be withdrawn due to insufficient balance!!!");
            }
        }else{
            System.out.println("A negative amount cannot be withdrawn!!!");
        }
    }
}
