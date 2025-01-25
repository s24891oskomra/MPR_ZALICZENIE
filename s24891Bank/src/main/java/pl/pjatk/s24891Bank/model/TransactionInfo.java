package pl.pjatk.s24891Bank.model;

public class TransactionInfo {

    private double amount;

    private Status status;

    private String error;

    public TransactionInfo(double balance, Status status, String error) {
        this.amount = balance;
        this.status = status;
        this.error = error;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double balance) {
        this.amount = balance;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "TransactionInfo{" +
                "amount='" + amount + '\'' +
                "status='" + status + '\'' +
                "error='" + error + '\'' +
                '}';
    }
}
