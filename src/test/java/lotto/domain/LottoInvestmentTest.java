package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.domain.wrapper.LottoTicket;
import lotto.domain.wrapper.Money;

public class LottoInvestmentTest extends LottoInvestment {
	private final LottoInvestment lottoInvestment = new LottoInvestment();

	@DisplayName("로또 5장 구입 시 보유하게 된 로또 개수 검증")
	@Test
	void buyTicketsTest() {
		// given
		final int ORDER_COUNT = 5;

		// when
		lottoInvestment.buyTickets(LottoOrder.byOrderCount(ORDER_COUNT));

		// then
		assertThat(lottoInvestment.getHoldLottoCount()).isEqualTo(ORDER_COUNT);
	}

	@DisplayName("로또 5장 구입 시 투자금 검증")
	@Test
	void totalInvestmentTest() {
		// given
		final int ORDER_COUNT = 5;

		// when
		lottoInvestment.buyTickets(LottoOrder.byOrderCount(ORDER_COUNT));

		// then
		assertThat(lottoInvestment.totalInvestment()).isEqualTo(new Money(LottoTicket.PRICE * ORDER_COUNT));
	}

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
	void analysisProfitTest(int matchedNumberCount, double expectedProfit) {
		final int ORDER_COUNT = 1;
		final int FIRST = 0;
		final List<Integer> defaultNumbers = LottoTicket.getDefaultNumbers();

		lottoInvestment.buyTickets(LottoOrder.byOrderCount(ORDER_COUNT));
		List<Integer> holdLottoNumbers = lottoInvestment.getHoldLottoTickets().get(FIRST).getNumbers();
		defaultNumbers.removeAll(holdLottoNumbers);
		List<Integer> matchedNumbersInHoldTicket = holdLottoNumbers.subList(FIRST, matchedNumberCount);
		List<Integer> lastWeekWinningNumbers = new ArrayList<>(matchedNumbersInHoldTicket);
		lastWeekWinningNumbers.addAll(defaultNumbers.subList(FIRST, LottoTicket.NUMBER_COUNT - lastWeekWinningNumbers.size()));
		lottoInvestment.findLastWinningTicket(new LottoTicket(lastWeekWinningNumbers));

		assertThat(lottoInvestment.analysisProfit()).isEqualTo(expectedProfit);
	}
}
