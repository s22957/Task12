package task.user;

import task.bankaccount.AccountOperationException;
import task.bankaccount.BankAccount;
import task.bankaccount.Transaction;

public class Employee extends User{

    private static int EMPLOYEE_ID = 1;

    private final int employeeId;

    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
        this.employeeId = EMPLOYEE_ID++;
    }

    public Client createClient(String firstName, String lastName, BankAccount bankAccount){
        return new Client(firstName, lastName, bankAccount);
    }

    public BankAccount createBankAccount(){
        return new BankAccount();
    }

    public void acceptPayment(Transaction transaction){
        double amount = transaction.getAmount();
        BankAccount sender = transaction.getSender();
        BankAccount recipient = transaction.getRecipient();
        try {
            sender.transferFunds(amount);
            recipient.makeDeposit(amount);
            sender.getTransactions().add(transaction);
            recipient.getTransactions().add(transaction);
        } catch (AccountOperationException e) {
            e.printStackTrace();
        }
    }
}
