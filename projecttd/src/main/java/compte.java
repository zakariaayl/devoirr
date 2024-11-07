import java.util.ArrayList;
import com.google.gson.annotations.Expose;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class compte {
	@Expose
   int num_com;
	@Expose
   Date creat;
	@Expose
   Date update;
	@Expose
   String devise;
   @Expose
   client cl;
   
   @JsonManagedReference
   List<transaction> liste=new ArrayList<transaction>();
   @Expose
   banque banque;
   public compte(int numCom,String pays,banque b, String devise) {
       this.num_com = numCom;
       this.devise = devise;
       this.creat = new Date(); 
       this.update = new Date();
       this.banque=b;
   }
   public banque getbanque() {
	   return banque; 
   }
   
   public void setbanque(banque b) {
	   this.banque=b; 
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
   public void setCreationDate(Date creationDate) {
       this.creat = creationDate;
   }

   public void setUpdateDate(Date updateDate) {
       this.update = updateDate;
   }

   public void setDevise(String devise) {
       this.devise = devise;
   }
   public int recherche_trans(transaction t1) {
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
	        return 0;//non trouve
	    }
	    return 1;//trouve
	}
   @Override
   public String toString() {
       return "Compte{" +
               "numCom=" + num_com +
               ", creat=" + creat +
               ", up=" + update +
               ", devise=" + devise +
               
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
public String toJson() {
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .create();
    return gson.toJson(this);
}


}
