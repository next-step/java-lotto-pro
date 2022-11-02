package lotto.view;

import java.util.Scanner;

public class InputView {
	public String purchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	public String prevWinNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}
