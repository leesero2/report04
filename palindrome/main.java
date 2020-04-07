import java.util.Scanner;

public class main{
	public static void main(String args[]) {
	String a;
	Scanner in = new Scanner(System.in);
	boolean s = true;
	a = in.nextLine();
	
	while (!a.equals("q")) {
		char[] array = a.toCharArray();
		Palindrome b = new Palindrome(a.length());
		
		for (int i = 0; i < array.length / 2; i++) {
			b.push(array[i]);
		}

		if (a.length() % 2 == 1) {
			for (int j = 0; j < array.length / 2; j++) {
				if (b.pop() == array[array.length / 2 + j + 1])
					s = true;
				else {
					s = false;
					break;
				}
			}
		}
	
		if (a.length() % 2 == 0) {
			for (int j = 0; j < array.length / 2; j++) {
				if (b.pop() == array[array.length / 2 + j])
					s = true;
				else {
					s = false;
					break;
				}
			}
		}
		
		if (s == true)
			System.out.println("회문입니다.");
		else if (s == false) {
			System.out.println("회문이 아닙니다.");
		}
		a = in.nextLine();
	}
	
	while(true){
		if(a.equals("q"))
				System.out.println("종료");
		break;
		}
	}
}
