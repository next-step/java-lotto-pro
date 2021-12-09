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

public class LottoAnalysisTest {

	@DisplayName("로또번호 적중 개수별 투자수익율")
	@ParameterizedTest
	@CsvSource(value = {
		"1,false,-1",
		"2,false,-1",
		"3,false,4",
		"4,false,49",
		"5,false,1499",
		"5,true,29999",
		"6,false,1999999",
	})
	void analysisProfitTest(int matchedNumberCount, boolean matchBonus, BigDecimal expectedProfit) {
		final int ORDER_COUNT = 1;
		final int FIRST = 0;
		final List<LottoNumber> defaultNumbers = LottoTicket.getDefaultNumbers();

		// get Lotto Ticket
		LottoOrder lottoOrder = new LottoOrder(LottoOrderRequest.byOrderCount(ORDER_COUNT));
		LottoTicket holdingTicket = lottoOrder.holdings().get(FIRST);

		// make winningTicket
		defaultNumbers.removeAll(holdingTicket.getNumbers());
		List<LottoNumber> matchedNumbersInHoldTicket = holdingTicket.getNumbers().subList(FIRST, matchedNumberCount);
		List<LottoNumber> lastWeekWinningNumbers = new ArrayList<>(matchedNumbersInHoldTicket);
		lastWeekWinningNumbers.addAll(defaultNumbers.subList(FIRST, LottoTicket.NUMBER_COUNT - lastWeekWinningNumbers.size()));
		LottoTicket lastWeekWinningTicket = new LottoTicket(lastWeekWinningNumbers);
		LottoNumber bonus = defaultNumbers.get(defaultNumbers.size()-1);
		// bonus number
		if(matchBonus) {
			List<LottoNumber> holdLottoNumbersExceptWinningNumbers = new ArrayList<>(holdingTicket.getNumbers());
			holdLottoNumbersExceptWinningNumbers.removeAll(lastWeekWinningNumbers);
			bonus = holdLottoNumbersExceptWinningNumbers.get(FIRST);
		}
		LottoAnalysis lottoAnalysis = new LottoAnalysis(lastWeekWinningTicket, bonus);
		assertThat(lottoAnalysis.analysis(lottoOrder.totalInvestment(), lottoOrder.holdings()).getProfitPercent()).isEqualTo(expectedProfit);
	}
}
