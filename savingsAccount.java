// Savings Account child class
// has an interest rate
// a method to apply interest - profit
public class savingsAccount extends Account{
    // interest rate
    private double interestRate;

    //default constructor
    public savingsAccount(){
        super();                //calling base class constructor
    }

    /**
     * Parameterized constructor to initialise savingsAccount with a custom Account Number and an Interest Rate.
     */
    public savingsAccount(int accountNumber, double interestRate){
        super(accountNumber);
        this.interestRate = interestRate;
    }

    //getter method

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double calcInterest(){               //amount earned by the account due to interest rate
        return balance * interestRate;
    }

    public void applyInterest(){
        double interestEarned = calcInterest();
        System.out.printf("Interest amount %.2f added to balance%n",interestEarned);
        deposit(interestEarned);
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
            if((amount) <= balance){
                balance -= amount;
                System.out.printf("Amount of %.2f is withdrawn%n", amount);
                System.out.printf("Current balance is: %.2f%n", balance);
            }else{
                System.out.println("Amount cannot be withdrawn due to insufficient balance!!!");
            }
        }else{
            System.out.println("A negative amount cannot be withdrawn!!!");
        }
    }
}
