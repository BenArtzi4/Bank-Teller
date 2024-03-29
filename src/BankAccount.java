public class BankAccount
{
    private final int accountNumber;
    private double balance;

    public BankAccount(int account, double amount)
    {
        this.accountNumber = account;
        this.balance = amount;
    }

    public synchronized int getAccountNumber() {
        return accountNumber;
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

    private void setBalance(double amount)
    {
        this.balance += amount;
    }

    @Override
    public synchronized String toString()
    {
        return String.format("Account number: " +"%d"  + "\nBalance: " + "%.2f" ,this.accountNumber,this .balance);
    }
}
