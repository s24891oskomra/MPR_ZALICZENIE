package pl.pjatk.s24891Bank.model;

public class Transaction {

    private int transactionId;

    private double amount;

    private Status status;

    public Transaction(int transactionId, double amount, Status status) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.status = status;
    }


    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
