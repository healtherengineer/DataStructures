
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String info = "Please Type correct expression . Ex:(3+4)/(12+6)*5";
        System.out.println(info);
        System.out.print("Type infix : ");
        String exp = scanner.nextLine();
        infixToPostfix convert = new infixToPostfix();
        System.out.println("Infix   : " + exp);
        String[] outs = exp.split("(?<=[-+*/\\(\\)])|(?=[-+*/\\(\\)])");

        ArrayList<String> postsplit = new ArrayList<>();
        postsplit = infixToPostfix.infixToPostfix(outs);

        String[] post = new String[postsplit.size()];
        for (int i = 0; i < postsplit.size(); i++) {

            post[i] = postsplit.get(i);

        }

        System.out.print("Postfix :");
        for (int i = 0; i < post.length; i++) {
            System.out.print(post[i]);
        }

        ExpressionTree tree = new ExpressionTree();
        Node root = tree.constructTree(post);
        System.out.println("\nBinary tree display:");
        tree.inorder(root);
        System.out.println("\nInfix using inorder method in binary tree : ");
        tree.inorderWithValue(root);
        double result = tree.eval(root);
        System.out.println("\nResult : " + result);

    }

}
