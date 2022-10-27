package lotto.view;

import lotto.converter.InputConverter;
import lotto.domain.LottoNumbers;

import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public int inputMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		return InputConverter.toInt(SCANNER.nextLine());
	}

	public LottoNumbers inputWinningNumbers() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.");
		return InputConverter.toLottoNumbers(SCANNER.nextLine());
	}
}
