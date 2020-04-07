import java.util.Stack;
import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {

	Stack<Character> stack = new Stack<Character>();
	String str = "String reverse using Stack";

	for(int i=0; i<str.length(); i++)
		stack.push(str.charAt(i));

	while(!stack.empty())
		System.out.print(stack.pop());


	}
}
