import java.util.List;

public class Account {
    String accountNumber;
    Double balance;

    public Account(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public Double getBalance() {
        return balance;
    }

    public boolean withdraw(Double amount) {
        if (amount > balance) {
            return false;
        }
        balance = balance-amount;
        return true;
    }

    void deposit(Double amount) {
        balance+=amount;
    }
}
