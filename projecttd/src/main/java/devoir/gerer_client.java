package devoir;
import java.util.ArrayList;
import java.util.List;
//on peut pas creer ces methodes dans banque car la banque n'est pas liee directement a client ,alors qu'on doit creer une list de clients
public class gerer_client {
 

	private List<client> listc=new ArrayList<client>();
	public void ajoutClient(client c1) {
		for(client cl:listc) {
			if(cl.getNumCli()==c1.getNumCli()) {
				System.out.println("client "+c1.getNom()+" deja existe");
				return;//pour arreter le recherche et ne pas ajouter le client
			}
				
			
		}
		listc.add(c1);
		System.out.println("client ajoutee");
	}
	public boolean recherche_client(client c1) {
        boolean existe = false;
        for (client cl : listc) {
            if (cl.getNumCli() == c1.getNumCli()) {
                System.out.println("le client est bien trouve " + cl);
                existe = true;
                break;//arreter le recherche
            }
        }
        if (!existe) {
            System.out.println("client n'est pas trouve");
            return false;
        }
        return true;
    }
	public List<client> getlist(){
		return listc;
	}
  
}
