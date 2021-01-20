
public class Customer {
    
   static int totalCustomer =1 ;
    int musteriNo;
    int islemSüresi;
    
    int siraNumarasi;
    int hangiVezne ;

    public Customer(int islemSüresi) {
     
       this.musteriNo = totalCustomer++;
        this.islemSüresi = islemSüresi;
    }
 
}
