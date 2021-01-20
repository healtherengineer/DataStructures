
public class Node {
 Node next ;
 Customer customer ; 

    public Node(Customer c) {
     this.customer = c ;
     this.next = null ;
     
    }
// çok önemli bir kod
 @Override
  public boolean equals(Object o){
           return this.customer.equals(o);
    }
}
