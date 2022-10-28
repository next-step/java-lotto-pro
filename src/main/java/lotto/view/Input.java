package lotto.view;

import java.util.Scanner;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Money;

public class Input {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String SPLITER = ", ";

	private Input() {
	}

	public static Money inputPayment() {
		System.out.println("구입금액을 입력해 주세요.");
		return new Money(SCANNER.nextInt());
	}

	public static Lotto inputWinnerLotto() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		String winnersNumber = SCANNER.nextLine();
		return new Lotto(LottoNumber.of(winnersNumber.split(SPLITER)));
	}

}
