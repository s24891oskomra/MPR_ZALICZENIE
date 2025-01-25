package pl.pjatk.s24891Bank.service;

import org.springframework.stereotype.Service;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.storage.ClientStorage;

@Service
public class ClientService {

    private final ClientStorage clientStorage;

    public ClientService(ClientStorage clientStorage) {
        this.clientStorage = clientStorage;
    }


    public Client register(Client client, double balance){
        client.setBalance(balance);
        client.setRegistered(true);

        if(clientStorage.getClientById(client.getClientId()).isEmpty()) {
            clientStorage.getClients().add(client);
        }

        return client;
    }
}
