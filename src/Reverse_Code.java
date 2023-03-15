import java.util.Scanner;

public class Reverse_Code {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String[] ss = s.split(" ");
		StringBuffer newStr = new StringBuffer();

		for (int i = ss.length - 1; i >= 0; i--) {
			if (i == 0) {
				newStr.append(ss[i]);
			} else {
				newStr.append(ss[i] + " ");
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLowerCase(newStr.charAt(i))) {
				newStr.setCharAt(i, Character.toUpperCase(newStr.charAt(i)));
			} else if (Character.isUpperCase(newStr.charAt(i))) {
				newStr.setCharAt(i, Character.toLowerCase(newStr.charAt(i)));
			}
		}
		System.out.println(newStr);
		sc.close();
	}
}
