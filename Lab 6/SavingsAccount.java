
public class SavingsAccount extends BankAccount {
    private double rate = .025;
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount (String name, double amount) {
        super(name, amount);
        accountNumber = super.getAccountNumber() + "-" + savingsNumber++;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        accountNumber = super.getAccountNumber() + "-" + ++savingsNumber;
    }

    public void postInterest() {
        double monthlyInterestRate = rate / 12;
        double interest = super.getBalance() * monthlyInterestRate;
        super.deposit(interest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }
}