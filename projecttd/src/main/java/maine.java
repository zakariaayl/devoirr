
public class maine {

	public static void main(String[] args) {
		
		compte account1 = new compte(101, "Bank A", "Country A", "USD");
        compte account2 = new compte(102, "Bank A", "Country A", "USD");
        compte account3 = new compte(103, "Bank B", "Country B", "EUR");

        // Creation de clients
        client client1 = new client(1, "Alice", "Smith","marrackech","ayougil@gmail.com","060778489");
        client client2 = new client(2, "AYOUGIL", "Zakariae","marrackech","zakaria@gmail.com","060668489");

        // gerer les clients
        gerer_client clientManager = new gerer_client();
        
        // ajout de clients
        clientManager.ajoutClient(client1); // il faut afficher client ajoutee
        clientManager.ajoutClient(client2); // il faut afficher client ajoutee
        clientManager.ajoutClient(client1); // client Alice deja existe
        System.out.println(clientManager.getlist());
        // recherche de clients 
        clientManager.recherche_client(client1); // il faut trouver le client Alice
        clientManager.recherche_client(new client(3, "Charlie", "Brown","marrackech","ayougil@gmail.com","0646689")); // il ne faut pas le trouver

        // creation de compte
        client1.creationCompte(account1); // il faut afficher compte cree avec succes
        client1.creationCompte(account1); // il faut afficher compte deja existe
        client1.creationCompte(account2); // il faut afficher compte cree avec succes

        // recherche du compte
        client1.recherche_comp(account1); // il faut trouver le compte
        client1.recherche_comp(account3); // il ne faut pas le trouve

        // Creation de transactions
        transaction transaction1 = new transaction("TXN001", account1, account2); // VIRIN
        transaction transaction2 = new transaction("TXN002", account1, account3); // VIRMULTA
        transaction transaction3 = new transaction("TXN003", account2, account3); // VIRMULTA
        // ajout de transactions
        account1.ajoutTrans(transaction1); // ajout avec succes
        account1.ajoutTrans(transaction1); // affiche transaction ref deja existe
        account1.ajoutTrans(transaction2); // ajout avec succes

        // recherche de transactions
        account1.recherche_trans(transaction1); // il faut trouver la transaction
        account1.recherche_trans(transaction3); // il ne faut pas trouver la transaction

        // affiche les details du compte et transactions
        System.out.println("Account 1 transactions:");
        for (transaction t : account1.getListe()) {
            System.out.println("Transaction Reference: " + t.getReference() + ", Type: " + t.getType());
        }//affiche les transactions de TXN001 et TXN002

        System.out.println("Account 2 transactions:");
        for (transaction t : account2.getListe()) {
            System.out.println("Transaction Reference: " + t.getReference() + ", Type: " + t.getType());
        }//affiche le compte seulement comme aucune transactions n'est ajoute
    }
	

}
