package lotto.view;

import java.util.Scanner;

import lotto.converter.InputConverter;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public Money readMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return InputConverter.toMoney(SCANNER.nextLine());
	}

	public LottoNumbers readWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return InputConverter.toLottoNumbers(SCANNER.nextLine());
	}
}
