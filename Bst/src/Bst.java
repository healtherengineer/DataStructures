
public class Bst {

    Node root;

    public Bst() {
        this.root = null;
    }

    public void insert(int data) {

        this.root = insertRecursive(this.root, data);
    }

    private Node insertRecursive(Node current, int data) {

        if (current == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (current.key > data) {
            current.left = insertRecursive(current.left, data);
        } else if (current.key < data) {
            current.right = insertRecursive(current.right, data);
        }
        return current; // eşit se direk kendisini döner . yani current.key == data ise direk olduğu düğümü döner // aynı değer eşitlenir.

    }

    public Node search(int data) {
        return this.searchRecursive(this.root, data); // tetikleme sinyali gibi tetikliyor bırakıyor 

    }

    private Node searchRecursive(Node current, int data) {

        if (current == null || current.key == data) {
            return current; // boşsa veya gelen current ın keyine eşitse current ı bulmuştur döndürür ,
            // hiç bulamayıp null a kadar geldiyse null döndürür yoktur .Null demek boş demektir yani 
            // Null = yuvarlak key 'i olmayan boş bir node dur.
        }

        if (current.key > data) {
            return searchRecursive(current.left, data);  //eğer data küçükse root.key tan sola gidiyoruz ve yeni root = root.left oluyor
        } else {
            return searchRecursive(current.right, data);// eğer data büyükse root.key den sağa gidiyoruz yeniRoot = root.right oluyor
        }

    }

    public void delete(int a) {
        this.root = deleteRecursive(this.root, a);
    }

    private Node deleteRecursive(Node current, int a) {

        if (current == null) {
            return null;
        }
        if (current.key == a) {

            if (current.left == null && current.right == null) {
                return null;  // cut the leaf ;)
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {

                int min = getMin(current.right);
                current.key = min;
                current.right = deleteRecursive(current.right, min); // delete minimum on the right side of the founded root that has key that has a value;
            }

        }

        if (current.key > a) {
            current.left = deleteRecursive(current.left, a);
        } else {
            current.right = deleteRecursive(current.right, a);
        }

        return current; // searched value does not exist in this binary treee

    }

    public int getMax(Node current) {
        if (current.right == null) {
            return current.key;
        }
        return getMax(current.right);

    }

    public int getMin(Node current) {
        if (current.left == null) {
            return current.key;
        }
        return getMin(current.left);
    }

    public void printTree() {
        System.out.println(this.root);
    }

}
