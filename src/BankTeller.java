import java.util.Random;

public class BankTeller extends Thread
{
    private final TransactionsArray transactions;

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
                printRejectedTransaction(currentBankAccount, currentTransaction);
                transactions.addTransaction(currentTransaction);
            }
            else
            {
                printSuccessTransaction(currentBankAccount, currentTransaction);
            }
            try {
                sleep(randomSleepTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printSuccessTransaction(BankAccount currentBankAccount, Transaction currentTransaction)
    {
        System.out.printf(
                "\n\nTransaction completed successfully\n" +
                        "Bank account: " + "%d" +
                        "\nBalance before Transaction: " + "%.2f" +
                        "\nBalance after Transaction: " + "%.2f" +
                        "\nTransaction amount: " + "%.2f",
                currentBankAccount.getAccountNumber(), (currentBankAccount.getBalance() - currentTransaction.getAmount()),
                currentBankAccount.getBalance(), currentTransaction.getAmount()
        );
    }

    private void printRejectedTransaction(BankAccount currentBankAccount, Transaction currentTransaction)
    {
        System.out.printf(
                "\n\nTransaction was rejected due to an attempt to enter a negative balance\n" +
                        "Bank account: " + "%d" +
                        "\nCurrent balance: " + "%.2f" +
                        "\nTransaction amount: " + "%.2f" +
                        "\nBalance if the action was executed: " + "%.2f",
                currentBankAccount.getAccountNumber(), currentBankAccount.getBalance(),
                currentTransaction.getAmount(), (currentBankAccount.getBalance() +currentTransaction.getAmount())
        );
    }

    private int randomSleepTime()
    {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
