public class CheckingAccount extends BankAccount{
    private final static double FEE = .15;


    public CheckingAccount(String name, double amount){
        super(name,amount);
        setAccountNumber(getAccountNumber() + "-10");
    }

    public boolean withdraw(double amount){
        return super.withdraw(amount + FEE);
    }




}
