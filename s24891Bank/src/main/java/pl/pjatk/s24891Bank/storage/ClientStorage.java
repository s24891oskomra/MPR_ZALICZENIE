package pl.pjatk.s24891Bank.storage;

import org.springframework.stereotype.Component;
import pl.pjatk.s24891Bank.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClientStorage {

    private ArrayList<Client> clients = new ArrayList<>(List.of(
            new Client(1, 0, false),
            new Client(2, 0, false),
            new Client(3, 0, false)
    ));

    public Optional<Client> getClientById(int id) {
        return getClients().stream()
                .filter(storage -> storage.getClientId() == id)
                .findFirst();
    }

    public Client getClient(int id) {
        for (Client client : clients) {
            if (client.getClientId() == id) {
                return client;
            }
        }
        return null;
    }


    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clientList) {
        this.clients = clientList;
    }
}
