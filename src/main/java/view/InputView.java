package view;

import lotto.model.LottoNumbers;
import lotto.model.UserMoney;

public class InputView {
	private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
	private static final String INPUT_WIN_LOTTO_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_LOTTO_MESSAGE = "보너스 볼을 입력해 주세요.";

	private InputView() {
	}

	public static UserMoney inputMoney() {
		return new UserMoney(inputView(INPUT_MONEY_MESSAGE));
	}

	public static LottoNumbers inputLastWinLotto() {
		return new LottoNumbers(inputView(INPUT_WIN_LOTTO_MESSAGE));
	}

	public static String inputBonusLottoNumber() {
		return inputView(INPUT_BONUS_LOTTO_MESSAGE);
	}

	private static String inputView(String message) {
		System.out.println(message);
		String readMessage = CustomScanner.readLine().trim();
		if(readMessage.isEmpty()) {
			throw new IllegalArgumentException("값이 입력되지 않았습니다.");
		}
		return readMessage;
	}
}
