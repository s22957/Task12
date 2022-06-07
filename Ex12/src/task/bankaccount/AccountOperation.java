package task.bankaccount;

public interface AccountOperation {

    double getAccountBalance();

    void transferFunds(double amount) throws AccountOperationException;

    void makeDeposit(double amount);
}
