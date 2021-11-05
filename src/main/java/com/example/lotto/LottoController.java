package com.example.lotto;

import java.util.List;

public class LottoController {

	private final NumbersGenerator numbersGenerator;
	private PurchaseInformation purchaseInformation;
	private LottoGames lottoGames;

	public LottoController(NumbersGenerator numbersGenerator) {
		this.numbersGenerator = numbersGenerator;
	}

	public void run() {
		pay();
		issue();
		check();
	}

	private void pay() {
		OutputView.print("구입금액을 입력해 주세요.");
		long purchaseAmount = InputView.inputPurchaseAmount();
		OutputView.print("수동으로 구매할 로또 수를 입력해 주세요.");
		long manualLottoPurchaseCount = InputView.inputManualLottoPurchaseCount();

		this.purchaseInformation = PurchaseInformation.of(
			LottoGame.LOTTO_GAME_PRICE,
			purchaseAmount,
			manualLottoPurchaseCount);
	}

	private void issue() {
		LottoGames manualLottoGames = getManualLottoGames();
		LottoGames autoLottoGames = LottoGames.auto(purchaseInformation.getAutoLottoPurchaseCount(), numbersGenerator);
		lottoGames = LottoGames.merge(manualLottoGames, autoLottoGames);

		OutputView.print(String.format("%d개를 구매했습니다.", lottoGames.size()));
		OutputView.print(lottoGames.toString());
	}

	private void check() {
		OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
		LottoNumbers baseNumbers = LottoNumbers.of(InputView.inputBaseWinningLottoNumbers());
		OutputView.print("보너스 볼을 입력해 주세요.");
		LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusWinningLottoNumber());

		WinningLottoNumbers winningLottoNumbers = WinningLottoNumbers.of(baseNumbers, bonusNumber);
		LottoStatistic lottoStatistic = new LottoStatistic(purchaseInformation, lottoGames, winningLottoNumbers);
		OutputView.print(lottoStatistic.toString());
	}

	private LottoGames getManualLottoGames() {
		OutputView.print("수동으로 구매할 번호를 입력해 주세요.");
		long manualLottoPurchaseCount = purchaseInformation.getManualLottoPurchaseCount();
		List<List<Integer>> numbersList = InputView.inputManualLottoNumbersList(manualLottoPurchaseCount);
		return LottoGames.manual(numbersList);
	}
}
