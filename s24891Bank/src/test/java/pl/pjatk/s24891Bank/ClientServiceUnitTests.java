package pl.pjatk.s24891Bank;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.service.ClientService;
import pl.pjatk.s24891Bank.storage.ClientStorage;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceUnitTests {

    @Mock
    ClientStorage clientStorage;

    @InjectMocks
    ClientService clientService;


    @Test
    void isClientRegistered() {
        Client client = new Client(20, 0, false);

        when(clientStorage.getClientById(anyInt())).thenReturn(Optional.of(client));

        Client testClient = clientService.register(client, 500);

        assertThat(testClient.isRegistered()).isTrue();
    }

    @Test
    void isClientBalanceSet() {
        Client client = new Client(21, 0, false);

        when(clientStorage.getClientById(anyInt())).thenReturn(Optional.of(client));

        Client testClient = clientService.register(client, 500);

        assertThat(testClient.getBalance()).isEqualTo(500);
    }



}
