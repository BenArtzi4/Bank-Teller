public class BankAccount
{
    private final int accountNumber;
    private double balance;

    public BankAccount(int account, double amount)
    {
        this.accountNumber = account;
        this.balance = amount;
    }

    public synchronized double getBalance()
    {
        return balance;
    }

    /*
    This function returns:
    0 - if the balance after adding or subtracting is positive
    1 - if negative
     */
    public synchronized boolean trySetBalance(double amount)
    {
        final int EMPTY = 0;

        if (this.balance + amount < EMPTY)
        {
            return false;
        }
        setBalance(amount);
        return true;
    }

    public void setBalance(double amount)
    {
        this.balance += amount;
    }


}
