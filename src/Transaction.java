public class Transaction
{
    private BankAccount account;
    private double amount;

    public Transaction(BankAccount account, double amount)
    {
        this.account = account;
        this.amount = amount;
    }

    public BankAccount getAccount()
    {
        return this.account;
    }

    public double getAmount()
    {
        return this.amount;
    }

    @Override
    public String toString()
    {
        return String.format("Account number: " +"%d"  + "\nAmount: " + "%.2f" ,this.account.getAccountNumber(),this.amount);
    }
}
