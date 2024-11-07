package devoir;
import java.util.ArrayList;
import java.util.List;

public class banque {
   private int id;
   private String pays;
   List<compte> listc =new ArrayList<>();
   banque(int id,String pays,List<compte> listc ){
	   this.id=id;
	   this.pays=pays;
	   this.listc=listc;
   }
   
   public int getId() {
       return id;
   }
   public void setId(int id) {
       this.id = id;
   }
   public String getPays() {
       return pays;
   }
   public void setPays(String pays) {
       this.pays = pays;
   }
   public List<compte> getListc() {
       return listc;
   }
   public void setListc(List<compte> listc) {
       this.listc = listc;
   }
   @Override
   public boolean equals(Object o) {//comparaison par les ids
	   if(this == o) return true;
	   if(o == null || o.getClass()==this.getClass()) return false;
	   banque b=(banque)o;
	   return b.getId() ==this.getId();
	   }
   public void crea_compte(compte com) {//cette methode est appele quand on cree le compte dans e clients
		  listc.add(com);
		  System.out.println("compte cree avec succes dans la banque");
	   
   }
   
   
}

