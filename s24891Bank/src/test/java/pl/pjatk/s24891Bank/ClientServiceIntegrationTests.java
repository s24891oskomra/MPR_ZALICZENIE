package pl.pjatk.s24891Bank;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.service.ClientService;
import pl.pjatk.s24891Bank.storage.ClientStorage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientServiceIntegrationTests {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientStorage clientStorage;


    @Test
    void isClientAddedToStorage() {
        Client client = new Client(9, 0, false);

        Client testClient = clientService.register(client, 500);


        assertThat(clientStorage.getClientById(testClient.getClientId())).isPresent();

    }

    @Test
    void isClientBalanceAndStatusChanged() {
        Client client = new Client(10, 0, false);

        Client testClient = clientService.register(client, 500);

       assertThat(clientStorage.getClient(testClient.getClientId()).getBalance()).isEqualTo(500);
       assertThat(clientStorage.getClient(testClient.getClientId()).isRegistered()).isTrue();
    }

}
