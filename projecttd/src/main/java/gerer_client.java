import java.util.ArrayList;
import java.util.List;

public class gerer_client {
 

	private List<client> listc=new ArrayList<client>();
	public void ajoutClient(client c1) {
		for(client cl:listc) {
			if(cl.getNumCli()==c1.getNumCli()) {
				System.out.println("client "+c1.getNom()+" deja existe");
				return;
			}
				
			
		}
		listc.add(c1);
		System.out.println("client ajoutee");
	}
	public void recherche_client(client c1) {
        boolean found = false;
        for (client cl : listc) {
            if (cl.getNumCli() == c1.getNumCli()) {
                System.out.println("le client est bien trouve " + cl);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("client n'est pas trouve");
        }
    }
	public List<client> getlist(){
		return listc;
	}
  
}
