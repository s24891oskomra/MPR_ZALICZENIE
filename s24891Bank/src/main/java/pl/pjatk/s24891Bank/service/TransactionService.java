package pl.pjatk.s24891Bank.service;

import org.springframework.stereotype.Service;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.model.Status;
import pl.pjatk.s24891Bank.model.TransactionInfo;
import pl.pjatk.s24891Bank.model.Transaction;
import pl.pjatk.s24891Bank.storage.ClientStorage;
import pl.pjatk.s24891Bank.storage.TransactionStorage;

@Service
public class TransactionService {

    private final TransactionStorage transactionStorage;

    private final ClientStorage clientStorage;

    public TransactionService(TransactionStorage transactionStorage, ClientStorage clientStorage) {
        this.transactionStorage = transactionStorage;
        this.clientStorage = clientStorage;
    }


    public TransactionInfo orderTransfer(int clientId, double transferAmount) {
        Client client = clientStorage.getClient(clientId);
        TransactionInfo transactionInfo = new TransactionInfo(0, null, "");

        if (client.getBalance() - transferAmount > 0 && client.isRegistered()) {

            client.setBalance(client.getBalance() - transferAmount);
            clientStorage.getClients().add(client);
            transactionStorage.getTransactions().add(new Transaction(transactionStorage.getTransactions().size() + 1, transferAmount, Status.ACCEPTED));

            transactionInfo.setAmount(client.getBalance());
            transactionInfo.setStatus(Status.ACCEPTED);
        } else {

            String error = client.getBalance() - transferAmount < 0 ? "not enough balance" : "client is not registered";
            transactionInfo.setError(error);
            transactionInfo.setAmount(client.getBalance());
            transactionInfo.setStatus(Status.DECLINED);
        }

        return transactionInfo;
    }


    public TransactionInfo addMoney(int clientId, double transferAmount) {
        Client client = clientStorage.getClient(clientId);
        TransactionInfo transactionInfo = new TransactionInfo(0, null, "");

        if (client.isRegistered()) {
            client.setBalance(client.getBalance() + transferAmount);
            clientStorage.getClients().add(client);
            transactionStorage.getTransactions().add(new Transaction(transactionStorage.getTransactions().size() + 1, transferAmount, Status.ACCEPTED));

            transactionInfo.setAmount(client.getBalance());
            transactionInfo.setStatus(Status.ACCEPTED);
        } else {
            transactionInfo.setAmount(client.getBalance());
            transactionInfo.setStatus(Status.DECLINED);
            transactionInfo.setError("client is not registered");
        }

        return transactionInfo;
    }


}




