
import java.util.Stack;

public class ExpressionTree {

    Node root;

    public ExpressionTree() {
        this.root = null;
    }

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
    

    public void inOrder(Node root){
        inorder(root);  
    }
    
    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t);
            inorder(t.right);
        }
    }

    void inorderWithValue(Node t) {
        if (t != null) {
            inorderWithValue(t.left);
            System.out.print(t.value + " ");
            inorderWithValue(t.right);
        }
    }

    Node constructTree(String postfix[]) {
        Stack<Node> st = new Stack<Node>(); // stack e node doldurcaz leaf ten root kuracaz
        Node t, t1, t2;

        for (int i = 0; i < postfix.length; i++) {

            if (!isOperator(postfix[i].charAt(0))) {  // + - / * ^ değilse direk node a çevir pushla
                t = new Node(postfix[i]);
                st.push(t);
            } else // eğer operatörse hemen 3 lü yapıyı oluştur 2 tane pop edip
            {
                t = new Node(postfix[i]); // operatörü node ladık

                t1 = st.pop();
                t2 = st.pop();

                t.right = t1;
                t.left = t2;

                st.push(t);  // tekrar ekledik
            }
        }

        t = st.peek();
        st.pop();

        return t;
    }

    public double toDouble(String s) {

        double a = Double.parseDouble(s);

        return a;

    }

    public double eval(Node root) {
        if (root == null) { //!root ==> root ==null
            return 0; //boşsa diye kontrol ettik

        }
        if (root.left == null && root.right == null) {
            return toDouble(root.value); // leafe denk gelirse toInt
        }
        double l_val = eval(root.left);

        double r_val = eval(root.right);

        if (root.value.equals("+")) {
            return (double) l_val + (double) r_val;
        }
        if (root.value.equals("-")) {
            return (double) l_val - (double) r_val;

        }
        if (root.value.equals("*")) {
            return (double) l_val * (double) r_val;

        }
        if(root.value.equals("/")){
             return (double) l_val / (double) r_val;
        }
        return Math.pow(l_val, r_val);
        
    }

}
