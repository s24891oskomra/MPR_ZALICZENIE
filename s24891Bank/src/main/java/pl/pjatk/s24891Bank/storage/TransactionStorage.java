package pl.pjatk.s24891Bank.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.s24891Bank.model.Transaction;


import java.util.ArrayList;
import java.util.Optional;

@Component
public class TransactionStorage {

    private ArrayList<Transaction> transactions = new ArrayList<>();


    public Optional<Transaction> getTransactionById(int id) {
        return getTransactions().stream()
                .filter(storage -> storage.getTransactionId() == id)
                .findFirst();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
