
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AvlTree tree = new AvlTree();

        String menu = "------------AVL Tree 'ye Hos geldiniz-------------"
                + "\n1-Üçlü Ifade Ekle . Örnek : {(-,11,5),(/,90,5),(+,3,8),(*,6,11)}"
                + "\n2-Düğüm Güncelle."
                + "\n3-Ağaç Yapısını Yazdır."
                + "\nq-Çıkış için q'ya Basınız.";
        while (true) {
            System.out.println(menu);
            String choice;
            System.out.print("İşlem giriniz : ");
            choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("1")) {
                System.out.print("Üçlü ifade giriniz : ");
                String exp = scanner.nextLine();
                Stack<Node> temp = parsingString(exp);
                Stack<Node> stack = new Stack<>();
                while (!temp.isEmpty()) {
                    stack.push(temp.pop());
                }

                while (!stack.isEmpty()) {
                    tree.insert(stack.pop());
                }
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.println("Eskü düğüm üçlülerini konsoldan okuyabilirsiniz .");
                System.out.println("Güncellenecek düğümün üçlüsünü  giriniz : ");
                String exp1 = scanner.nextLine();
                Stack<Node> st1 = parsingString(exp1);
                tree.update(st1.pop());

            } else if (choice.equalsIgnoreCase("3")) {
                tree.printTree();
            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("Programdan çıkılıyor ... Tekrar bekleriz...");
                return;
            } else {
                System.out.println("Yanlış bir işlem girdiniz . Lütfen tekrar deneyiniz .");
            }

        }

    }

    public static Stack<Node> parsingString(String expression) {
        String[] out = null;
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                String temp = "";
                i++;
                while (expression.charAt(i) != ')') {
                    temp += expression.charAt(i);
                    i++;
                }
                out = temp.split(",");
                Node tmp = new Node(out[0], out[1], out[2]);
                stack.push(tmp);
            }
        }
        return stack;
    }

}
