import java.util.ArrayList;

public class BankTeller extends Thread
{
    private TransactionsArray transactions;

    public BankTeller(TransactionsArray transactions)
    {
        this.transactions = transactions;
    }
    @Override
    public void run()
    {
        super.run();

        while (!(transactions.isEmpty()))
        {
            Transaction currentTransaction = transactions.pullTransaction();
            BankAccount currentBankAccount = currentTransaction.getAccount();

        /*
        If the operation cannot be executed as a result of the debtor entering a negative balance
         */
            if(!(currentBankAccount.trySetBalance(currentTransaction.getAmount())))
            {
                System.out.printf(
                        "\nTransaction was rejected due to an attempt to enter a negative balance\n" +
                        "Bank account: " + "%d" +
                        "\n Current balance: " + "%.2f" +
                        "\nTransaction amount: " + "%.2f" +
                        "\nBalance if the action was executed: " + "%.2f",
                        currentBankAccount.getAccountNumber(), currentBankAccount.getBalance(),
                        currentTransaction.getAmount(), (currentBankAccount.getBalance() +currentTransaction.getAmount())

                );
                transactions.addTransaction(currentTransaction);
            }
            else
            {
                System.out.printf(
                        "\nTransaction completed successfully\n" +
                        "Bank account: " + "%d" +
                        "\n Balance before Transaction: " + "%.2f" +
                        "\n Balance after Transaction: " + "%.2f" +
                        "\nTransaction amount: " + "%.2f",
                        currentBankAccount.getAccountNumber(), (currentBankAccount.getBalance() - currentTransaction.getAmount()),
                        currentBankAccount.getBalance(), currentTransaction.getAmount()
                );
            }
        }
    }
}
