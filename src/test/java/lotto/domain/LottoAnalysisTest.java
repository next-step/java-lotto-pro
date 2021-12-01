package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.wrapper.LottoNumber;
import lotto.domain.wrapper.LottoOrderRequest;
import lotto.domain.wrapper.LottoTicket;

public class LottoAnalysisTest extends LottoAnalysis {
	private static final LottoAnalysis lottoAnalysis = new LottoAnalysis();

	@DisplayName("로또번호 적중 개수별 투자수익율")
	@ParameterizedTest
	@CsvSource(value = {
		"1,-1",
		"2,-1",
		"3,4",
		"4,49",
		"5,1499",
		"6,1999999",
	})
	void analysisProfitTest(int matchedNumberCount, BigDecimal expectedProfit) {
		final int ORDER_COUNT = 1;
		final int FIRST = 0;
		final List<LottoNumber> defaultNumbers = LottoTicket.getDefaultNumbers();

		LottoOrder lottoOrder = new LottoOrder();
		LottoTicket holdingTicket = lottoOrder.buyTickets(LottoOrderRequest.byOrderCount(ORDER_COUNT)).get(FIRST);
		defaultNumbers.removeAll(holdingTicket.getNumbers());
		List<LottoNumber> matchedNumbersInHoldTicket = holdingTicket.getNumbers().subList(FIRST, matchedNumberCount);
		List<LottoNumber> lastWeekWinningNumbers = new ArrayList<>(matchedNumbersInHoldTicket);
		lastWeekWinningNumbers.addAll(defaultNumbers.subList(FIRST, LottoTicket.NUMBER_COUNT - lastWeekWinningNumbers.size()));
		lottoAnalysis.setLastWinningTicket(new LottoTicket(lastWeekWinningNumbers));

		assertThat(lottoAnalysis.analysis(lottoOrder.totalInvestment(), lottoOrder.holdings()).getProfitPercent()).isEqualTo(expectedProfit);
	}
}
