package pl.pjatk.s24891Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.pjatk.s24891Bank.model.Client;
import pl.pjatk.s24891Bank.model.TransactionInfo;
import pl.pjatk.s24891Bank.service.ClientService;
import pl.pjatk.s24891Bank.service.TransactionService;
import pl.pjatk.s24891Bank.storage.ClientStorage;
import pl.pjatk.s24891Bank.storage.TransactionStorage;

@SpringBootApplication
public class S24891BankApplication {

	public S24891BankApplication(ClientStorage clientStorage, TransactionStorage transactionStorage) {
		ClientService clientService = new ClientService(clientStorage);
		TransactionService transactionService = new TransactionService(transactionStorage, clientStorage);

		Client client = clientService.register(clientStorage.getClient(1), 500);
		System.out.println(client);

		TransactionInfo transactionInfo = transactionService.orderTransfer(1, 100);
		System.out.println(client);
		System.out.println(transactionInfo);
		transactionService.addMoney(1, 1000);
		System.out.println(client);


		System.out.println(" ");
		TransactionInfo transactionInfo1 = transactionService.addMoney(2, 200);
		System.out.println(transactionInfo1);

		TransactionInfo transactionInfo2 = transactionService.orderTransfer(2, 100);
		System.out.println(transactionInfo2);

	}

	public static void main(String[] args) {
		SpringApplication.run(S24891BankApplication.class, args);
	}

}
