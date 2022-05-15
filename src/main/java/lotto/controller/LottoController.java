package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lotto.domain.AbstractLottoMachine;
import lotto.domain.AutoLottoMachine;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.RankResult;
import lotto.dto.PrizeReport;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
	private final String COMMA = ",";

	public void start() {
		Money money = new Money(InputView.inputMoney());
		int count = money.divide(AbstractLottoMachine.LOTTO_PRICE);
		OutputView.printPurchaseCount(count);

		LottoTickets lottoTickets = getAutoTickets(count);
		OutputView.printLottoTickets(lottoTickets.getLottTickets());

		String winningNumbers = InputView.inputWinningNumbers();
		Lotto winningLotto = Lotto.getInstanceByString(getNumbersToString(winningNumbers));

		RankResult result = lottoTickets.getResult(winningLotto);
		List<PrizeReport> report = result.getReport();
		Collections.sort(report);
		OutputView.printPrizeResult(report);

		double rate = result.compileStatistics(count * AbstractLottoMachine.LOTTO_PRICE);
		OutputView.printRate(rate);
	}

	private LottoTickets getAutoTickets(int count) {
		AutoLottoMachine lottoMachine = new AutoLottoMachine();

		LottoTickets lottoTickets = new LottoTickets();
		for(int index = 0; index < count; index +=1 ) {
			lottoTickets.addLotto(lottoMachine.generate());
		}

		return lottoTickets;
	}

	private List<String> getNumbersToString(String input) {
		List<String> numbers = new ArrayList<>();
		String[] strNumbers = input.split(COMMA);

		for(String number: strNumbers) {
			numbers.add(number.trim());
		}

		return numbers;
	}
}
