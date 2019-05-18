import java.util.Scanner;
import java.util.Stack;

public class Polka {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] sequence = sc.nextLine().split(" ");

        Stack<Integer> stack = new Stack<>();

        for (String s : sequence){
            if(isDigit(s))
                stack.push(Integer.valueOf(s));
            else
                stack.push(calculate(s, stack.pop(), stack.pop()));
        }

        System.out.println(stack.peek());
    }

    private static int calculate(String operator, int item1, int item2){
        switch (operator){
            case "+":
                return item2 + item1;
            case "−":
            case "-":
                return item2 - item1;
            case "×":
            case "*":
                return item2 * item1;
            case "÷":
            case "/":
                return item2 / item1;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static boolean isDigit(String str){
        return str.matches("[0-9]+");
    }
}
