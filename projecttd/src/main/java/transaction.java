import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class transaction {
  public enum  type{
	  VIRIN,
	  VIREST,
	  VIRCKA,
	  VIRMULTA
  }
  private type trans_type;
  private Date timestamp;
  private String reference;
  @JsonManagedReference
  compte com1;
  compte com2;
  public transaction( String reference, compte c1,compte c2) {
      if(c1.getbanque().equals(c2.getbanque()) && c1.getpays().equals(c2.getpays())) {
    	   this.trans_type=type.VIRIN;//meme banque meme pays
      }
      if(!(c1.getbanque().equals(c2.getbanque())) && c1.getpays().equals(c2.getpays())) {
   	   this.trans_type=type.VIREST; //meme pays different banque
     }
      if(!(c1.getDevise().equals(c2.getDevise()))) {
    	  this.trans_type=type.VIRMULTA;//different devise 
      }
      
      this.timestamp = new Date();
      this.reference = reference;
      this.com1 = c1;
      this.com2 = c2;
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
  public List<compte> getcompte() {
	  List<compte> l=new ArrayList<>();
	  l.add(com1);
	  l.add(com2);
	  return l;
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

  public void setComptes(compte compte1,compte compte2) {
      this.com1 = compte1;
      this.com1 = compte1;
  }
  @Override
  public String toString() {
      return "Transaction{" +
              "transactionType=" + trans_type +
              ", time=" + timestamp +
              ", reference='" + reference + '\'' +
              ", compte1=" + com1 +","+
              " compte2=" + com2+
              '}';
  }
}
