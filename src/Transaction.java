public class Transaction
{
    private final int accountNumber;
    private double amount;

    public Transaction(int account, double amount)
    {
        this.accountNumber = account;
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
