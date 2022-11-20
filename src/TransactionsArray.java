import java.util.ArrayList;
import java.util.Arrays;

public class TransactionsArray
{
    ArrayList<Transaction> transactions;
    private final static int FIRST = 0;
    private final static int EMPTY = 0;

    public TransactionsArray()
    {
        this.transactions = new ArrayList<Transaction>();
    }

    public TransactionsArray(Transaction [] transactions)
    {
        this.transactions = new ArrayList<Transaction>();
        this.transactions.addAll(Arrays.asList(transactions));
    }

    public synchronized Transaction pullTransaction()
    {
        if (transactions.size() == EMPTY)
        {
            return null;
        }
        Transaction currentTransaction = transactions.get(FIRST);
        transactions.remove(FIRST);
        return currentTransaction;
    }

    public void addTransaction(Transaction transaction)
    {
        this.transactions.add(transaction);
    }

    public Transaction getTransaction(int i)
    {
        return transactions.get(i);
    }

    public boolean isEmpty()
    {
        return this.transactions.size() == EMPTY;
    }
}
