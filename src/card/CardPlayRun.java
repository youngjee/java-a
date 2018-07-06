package card;

import java.util.Arrays;

public class CardPlayRun {
	public static void main(String[] args) {
		String[] cards = {"10", "13", "2", "1", "5", "20", "7", "B", "22", "C"};
		CardPlay cp = new CardPlay();
		System.out.println(cp.getCard(cards));
		System.out.println(Arrays.toString(cp.twoPersonTotal(cards)));
	}
}
