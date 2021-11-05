package lottoservice.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;
import lottoservice.matcher.LottoMatchRank;
import lottoservice.matcher.LottoMatchResult;
import lottoservice.matcher.LottoMatcher;
import lottoservice.matcher.LottoWinningNumbers;

public class LottoMatcherTest {

	@Test
	public void 정답과_로또티켓들_비교결과() {
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers("1, 5, 20, 34, 3, 40");

		List<LottoTicket> tickets = new ArrayList<>();
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,5,12,26,30,40))));
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,5,3,34,20,40))));


		LottoTickets lottoTickets = new LottoTickets(tickets);
		LottoMatcher lottoMatcher = new LottoMatcher(lottoWinningNumbers);
		LottoMatchResult lottoMatchResult = lottoMatcher.matchWinningAndTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.getResult().get(LottoMatchRank.SIX_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getResult().get(LottoMatchRank.THREE_POINT)).isEqualTo(1);
	}

	@Test
	public void 수익률계산() {
		LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.makeLottoWinningNumbers("1, 5, 20, 34, 3, 40");

		List<LottoTicket> tickets = new ArrayList<>();
		for(int i=0; i<20; i++){
			tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,6,11,25,32,44))));
		}
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,4,12,26,30,40))));
		tickets.add(new LottoTicket(getLottoNumbers(Arrays.asList(1,2,31,34,20,40))));


		LottoTickets lottoTickets = new LottoTickets(tickets);
		LottoMatcher lottoMatcher = new LottoMatcher(lottoWinningNumbers);
		LottoMatchResult lottoMatchResult = lottoMatcher.matchWinningAndTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(2.27);
	}

	private List<LottoNumber> getLottoNumbers(List<Integer> numbers) {
		return numbers.stream().map(number -> new LottoNumber(number)).collect(Collectors.toList());
	}

}
