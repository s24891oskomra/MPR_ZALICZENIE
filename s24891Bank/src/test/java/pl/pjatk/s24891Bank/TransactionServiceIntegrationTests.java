package pl.pjatk.s24891Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.model.Status;
import pl.pjatk.s24891Bank.model.TransactionInfo;
import pl.pjatk.s24891Bank.service.TransactionService;
import pl.pjatk.s24891Bank.storage.ClientStorage;
import pl.pjatk.s24891Bank.storage.TransactionStorage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TransactionServiceIntegrationTests {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ClientStorage clientStorage;

    @Autowired
    private TransactionStorage transactionStorage;

    @Test
    void isTransactionStoredInStorage() {
        Client client = new Client(50, 1000, true);
        clientStorage.getClients().add(client);

        int currentNumberOfStoredTransactions = transactionStorage.getTransactions().size();
        transactionService.orderTransfer(client.getClientId(), 500);

        assertThat(transactionStorage.getTransactions().size()).isEqualTo(currentNumberOfStoredTransactions + 1);

    }

    @Test
    void orderTransferDeclinedClientNotRegistered() {
        Client client = new Client(51, 1000, false);
        clientStorage.getClients().add(client);

       TransactionInfo testTransaction =  transactionService.orderTransfer(client.getClientId(), 500);

       assertThat(testTransaction).isNotNull();
       assertThat(testTransaction.getStatus()).isEqualTo(Status.DECLINED);
    }

    @Test
    void orderTransferDeclinedClientHasNotEnoughBalance() {
        Client client = new Client(52, 0, false);
        clientStorage.getClients().add(client);

        TransactionInfo testTransaction =  transactionService.orderTransfer(client.getClientId(), 500);

        assertThat(testTransaction.getError()).isEqualTo("not enough balance");
    }

    @Test
    void addMoneyIsValid() {
        Client client = new Client(53, 1000, true);
        clientStorage.getClients().add(client);

        int currentNumberOfStoredTransactions = transactionStorage.getTransactions().size();
        TransactionInfo testTransaction =  transactionService.addMoney(client.getClientId(), 500);

        assertThat(transactionStorage.getTransactions().size()).isEqualTo(currentNumberOfStoredTransactions + 1);
        assertThat(testTransaction.getError()).isEqualTo("");
        assertThat(testTransaction.getAmount()).isEqualTo(1500);
        assertThat(testTransaction.getStatus()).isEqualTo(Status.ACCEPTED);
    }
}
