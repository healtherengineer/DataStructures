
public class Liste {

    Node first;
    Node last;

    public Liste() {
        this.first = null;
        this.last = null;
    }

    public void basaEkle(Araba a) {

        Node n = new Node(a);
        if (this.first == null) {

            this.last = n;
        } else {
            this.first.prev = n; //first ün öncesine ekleriz zaten başa eklediğimiz için eklenenin prev i null dır nexti ise bir sonraki satırda
            n.next = this.first; // burda işteee next'i first olacak

        }
        this.first = n; // yeni first te n olacağından okeyy.. başa ekledik

    }

    public void sonaEkle(Araba a) {
        Node n = new Node(a);

        if (this.first == null) {
            this.first = n;
        } else {
            n.prev = this.last; // yeni ekleyeceğin sonda olacağı için prev i eski last i göstercek
            this.last.next = n;
        }
        this.last = n; // en sonda yeni last n yani n objesi olacak !!!

    }

    public void sonrasinaEkle(Node s, Araba a) {
        Node n = new Node(a);
        if (s == null) {
            this.basaEkle(a);

        } else if (s == this.last) {
            this.sonaEkle(a);
        } else {
            s.next.prev = n; // (s = önüne eklenecek olanın) s'in next'inin previ yeni olacak araya girmiş olacak .
            n.prev = s; // n in previ s 'i gösterecek
            n.next = s.next;// n 'in nexti s'in nextini göstererek araya girmeye devam ediyor.
            s.next = n;// artık herşey tamam son bağlantı s'in yeni nexti n olur
        }

    }

    public void siraliEkle(Araba a) {
        Node n = new Node(a);
        if (this.first == null) {
            this.basaEkle(a);
        } else if (this.first.araba.yil > n.araba.yil) {
            n.next = this.first;
            this.first = n;
        } else {
            Node current = this.first;
            while (current.next != null && current.next.araba.yil < n.araba.yil) {
                current = current.next;
            }
            this.sonrasinaEkle(current, a);
//            n.next = current.next;
//            current.next = n;
//             if(current== this.last){
//                 this.last = n ;
//             }
        }

    }

    public void add(Araba a) {

        Node n = new Node(a);
        if (this.first == null) {
            this.first = n;
        } else {

            if (this.first.araba.yil > n.araba.yil) {

                n.next = this.first;
                this.first = n;
            } else {
                Node tmp = this.first;

                while (tmp.next != null && tmp.next.araba.yil < n.araba.yil) {
                    tmp = tmp.next;

                }

                n.next = tmp.next;
                tmp.next = n;

            }

        }

    }

    public void print() {
        Node tmp = this.first;
        while (tmp != null) {

            System.out.print(tmp.araba + "->");
            tmp = tmp.next;
        }
        System.out.println("");
    }

    public void printReverse() {
        Node tmp = this.last;
        while (tmp != null) {

            System.out.print(tmp.araba + "->");
            tmp = tmp.prev;
        }
        System.out.println("");
    }

}
