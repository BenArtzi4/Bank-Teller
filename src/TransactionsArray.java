import java.util.ArrayList;

public class TransactionsArray
{
    ArrayList<Transaction> transactions;
    private final static int FIRST = 0;
    private final static int EMPTY = 0;


    public TransactionsArray(Transaction [] transactions)
    {
        this.transactions = new ArrayList<Transaction>();
    }

    public Transaction pullTransaction()
    {
        if (transactions.size() == EMPTY)
        {
            return null;
        }
        int tempAccountNumber = transactions.get(FIRST).getAccountNumber();
        double tempAmount = transactions.get(FIRST).getAmount();
        Transaction tempTransaction = new Transaction(tempAccountNumber, tempAmount);
        transactions.remove(FIRST);
        return tempTransaction;
    }
}
