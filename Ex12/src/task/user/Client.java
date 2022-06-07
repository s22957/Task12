package task.user;

import task.bankaccount.*;

public class Client extends User{

    private static int CLIENT_ID = 1;

    private final int clientId;
    private final BankAccount bankAccount;

    public Client(String firstName, String lastName, BankAccount bankAccount) {
        super(firstName, lastName);
        clientId = CLIENT_ID++;
        this.bankAccount = bankAccount;
    }

    public Transaction transfer(int amount, BankAccount recipient){
        return new Transaction(amount, this.bankAccount, recipient);
    }

    public void makeDeposit(int amount) {
        bankAccount.makeDeposit(amount);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", bankAccount=" + bankAccount +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
