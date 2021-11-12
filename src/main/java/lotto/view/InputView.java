package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import lotto.model.Lotto;
import lotto.model.PurchaseMoney;
import lotto.model.WinLotto;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static PurchaseMoney getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return new PurchaseMoney(scanner.nextLine());
	}

	public static WinLotto getWinLotto() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String numbers = scanner.nextLine();
		String[] splittedByComma = numbers.split(",");
		System.out.println("보너스 볼을 입력해 주세요.");
		String number = scanner.nextLine();
		WinLotto winLotto = new WinLotto(new Lotto(Arrays.stream(splittedByComma)
			.map(String::trim)
			.map(Integer::parseInt)
			.collect(Collectors.toList())), Integer.parseInt(number));
		return winLotto;
	}
}
