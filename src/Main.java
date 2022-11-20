import java.util.ArrayList;
import java.util.Random;

public class Main
{
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        final int INITIAL_BALANCE = 100000;
        final int NUMBER_OF_ACCOUNTS = 5;
        final int NUMBER_OF_TRANSACTIONS = 40;
        final int NEGATIVE_TRANSACTION = -1;

        System.out.println("\n\n############# All Accounts #############\n\n");
        for (int i = 0; i < NUMBER_OF_ACCOUNTS; i++)
        {
            accounts.add(new BankAccount(i, INITIAL_BALANCE));
            System.out.println(accounts.get(i).toString());
        }

        System.out.println("\n\n############# All Transactions #############\n\n");

        TransactionsArray transactions = new TransactionsArray();


        for (int i = 0; i < NUMBER_OF_TRANSACTIONS; i++)
        {
            transactions.addTransaction(new Transaction(accounts.get(generateRandomAccount()), generateRandomAmount()));
            System.out.println(transactions.getTransaction(i).toString());

        }



        BankTeller teller1 = new BankTeller(transactions);
        BankTeller teller2 = new BankTeller(transactions);
        BankTeller teller3 = new BankTeller(transactions);
        BankTeller teller4 = new BankTeller(transactions);
        BankTeller teller5 = new BankTeller(transactions);

        teller1.start();
        teller2.start();
        teller3.start();
        teller4.start();
        teller5.start();



    }

    public static int generateRandomAccount()
    {
        Random rand = new Random();
        return rand.nextInt(4);
    }

    public static double generateRandomAmount()
    {
        final int MAX = 100000;
        final int MIN = -100000;

        Random rand = new Random();

        int randomAmount = rand.nextInt(MAX - MIN) + MIN;

        System.out.println(randomAmount/100.0);
        return randomAmount/100.0;
    }


}
