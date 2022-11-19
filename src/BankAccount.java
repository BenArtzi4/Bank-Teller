public class BankAccount
{
    private final int accountNumber;
    private double balance;

    public BankAccount(int account, double amount)
    {
        this.accountNumber = account;
        this.balance = amount;
    }

    public double getBalance()
    {
        return balance;
    }

    public void transaction(double amount)
    {
        this.balance += amount;
    }
}
