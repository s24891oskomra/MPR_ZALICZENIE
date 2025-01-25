package pl.pjatk.s24891Bank.model;

public class Client {


    private int clientId;

    private double balance;

    private boolean isRegistered;

    public Client(int clientId, double balance, boolean isRegistered) {
        this.clientId = clientId;
        this.balance = balance;
        this.isRegistered = isRegistered;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "clientId='" + clientId + '\'' +
                "balance='" + balance + '\'' +
                "isRegistered='" + isRegistered + '\'' +
                '}';
    }
}
