
import java.util.ArrayList;
import java.util.Stack;

public class infixToPostfix {

    static ArrayList<String> list = new ArrayList<String>();
    static char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static String[] operands = {"+", "-", "*", "/", "^"};

    public static boolean isNumber(String c) {
        for (char i : numbers) {
            if (c.charAt(0) == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOperand(String c) {
        for (String i : operands) {
            if (c.equals(i)) {
                return true;
            }
        }
        return false;
    }

    static int Prec(String ch) {
        switch (ch) {
            case "+":
            case "-":
                return 1;

            case "/":
            case "*":
                return 2;

            case "^":

                return 3;
        }
        return -1;
    }

    static ArrayList<String> infixToPostfix(String[] exp) {

        ArrayList<String> result = new ArrayList<>();

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length; ++i) {
            String c = exp[i];

            if (isNumber(exp[i])) {
                result.add(exp[i]); // direk ekledik sayıysa

            } else if (c.equals("(")) {
                stack.push(c);// açık parantez se de direk koyduk en büyük çünkü
            } else if (c.equals(")")) {
                while (!stack.isEmpty() && stack.peek().equals("(")) {

                    result.add(stack.pop()); // eğer kapalı parantez görürse açık parantez görene kadar pop lıyoruz

                }
                
                if(stack.peek().equals("(")){
                    while(stack.peek().equals("(")){
                        stack.pop();
                    }
                }
                
                   result.add(stack.pop()); // elimiz deki elemanı eklemeliyiz...HERŞEYİ SİL BUNU SİLME
                   stack.pop(); // '(' bunuda attık yok ettik
              

            } else // an operator is encountered 
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) { // karşılaşılan operatörlerin derecelerine göre pop ediyoruz

                    result.add(stack.pop());
                }
                stack.push(c); // tamamen boşalttıktan sonra elimizdeki operandı ekliyoruz veya derecesi büyük değilse.

            }

        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

}
