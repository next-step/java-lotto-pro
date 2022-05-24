package view;

import java.util.ArrayList;
import java.util.List;

import lotto.LottoMachine;
import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import lotto.model.UserMoney;

public class InputView {
	private InputView() {
	}

	public static UserMoney inputMoney(int lottoPrice) {
		System.out.println("구입금액을 입력해 주세요.");
		return new UserMoney(readMessage(), lottoPrice);
	}

	public static String inputManualLottoCount(UserMoney userMoney, LottoMachine lottoMachine) {
		System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
		String buyCount = readMessage();
		lottoMachine.isCanBuyLotto(userMoney, buyCount);
		return buyCount;
	}

	public static Lottos inputManualLotto(String manualLottoCount) {
		List<LottoNumbers> lottos = new ArrayList<>();
		if (Integer.parseInt(manualLottoCount) == 0) {
			return new Lottos(lottos);
		}

		System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < Integer.parseInt(manualLottoCount); i++) {
			lottos.add(inputLottoNumbers());
		}
		return new Lottos(lottos);
	}

	public static LottoNumbers inputWinLottoNumbers() {
		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
		return inputLottoNumbers();
	}

	private static LottoNumbers inputLottoNumbers() {
		return new LottoNumbers(readMessage());
	}

	public static String inputBonusLottoNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return readMessage();
	}

	private static String readMessage() {
		String readMessage = CustomScanner.readLine().trim();
		if (readMessage.isEmpty()) {
			throw new IllegalArgumentException("값이 입력되지 않았습니다.");
		}
		return readMessage;
	}
}
