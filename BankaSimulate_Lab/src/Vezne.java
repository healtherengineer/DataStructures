
public class Vezne {
  
    Kuyruk kuyruk = new Kuyruk(10) ;
    int anlikIslemSuresi ;
    static int kapasite = 100 ;
    boolean vezneFull;
    public Vezne() {
        this.anlikIslemSuresi =this.kuyruk.totalSure;
        vezneFull = false;
        
    }
    public int  vezneYeEkle(Customer c){
        if(c.islemSüresi + this.kuyruk.totalSure > kapasite){
            System.out.println("Tüm Veznelerimiz Doludur. Lütfen Veznelerin boşalmasını bekleyiniz ...");   
            return 0;
        }
        else{
             this.kuyruk.insert(c);
        this.anlikIslemSuresi = this.kuyruk.totalSure;
        return 1 ;
        }
       
    }
  
    
    public boolean isFull(){
      if(this.kuyruk.totalSure >= kapasite){
          vezneFull = true;
          return vezneFull;
      }
      return vezneFull;
    }
    public void printKuyruk(){
        this.kuyruk.print();
    }
  
}
