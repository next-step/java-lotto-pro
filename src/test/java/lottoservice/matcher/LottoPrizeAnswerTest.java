package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lottoservice.exception.DuplicateBonusNumberAndWinningNumbers;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;
import lottoservice.testfactory.TestLottoDataFactory;

public class LottoPrizeAnswerTest {

	@DisplayName("당첨정답_생성_보너스번호와_당첨번호_중복")
	@Test
	public void winningNumbers_constructor_duplicate_exception() {
		WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 22, 3, 7, 30, 45));
		assertThatThrownBy(()->{
			LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers, new BonusNumber(22));
		}).isInstanceOf(DuplicateBonusNumberAndWinningNumbers.class);
	}


	@DisplayName("당첨정답과_티켓_비교")
	@Test
	public void matchTicket() {
		LottoTicket lottoTicket = new LottoTicket(TestLottoDataFactory.getLottoNumbers(1,22,10,2,30,45));

		WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 22, 3, 7, 30, 45));
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers, new BonusNumber(17));
		LottoMatchRank rank = lottoPrizeAnswer.matchTicket(lottoTicket);

		assertThat(rank).isEqualTo(LottoMatchRank.FOUR_POINT);
	}

	@DisplayName("당첨정답과_티켓_비교_2등")
	@Test
	public void matchTicket_secondPrize() {
		LottoTicket lottoTicket = new LottoTicket(TestLottoDataFactory.getLottoNumbers(1,22,17,7,30,45));

		WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 22, 3, 7, 30, 45));
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers, new BonusNumber(17));
		LottoMatchRank rank = lottoPrizeAnswer.matchTicket(lottoTicket);

		assertThat(rank).isEqualTo(LottoMatchRank.FIVE_POINT_AND_BONUS);
	}

	@DisplayName("정답과_로또티켓들_총_비교결과")
	@Test
	public void matchTickets() {

		LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
			TestLottoDataFactory.getLottoTicket(1, 5, 12, 26, 30, 40),
			TestLottoDataFactory.getLottoTicket(1, 5, 3, 34, 20, 40),
			TestLottoDataFactory.getLottoTicket(1, 5, 3, 34, 17, 40)
			));

		WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 5, 20, 34, 3, 40));

		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers, new BonusNumber(17));
		LottoMatchResult lottoMatchResult = lottoPrizeAnswer.matchTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.ZERO_POINT)).isEqualTo(0);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.SIX_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.THREE_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.FIVE_POINT_AND_BONUS)).isEqualTo(1);
	}

	@DisplayName("당첨_수익률_계산")
	@Test
	public void calculateProfitPercentage() {
		List<LottoTicket> tickets = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			tickets.add(TestLottoDataFactory.getLottoTicket(1, 6, 11, 25, 32, 44));
		}
		tickets.add(TestLottoDataFactory.getLottoTicket(1, 4, 12, 26, 30, 40));
		tickets.add(TestLottoDataFactory.getLottoTicket(1, 2, 31, 34, 20, 40));
		LottoTickets lottoTickets = new LottoTickets(tickets);

		WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 5, 20, 34, 3, 40));

		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers,new BonusNumber(17));
		LottoMatchResult lottoMatchResult = lottoPrizeAnswer.matchTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(2.27);
	}

	@DisplayName("수동티켓들과_자동티켓들_함께_정답과_비교")
	@Test
	public void matchTickets_multiple() {

		LottoTickets autoLottoTickets = new LottoTickets(Arrays.asList(
			TestLottoDataFactory.getLottoTicket(1, 5, 12, 26, 30, 40)
		));

		LottoTickets manualLottoTickets = new LottoTickets(Arrays.asList(
			TestLottoDataFactory.getLottoTicket(1, 5, 3, 34, 20, 40),
			TestLottoDataFactory.getLottoTicket(1, 5, 3, 34, 17, 40)
		));

		WinningNumbers winningNumbers = new WinningNumbers(TestLottoDataFactory.getLottoNumbers(1, 5, 20, 34, 3, 40));

		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers,new BonusNumber(17));
		LottoMatchResult lottoMatchResult = lottoPrizeAnswer.matchTickets(autoLottoTickets,manualLottoTickets);

		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.ZERO_POINT)).isEqualTo(0);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.SIX_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.THREE_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.FIVE_POINT_AND_BONUS)).isEqualTo(1);
	}
}
