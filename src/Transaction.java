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
}
