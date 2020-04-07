import java.util.Scanner;
import java.io.PrintStream;
import java.util.Scanner;

interface Stack{
	boolean isEmpty();
	boolean isFull();
	void push(char item);
	char pop();
}

public class Palindrome implements Stack{
	
	private int top;
	private int stackSize;
	private char itemArray[];
	
	public Palindrome(int stackSize){
		top = -1;
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize];
	}

	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == this.stackSize-1);
	}
	
	public void push(char item){
		if(isFull()){
			System.out.println("꽉찼습니다.");
		}else{
			itemArray[++top] = item;
			System.out.println("Inserted Item : " + item);
		}
	}
	
	public char pop(){
		if(isEmpty()){
			System.out.println("비었습니다.");
			return 0;
		}else{
			return itemArray[top--];
		}
	}
}