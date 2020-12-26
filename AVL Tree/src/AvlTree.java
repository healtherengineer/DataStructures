
import javax.swing.Spring;

public class AvlTree {

    Node root;

    public AvlTree() {
        this.root = null;
    }

    public int getHeight(Node n) {
        if (n == null) {
            return 0;// if the object is null ,then height of that is zero (0)
        }
        return n.height;
    }

    public int findMax(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node rightRotate(Node A) {
        Node B = A.left;
        Node t = B.right;

        B.right = A;
        A.left = t;
        // update degrees 
        A.height = 1 + findMax(getHeight(A.right), getHeight(A.left));
        B.height = 1 + findMax(getHeight(B.right), getHeight(B.left));
        return B;

    }

    public Node leftRotate(Node A) {

        Node B = A.right;
        Node t = B.left;

        B.left = A;
        A.right = t;
        //update degrees 
        A.height = 1 + findMax(getHeight(A.right), getHeight(A.left));
        B.height = 1 + findMax(getHeight(B.right), getHeight(B.left));
        return B;

    }

    public int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return getHeight(n.left) - getHeight(n.right);

    }

    public void insert(int key) {
        this.root = insertRecursive(this.root, key);
    }

    private Node insertRecursive(Node current, int key) {
        if (current == null) {
//            Node c = new Node(key);
//            return c;
            return (new Node(key));
        } else if (current.key > key) {
            current.left = insertRecursive(current.left, key);

        } else if (current.key < key) {
            current.right = insertRecursive(current.right, key);
        } else {
            return current; // duplicate eleman olmasına izin vermeyip eşitse return liyoruz.
        }
        current.height = 1 + findMax(getHeight(current.left), getHeight(current.right));
        // şu gelen 1 kendiliğinden olan bir olduğu için ve eklediğimizin direk height ini güncelledik 

        // şimdi sıra balance ları kontrol etmede rotate edilecek bir durum var mı onu öngörmemiz gerekli
        int balance = getBalance(current);

        if (balance > 1) {
            int subBalance = getBalance(current.left);
            if (subBalance >= 0) {
                //2 ,{1,0} 2 ,0 durumunda current.left bir leaf yapısında olabilir.(balance'ı 0 olabilir)
                return rightRotate(current);
            }

            if (subBalance < 0) {
                //2,-1
                current.left = leftRotate(current.left);
                return rightRotate(current);
            }

        } else if (balance < -1) {
            int subBalance = getBalance(current.right);
            if (subBalance > 0) {
                //-2 ,1
                current.right = rightRotate(current.right);
                return leftRotate(current);

            }
            if (subBalance <= 0) {
                //-2 ,{-1,0} -2 ,0 durumunda current.right bir leaf yapısında olabilir.
                return leftRotate(current);
            }
        }

        return current;
    }

    public void delete(int key) {
        this.root = deleteRecursive(this.root, key);
    }

    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        } else if (current.key > key) {
            current.left = deleteRecursive(current.left, key);
        } else if (current.key < key) {
            current.right = deleteRecursive(current.right, key);
        } else {
            // Node is same with current
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                int min = min(current.right);
                current.key = min;
                current.right = deleteRecursive(current.right, min);
            }
        }

        // update heights 
        current.height = 1 + findMax(getHeight(current.right), getHeight(current.left));

        int balance = getBalance(current);

        if (balance >= 1) {
            int subBalance = getBalance(current.left);
            if (subBalance >= 0) {
                //2,{1,0} 
                return rightRotate(current);
            } else if (subBalance < 0) {
                //2 , -1
                current.left = leftRotate(current.left);
                return rightRotate(current);
            }
        } else if (balance < -1) {
            int subBalance = getBalance(current.right);
            if (subBalance > 0) {
                // -2 ,1
                current.right = rightRotate(current.right);
                return leftRotate(current);
            } else if (subBalance <= 0) {
                //-2 ,-1,0
                return leftRotate(current);
            }
        }
        return current;

    }
    public boolean  isThere(int key){
        return search(this.root , key);  
        
    }
    private boolean search(Node current , int key){
        if(current == null ){
            return false;
        }
        else if(current.key > key){
           return search(current.left , key);
        }
        else if(current.key < key){
           return search(current.right, key);
        }
        else if(current.key == key){
            return true;
        }    
        return false;
    }

    public int min(Node current) {
        if (current.left == null) {
            return current.key;
        }
        return min(current.left);

    }

    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void printTree() {
        System.out.println(root);
    }

}
