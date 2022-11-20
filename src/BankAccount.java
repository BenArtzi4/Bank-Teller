public class BankAccount
{
    private final int accountNumber;
    private double balance;
    private final static int ZERO = 0;

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
        // TODO: maybe using while the account is negative
        if (amount > ZERO || this.balance - amount >= ZERO )
        {
            this.balance += amount;
        }
        else
        {

        }
    }
}
