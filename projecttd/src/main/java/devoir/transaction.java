package devoir;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class transaction {

  public enum  type{
	  VIRIN,
	  VIREST,
	  VIRCKA,
	  VIRMULTA,
	  VIRCHAK
  }
	@Expose
  private type trans_type;
	@Expose
  private Date timestamp;
	@Expose
  private String reference;
	@Expose
  private boolean ischeck;
	@Expose
  compte com1;

  @JsonManagedReference
 
  List<compte> list;
  public transaction( String reference, compte c1,List<compte> comptes,boolean ischeck ) {
	  this.trans_type=type.VIREST;
	  if(ischeck) {
		  this.ischeck=ischeck;
		  this.trans_type=type.VIRCHAK;
	  }
	  
      if(comptes.size()!=1) this.trans_type=type.VIRMULTA;
      else {
    	  if(c1.getbanque().getId() == comptes.get(0).getbanque().getId() && c1.getbanque().getPays().equals(comptes.get(0).getbanque().getPays())) {
    		  this.trans_type=type.VIRIN;
    	  }
    	  if(!c1.getDevise().equals(comptes.get(0).getDevise())) {
    		  this.trans_type=type.VIRCKA;
    	  }
    	  
      }
      
      this.timestamp = new Date();
      this.reference = reference;
      this.com1 = c1;
     this.list=new ArrayList<>();
     this.ischeck=ischeck;
  }
  public type getType() {
      return trans_type;
  }
 
  public Date getTime() {
      return timestamp;
  }

  public String getReference() {
      return reference;
  }
  public List<compte> getcomptes() {
	 return this.list;
  }
 

  // Setters
  public void setTransactionType(type t1) {
      this.trans_type = t1;
  }

  public void setTime(Date time) {
      this.timestamp = time;
  }

  public void setReference(String reference) {
      this.reference = reference;
  }

  public void setComptes(compte compte1,List<compte> comptes) {
      this.com1 = compte1;
      this.list = comptes;
  }
  @Override
  public String toString() {
      return "Transaction{" +
              "transactionType=" + trans_type +
              ", time=" + timestamp +
              ", reference='" + reference + '\'' +
              ", compte1=" + com1 +","+
              " compte2=" + list+
    
              '}';
  }
  public String toJson() {
      Gson gson = new GsonBuilder()
              .setPrettyPrinting()
              .excludeFieldsWithoutExposeAnnotation()
              .create();
      return gson.toJson(this);
  }

 
}
