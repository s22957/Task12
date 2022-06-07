package task.main;

import task.bankaccount.BankAccount;
import task.user.Administrator;
import task.user.Client;
import task.user.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Administrator administrator = new Administrator("Will", "Smith");

        Employee employee1 = administrator.createEmployee("Johnny", "Depp");
        Employee employee2 = administrator.createEmployee("Vin", "Diesel");

        BankAccount bankAccount1 = employee1.createBankAccount();
        BankAccount bankAccount2 = employee1.createBankAccount();
        BankAccount bankAccount3 = employee2.createBankAccount();
        BankAccount bankAccount4 = employee2.createBankAccount();

        Client client1 = employee1.createClient("First", "customer", bankAccount1);
        Client client2 = employee1.createClient("Second", "customer", bankAccount2);
        Client client3 = employee2.createClient("Third", "customer", bankAccount3);
        Client client4 = employee2.createClient("Fourth", "customer", bankAccount4);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);

        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);
        bankAccounts.add(bankAccount4);

        client1.makeDeposit(1000);
        client2.makeDeposit(2000);
        client3.makeDeposit(3000);
        client4.makeDeposit(4000);

        printInfo(clients);

        for (int iteration = 1; iteration <= 10; iteration++) {
            Employee randomEmployee = employees.get((int)(Math.random() * employees.size()));
            Client randomClient = clients.get((int)(Math.random() * clients.size()));
            BankAccount randomBankAccount = bankAccounts.get((int)(Math.random() * bankAccounts.size()));

            makePayment(randomEmployee, randomClient, randomBankAccount);
            printInfo(clients);;
        }
    }

    private static void makePayment(Employee employee, Client sender, BankAccount recipient){
        employee.acceptPayment(sender.transfer((int)(Math.random() * 500), recipient));
    }

    private static void printInfo(List<Client> clients){
        for (Client client: clients)
            System.out.println(client);
        System.out.println("\n");
    }
}
