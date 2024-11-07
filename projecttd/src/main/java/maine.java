import java.util.ArrayList;
import java.util.List;

public class maine {
    public static void main(String[] args) {
        // Create a bank
        List<compte> comptesList = new ArrayList<>();
        banque myBank = new banque(1, "France", comptesList);

        // Create clients
        client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
        client client2 = new client(102, "Jane", "Smith", "456 Street", "jane.smith@example.com", "987654321");

        // Create accounts for each client and add them to the bank
        compte compte1 = new compte(1001, "France", myBank, "EUR");
        compte compte2 = new compte(1002, "France", myBank, "USD");
        

        client1.creationCompte(compte1);  // Add compte1 to client1
        client2.creationCompte(compte2);  // Add compte2 to client2

        // Add accounts to the bank
        myBank.setListc(List.of(compte1, compte2));

        // Display clients' information
        System.out.println("Client 1 Info:");
        System.out.println(client1);
        System.out.println("JSON Representation:");
      System.out.println(client1.toJson());

        System.out.println("\nClient 2 Info:");
        System.out.println(client2);
        System.out.println("JSON Representation:");
        System.out.println(client2.toJson());

        // Create a manager for clients
        gerer_client clientManager = new gerer_client();
        clientManager.ajoutClient(client1);
        clientManager.ajoutClient(client2);

        // Create a transaction and add it to the account
        List<compte> transactionAccounts = new ArrayList<>();
        transactionAccounts.add(compte2);  // Transfer from compte1 to compte2
        transaction trans1 = new transaction("TX123", compte1, transactionAccounts, false);

        // Add the transaction to the account
        compte1.ajoutTrans(trans1);

        // Display the transaction details
        System.out.println("\nTransaction Info:");
        System.out.println(trans1);
        System.out.println("JSON Representation:");
      System.out.println(trans1.toJson());

        // Test search functionality in gerer_client
        System.out.println("\nSearching for Client 1:");
        clientManager.recherche_client(client1);

        System.out.println("\nSearching for a non-existent client:");
        clientManager.recherche_client(new client(999, "Ghost", "Client", "Unknown", "ghost@example.com", "000000000"));

        // Display all clients managed by gerer_client
        System.out.println("\nAll Clients:");
        for (client c : clientManager.getlist()) {
            System.out.println(c);
        }
    }
}
