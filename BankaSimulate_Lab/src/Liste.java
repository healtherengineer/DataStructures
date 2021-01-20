
public class Liste {

    Node first;

    public Liste() {
        this.first = null;
    }

    public void add(Customer a) {

        Node n = new Node(a);
        if (this.first == null) {
            this.first = n;
        } else {

            // eğer temp e atmayıp this.first üstünden gidersek geriye dönemeyeceğimizden 
            // listeyi kaybederiz ve garbage collector da zamanla listedeki elemanları yok eder.
            if (this.first.customer.islemSüresi > n.customer.islemSüresi) {
                // first den büyük mü küçük mü diye kontrol ettik ve tak yapıştırdık firstten küçükse hemen first ü değiştirdik
                n.next = this.first;
                this.first = n;
            } else {
                Node tmp = this.first;
                // first daha küçükse firstten başlayıp tek tek yer gezdik  
                while (tmp.next != null && tmp.next.customer.islemSüresi < n.customer.islemSüresi) {
                    tmp = tmp.next;

                }

                n.next = tmp.next;// tmp.next bu satırda null veya yıl olarak büyük  
                tmp.next = n; // tmp.next artık n i gösteriyor n de null u veya daha önce tmp nin gösterdiğini .

            }
            // en null değeri bulunduğunda tmp.next e n i yani yeni eklenecek arabayı ekleriz .
            // yeni arabayı bir node olarak eklediğimiz için en sona ekleneceğinden ondan önceki node un next'i 
            // bu yeni arabayı gösterir .
            // bu yüzden node ın next ini null a eşitleriz (this.next =  null) yapmamızın sebebi 

        }

    }
  

}
