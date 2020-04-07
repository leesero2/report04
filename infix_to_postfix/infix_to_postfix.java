import java.util.Scanner;
import java.util.Stack;

public class infix_to_postfix {
	public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String s;

            System.out.println("중위식 계산식을 쓰시오.");
            s = sc.nextLine();

            System.out.println("후위표현식:" + changePostfix(s));
    }
	
	private static int operatorPriority(char operator) {
        if(operator == '(') return 0;
        if(operator == '+' || operator == '-') return 1;
        if(operator == '*' || operator == '/') return 2;
        return 3;
    }
 
    public static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    public static boolean isChar(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z')|| (ch >= 'a' && ch <= 'z');
    }
   
    public static String changePostfix(String s){
        char[] exp;
        char ch;
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                while((ch = (Character)stack.pop()) != '(') {
                    sb.append(ch);
                    sb.append(' ');
                }
            } else if(isOperator(s.charAt(i))) { 
                while(!stack.isEmpty() && operatorPriority((Character)stack.peek()) >= operatorPriority(s.charAt(i))) {
                    sb.append(stack.pop());
                    sb.append(' ');
                }
                stack.push(s.charAt(i));
            } else if(isChar(s.charAt(i))) {
                do {
                    sb.append(s.charAt(i++));
                } while(i<s.length() && isChar(s.charAt(i)));
                sb.append(' '); i--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
            sb.append(' ');
        }
        return sb.toString();
    }
}