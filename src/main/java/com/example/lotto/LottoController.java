package com.example.lotto;

public class LottoController {

	private final NumbersGenerator numbersGenerator;
	private long purchaseAmount;
	private LottoGames lottoGames;

	public LottoController(NumbersGenerator numbersGenerator) {
		this.numbersGenerator = numbersGenerator;
	}

	public void run() {
		buy();
		check();
	}

	private void buy() {
		OutputView.print("구입금액을 입력해 주세요.");
		purchaseAmount = InputView.inputPurchaseAmount();
		long lottoGameCount = purchaseAmount / LottoGame.LOTTO_GAME_PRICE;
		lottoGames = new LottoGames(lottoGameCount, numbersGenerator);

		OutputView.print(String.format("%d개를 구매했습니다.", lottoGameCount));
		OutputView.print(lottoGames.toString());
	}

	private void check() {
		OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
		LottoNumbers baseNumbers = LottoNumbers.of(InputView.inputBaseWinningLottoNumbers());
		OutputView.print("보너스 볼을 입력해 주세요.");
		LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusWinningLottoNumber());

		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(baseNumbers, bonusNumber);
		LottoStatistic lottoStatistic = new LottoStatistic(purchaseAmount, lottoGames, winningLottoNumbers);
		OutputView.print(lottoStatistic.toString());
	}
}
