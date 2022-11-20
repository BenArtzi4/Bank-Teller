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

        while (transactions.pullTransaction() != null)
        {
            Transaction currentTransaction = transactions.pullTransaction();
            BankAccount currentBankAccount = currentTransaction.getAccount();

        /*
        If the operation cannot be executed as a result of the debtor entering a negative balance
         */
            if(!(currentBankAccount.trySetBalance(currentTransaction.getAmount())))
            {
                System.out.println(
                        "Transaction was rejected due to an attempt to enter a negative balance\n" +
                        "Bank account: " + currentBankAccount.getAccountNumber() +
                        "\n Current balance: " + currentBankAccount.getBalance() +
                        "\nTransaction amount: " + currentTransaction.getAmount() +
                        "\nBalance if the action was executed: " + (currentBankAccount.getBalance() +currentTransaction.getAmount())
                );
                transactions.addTransaction(currentTransaction);
            }
            else
            {
                System.out.println(
                        "Transaction completed successfully\n" +
                        "Bank account: " + currentBankAccount.getAccountNumber() +
                        "\n Balance before Transaction: " + (currentBankAccount.getBalance() - currentTransaction.getAmount()) +
                        "\n Balance after Transaction: " + currentBankAccount.getBalance() +
                        "\nTransaction amount: " + currentTransaction.getAmount() +
                );
            }
        }


    }
}
