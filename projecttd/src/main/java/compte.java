import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
public class compte {
   int num_com;
   Date creat;
   Date update;
   String devise;
   String banque;//pour gestion de type
   String pays;//aussi pour gestion de type ,on peut gerer les pays a partir de devise mais il existe des pays de meme devise
   @JsonManagedReference
   List<transaction> liste=new ArrayList<transaction>();
   public compte(int numCom,String pays,String banque, String devise) {
       this.num_com = numCom;
       this.devise = devise;
       this.creat = new Date(); 
       this.update = new Date();
       this.pays=pays;
       this.banque=banque;
   }
   public String getbanque() {
       return banque;
   }
   public String getpays() {
       return pays;
   }
   
   public int getNumCom() {
       return num_com;
   }

   public Date getCreationDate() {
       return creat;
   }

   public Date getUpdateDate() {
       return update;
   }

   public String getDevise() {
       return devise;
   }

   // Setters
   public void setNumCom(int numCom) {
       this.num_com = numCom;
   }
   public void setbanque(String banque) {
       this.banque=banque;
   }
   public void setpays(String pays) {
       this.pays=pays;
   }
   public void setCreationDate(Date creationDate) {
       this.creat = creationDate;
   }

   public void setUpdateDate(Date updateDate) {
       this.update = updateDate;
   }

   public void setDevise(String devise) {
       this.devise = devise;
   }
   public void recherche_trans(transaction t1) {
	    boolean trouve = false;
	    for (transaction tm : liste) {
	        if (t1.getReference().equals(tm.getReference())) {
	            System.out.println("transaction trouve");
	            trouve = true;
	            break;
	        }
	    }
	    if (!trouve) {
	        System.out.println("transaction non trouve");
	    }
	}
   @Override
   public String toString() {
       return "Compte{" +
               "numCom=" + num_com +
               ", creat=" + creat +
               ", up=" + update +
               ", devise=" + devise +
               ", transactions=" + liste +
               '}';
   }
public void ajoutTrans(transaction tr1) {
	for(transaction cl:liste) {
		if(cl.getReference().equals(tr1.getReference())) {
			System.out.println("transation"+cl.getReference()+"deja exist");//test si la transaction existe ou non
			return;
		}
	}
	liste.add(tr1);
	System.out.println("transaction ajoute");
}

public List<transaction> getListe() {
	return liste;
}
}
