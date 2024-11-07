import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
public class client {
@Expose
  String nom,prenom,adresse,phone,email;
@Expose
  int numcli;
client(int num,String nom,String pre,String adresse,String email,String phone){
	  this.numcli=num;
	  this.nom=nom;
	  this.prenom=pre;
	  this.email=email;
	  this.phone=phone;
	  this.adresse=adresse;
  }
@Expose
  @JsonManagedReference 
  List<compte> liste=new ArrayList<>();
  public String getNom() {
      return nom;
  }

  public String getPrenom() {
      return prenom;
  }

  public String getAdresse() {
      return adresse;
  }

  public String getPhone() {
      return phone;
  }

  public String getEmail() {
      return email;
  }

  public int getNumCli() {
      return numcli;
  }
  @Override
  public String toString() {
	  return "Client{" +
              "nom='" + nom + '\'' +
              ", prenom='" + prenom + '\'' +
              ", adresse='" + adresse + '\'' +
              ", phone='" + phone + '\'' +
              ", email='" + email + '\'' +
              ", numCli=" + numcli +
              '}';
  }
   public void creationCompte(compte com) {
	  for (compte c1:liste) {
          if (c1.getNumCom() == com.getNumCom()) {
             System.out.println("compte deja existe");
             return;
          }
          
      }
	  com.getbanque().crea_compte(com);
	  liste.add(com);
	  System.out.println("compte cree avec succes");
   }
   public int recherche_comp(compte com) {
	    boolean existe = false;
	    for (compte c1 : liste) {
	        if (c1.getNumCom() == com.getNumCom()) {
	            System.out.println("compte existe");
	            existe = true;
	            break;
	        }
	    }
	    if (!existe) {
	        System.out.println("compte n'existe pas");
	        return 0;
	    }
	    return 1;//j'ai met pour la tester
	
      }
   public String toJson() {
       Gson gson = new GsonBuilder()
               .setPrettyPrinting()
               .excludeFieldsWithoutExposeAnnotation()
               .create();
       return gson.toJson(this);
   }
	  
}