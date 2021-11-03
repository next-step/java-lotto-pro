package com.example.lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoController {

	private final NumbersGenerator numbersGenerator;
	private long purchaseAmount;
	private List<LottoGame> lottoGames;

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
		lottoGames = LongStream.range(0, lottoGameCount)
			.boxed()
			.map(i -> new LottoGame(numbersGenerator))
			.collect(Collectors.toList());
		
		OutputView.print(String.format("%d개를 구매했습니다.", lottoGameCount));
		lottoGames.forEach(lottoGame -> OutputView.print(lottoGame.toString()));
	}

	private void check() {
		OutputView.print("지난 주 당첨 번호를 입력해 주세요.");
		LottoNumbers winningLottoNumbers = new LottoNumbers(InputView.inputLastWeekWinningLottoNumbers());

		LottoStatistic lottoStatistic = new LottoStatistic(purchaseAmount, lottoGames, winningLottoNumbers);
		OutputView.print(lottoStatistic.toString());
	}
}
