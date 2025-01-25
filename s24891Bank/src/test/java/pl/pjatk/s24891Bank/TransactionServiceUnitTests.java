package pl.pjatk.s24891Bank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.model.Status;
import pl.pjatk.s24891Bank.model.Transaction;
import pl.pjatk.s24891Bank.model.TransactionInfo;
import pl.pjatk.s24891Bank.service.TransactionService;
import pl.pjatk.s24891Bank.storage.ClientStorage;
import pl.pjatk.s24891Bank.storage.TransactionStorage;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceUnitTests {

    @Mock
    ClientStorage clientStorage;

    @Mock
    TransactionStorage transactionStorage;

    @InjectMocks
    TransactionService transactionService;


    @Test
    void isTransferAccepted() {
        Client client = new Client(30, 500, true);
        Transaction transaction = new Transaction(30, 0, null);

        when(clientStorage.getClientById(anyInt())).thenReturn(Optional.of(client));
        when(transactionStorage.getTransactionById(anyInt())).thenReturn(Optional.of(transaction));


        TransactionInfo testTransaction = transactionService.orderTransfer(client.getClientId(), 500);

        assertThat(testTransaction.getStatus()).isEqualTo(Status.ACCEPTED);

    }
}
