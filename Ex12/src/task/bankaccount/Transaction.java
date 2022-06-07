package task.bankaccount;

public final class Transaction {

    private double amount;
    private final BankAccount sender;
    private final BankAccount recipient;

    public Transaction(double amount, BankAccount sender, BankAccount recipient) {
        this.amount = amount;
        this.sender = sender;
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public BankAccount getSender() {
        return sender;
    }

    public BankAccount getRecipient() {
        return recipient;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                '}';
    }
}
