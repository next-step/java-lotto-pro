package view;

import java.util.ArrayList;
import java.util.List;

import lotto.LottoMachine;
import lotto.model.LottoNumbers;

public class InputView {
	private InputView() {
	}

	public static int inputMoney(LottoMachine lottoMachine) {
		System.out.println("구입금액을 입력해 주세요.");
		return lottoMachine.tradeCoin(readMessage());
	}

	public static int inputManualLottoCount(int userCoin, LottoMachine lottoMachine) {
		System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
		String buyCount = readMessage();
		lottoMachine.isCanBuyLotto(userCoin, buyCount);
		return Integer.parseInt(buyCount);
	}

	public static List<LottoNumbers> inputManualLotto(int manualLottoCount) {
		List<LottoNumbers> lottos = new ArrayList<>();
		if (manualLottoCount == 0) {
			return lottos;
		}

		System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
		for (int i = 0; i < manualLottoCount; i++) {
			lottos.add(inputLottoNumbers());
		}
		return lottos;
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
