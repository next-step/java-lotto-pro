package lotto.view;

import java.util.Scanner;

import lotto.converter.InputConverter;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Money;
import lotto.domain.TicketCount;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해주세요.";

	public static LottoNumbers readLottoNumbers() {
		return InputConverter.toLottoNumbers(SCANNER.nextLine());
	}

	public Money readMoney() {
		System.out.println(INPUT_MONEY_MESSAGE);
		return InputConverter.toMoney(SCANNER.nextLine());
	}

	public LottoNumbers readWinningNumbers() {
		System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
		return InputConverter.toLottoNumbers(SCANNER.nextLine());
	}

	public LottoNumber readBonusNumber() {
		System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
		return InputConverter.toLottoNumber(SCANNER.nextLine());
	}

	public TicketCount readManualLottoCount() {
		System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
		return InputConverter.toLottoCount(SCANNER.nextLine());
	}
}
