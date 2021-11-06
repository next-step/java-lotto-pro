package lotto;

import java.util.Scanner;

public class OutputView {
	private static final String PRINT_PURCHASE_QUANTITY = "%d개를 구매했습니다.";
	private static Scanner scanner = new Scanner(System.in);

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printPurchaseQuantity(int purchaseQuantity) {
		System.out.printf(PRINT_PURCHASE_QUANTITY, purchaseQuantity);
	}

	public static void newLine() {
		System.out.println();
	}
}
