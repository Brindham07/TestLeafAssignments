package week3.assignment;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PayPal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "PayPal India";
		char[] aa = text.toCharArray();
		Set<Character> charSet = new LinkedHashSet<Character>();
		Set<Character> dupCharSet = new LinkedHashSet<Character>();
		for (int i = 0; i < aa.length; i++) {
			if (charSet.contains(aa[i])) {
				dupCharSet.add(aa[i]);
			} else {
				charSet.add(aa[i]);
			}
			for (Character D : dupCharSet) {
				charSet.remove(D);
			}
			charSet.remove(' ');
		}
		System.out.println("The Characters's Present In CharSet are: ");
		for (Character C : charSet) {
			System.out.println(C);
		}

	}
}
