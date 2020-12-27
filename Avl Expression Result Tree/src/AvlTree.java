
import java.util.Scanner;
import java.util.Stack;

public class AvlTree {

    Node root;

    public AvlTree() {
        this.root = null;
    }

    public int getHeight(Node n) {
        if (n == null) {
            return 0;
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

    public void insert(Node key) {
        this.root = insertRecursive(this.root, key);
    }

    private Node insertRecursive(Node current, Node key) {
        if (current == null) {

            return key;
        } else if (current.result > key.result) {
            current.left = insertRecursive(current.left, key);

        } else if (current.result < key.result) {
            current.right = insertRecursive(current.right, key);
        } else {
            return current; // duplicate eleman olmasına izin vermeyip eşitse return liyoruz.
        }
        current.height = 1 + findMax(getHeight(current.left), getHeight(current.right));

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

    public void delete(Node key) {
        this.root = deleteRecursive(this.root, key);
    }

    private Node deleteRecursive(Node current, Node key) {
        if (current == null) {
            return null;
        } else if (current.result > key.result) {
            current.left = deleteRecursive(current.left, key);
        } else if (current.result < key.result) {
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
                Node tmp = min(current.right);

                current.firstElement = tmp.firstElement;
                current.secondElement = tmp.secondElement;
                current.result = tmp.result;
                //buraya bakarak ol
                current.right = deleteRecursive(current.right, tmp);
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

    public Node findelement(Node key) {
        return findNode(this.root, key);
    }

    public Node findNode(Node root, Node key) {

        if (root == null || root.result == key.result) {
            return root;
        }

        if (root.result < key.result) {
            return findNode(root.right, key);
        }

        return findNode(root.left, key);
    }

    public void update(Node eski) {
        Scanner scanner = new Scanner(System.in);
        if (isThere(eski.result)) {

            System.out.println("Güncellenecek düğüm : " + eski.operand + " " + eski.firstElement + " " + eski.secondElement);
            delete(eski);
            System.out.print("Yeni üçlü ifadeyi giriniz : ");
            String exp = scanner.nextLine();
            Stack<Node> st = Main.parsingString(exp);
            while (!st.isEmpty()) {
                insert(st.pop());
            }
            System.out.println("Yeni düğüm eklendi ...Güncel Ağacı Görmek için 3'e basınız . ");
        } else {
            System.out.println("Aranan düğüm ağaçta mevcut değildir...");
        }
    }

    public boolean isThere(double key) {
        return search(this.root, key);

    }

    private boolean search(Node current, double key) {
        if (current == null) {
            return false;
        } else if (current.result > key) {
            return search(current.left, key);
        } else if (current.result < key) {
            return search(current.right, key);
        } else if (current.result == key) {
            return true;
        }
        return false;
    }

    public Node min(Node current) {
        if (current.left == null) {
            return current;
        }
        return min(current.left);

    }

    public void preOrder() {
        preOrderRecursive(root);
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.result + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    public void printTree() {
        System.out.println(root);
    }

}
