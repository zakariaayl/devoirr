package devoir;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import devoir.banque;
import devoir.client;
import devoir.compte;
import devoir.gerer_client;
import devoir.transaction;
public class test_junit {
@Test
public void test_compte() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	client1.creationCompte(compte1);
	Assert.assertEquals(1,client1.recherche_comp(compte1));

}
@Test
public void test_typeVIRCKA() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	compte compte2 = new compte(1002, "France", myBank, "USD");
	List<compte> transactionAccounts = new ArrayList<>();
    transactionAccounts.add(compte2);  // Transfer from compte1 to compte2
    transaction trans1 = new transaction("TX123", compte1, transactionAccounts, false);
	Assert.assertEquals("VIRCKA", trans1.getType().name());
}
@Test
public void test_typeVIRIN() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	compte compte2 = new compte(1002, "France", myBank, "EUR");
	List<compte> transactionAccounts = new ArrayList<>();
    transactionAccounts.add(compte2);  // Transfer from compte1 to compte2
    transaction trans1 = new transaction("TX123", compte1, transactionAccounts, false);
    System.out.println(trans1.getType());
	Assert.assertEquals("VIRIN", trans1.getType().name());
}
@Test
public void test_typeVIREST() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
    banque Bank2 = new banque(2, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	compte compte2 = new compte(1002, "France", Bank2, "EUR");
	List<compte> transactionAccounts = new ArrayList<>();
    transactionAccounts.add(compte2);  // Transfer from compte1 to compte2
    transaction trans1 = new transaction("TX123", compte1, transactionAccounts, false);
    System.out.println(trans1.getType());
	Assert.assertEquals("VIREST", trans1.getType().name());
}
@Test
public void test_typeVIRCHAK() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
    banque Bank2 = new banque(2, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	compte compte2 = new compte(1002, "France", Bank2, "EUR");
	List<compte> transactionAccounts = new ArrayList<>();
    transactionAccounts.add(compte2);  // Transfer from compte1 to compte2
    transaction trans1 = new transaction("TX123", compte1, transactionAccounts, true);
    System.out.println(trans1.getType());
	Assert.assertEquals("VIRCHAK", trans1.getType().name());
}
@Test
public void test_typeVIRMULTA() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
    banque Bank2 = new banque(2, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	compte compte2 = new compte(1002, "France", Bank2, "EUR");
	compte compte3 = new compte(1003, "Maroc", Bank2, "MAD");
	List<compte> transactionAccounts = new ArrayList<>();
    transactionAccounts.add(compte2);
    transactionAccounts.add(compte3);
    // Transfer from compte1 to compte2
    transaction trans1 = new transaction("TX123", compte1, transactionAccounts, true);
    System.out.println(trans1.getType());
	Assert.assertEquals("VIRMULTA", trans1.getType().name());
}
@Test
public void test_transaction() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	List<compte> comptesList = new ArrayList<>();
    banque myBank = new banque(1, "France", comptesList);
    banque Bank2 = new banque(2, "France", comptesList);
	compte compte1 = new compte(1001, "France", myBank, "EUR");
	compte compte2 = new compte(1002, "France", Bank2, "EUR");
	compte compte3 = new compte(1003, "Maroc", Bank2, "MAD");
	List<compte> transactionAccounts = new ArrayList<>();
    transactionAccounts.add(compte2);
    transactionAccounts.add(compte3);
    // Transfer from compte1 to compte2
    transaction trans1 = new transaction("TX123", compte1, transactionAccounts, true);
    compte1.ajoutTrans(trans1);
	Assert.assertEquals(1,compte1.recherche_trans(trans1));

}
@Test
public void test_client() {
	client client1 = new client(101, "John", "Doe", "123 Avenue", "john.doe@example.com", "123456789");
	gerer_client clientManager = new gerer_client();
    clientManager.ajoutClient(client1);
    System.out.println(clientManager.recherche_client(client1));
	Assert.assertEquals(true,clientManager.recherche_client(client1));

}
//on peut ajouter des autres test

}
