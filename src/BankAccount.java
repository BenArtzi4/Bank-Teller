public class BankAccount extends Thread
{
    private final int accountNumber;
    private double balance;

    public BankAccount(int account, double amount)
    {
        this.accountNumber = account;
        this.balance = amount;
    }

    public void run()
    {
        super.run();
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
