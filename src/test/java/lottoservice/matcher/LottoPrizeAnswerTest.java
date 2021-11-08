package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lottoservice.exception.DuplicateBonusNumberAndWinningNumbers;
import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.lottoticket.LottoTickets;

public class LottoPrizeAnswerTest {

	private LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@DisplayName("당첨정답_생성_보너스번호와_당첨번호_중복")
	@Test
	public void winningNumbers_constructor_duplicate_exception() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		WinningNumbers winningNumbers = new WinningNumbers(lottoNumbers);
		int number=22;
		BonusNumber bonusNumber = new BonusNumber(number);
		assertThatThrownBy(()->{
			LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers,bonusNumber);
		}).isInstanceOf(DuplicateBonusNumberAndWinningNumbers.class);
	}


	@DisplayName("당첨정답과_티켓_비교")
	@Test
	public void matchTicket() {
		int number=17;
		List<LottoNumber> winningNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		WinningNumbers lottoWinningNumbers = new WinningNumbers(winningNumbers);
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(lottoWinningNumbers,bonusNumber);

		List<LottoNumber> ticketNumbers = Arrays.asList(1,22,10,2,30,45)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(ticketNumbers);

		LottoMatchRank rank = lottoPrizeAnswer.matchTicket(lottoTicket);
		assertThat(rank).isEqualTo(LottoMatchRank.FOUR_POINT);
	}

	@DisplayName("당첨정답과_티켓_비교_2등")
	@Test
	public void matchTicket_secondPrize() {
		int number=17;
		List<LottoNumber> winningNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		WinningNumbers lottoWinningNumbers = new WinningNumbers(winningNumbers);
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(lottoWinningNumbers,bonusNumber);

		List<LottoNumber> ticketNumbers = Arrays.asList(1,22,17,7,30,45)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(ticketNumbers);

		LottoMatchRank rank = lottoPrizeAnswer.matchTicket(lottoTicket);
		assertThat(rank).isEqualTo(LottoMatchRank.FIVE_POINT_AND_BONUS);
	}

	@DisplayName("정답과_로또티켓들_총_비교결과")
	@Test
	public void matchTickets() {
		WinningNumbers winningNumbers = new WinningNumbers(
			lottoNumbersMaker.makeLottoNumbers("1, 5, 20, 34, 3, 40"));

		List<LottoTicket> tickets = new ArrayList<>();
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 5, 12, 26, 30, 40))));
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 5, 3, 34, 20, 40))));
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 5, 3, 34, 17, 40))));

		int number=17;
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers,bonusNumber);
		LottoMatchResult lottoMatchResult = lottoPrizeAnswer.matchTickets(new LottoTickets(tickets));

		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.ZERO_POINT)).isEqualTo(0);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.SIX_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.THREE_POINT)).isEqualTo(1);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.FIVE_POINT_AND_BONUS)).isEqualTo(1);
	}

	@DisplayName("당첨_수익률_계산")
	@Test
	public void calculateProfitPercentage() {
		WinningNumbers winningNumbers = new WinningNumbers(
			lottoNumbersMaker.makeLottoNumbers("1, 5, 20, 34, 3, 40"));

		List<LottoTicket> tickets = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 6, 11, 25, 32, 44))));
		}
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 4, 12, 26, 30, 40))));
		tickets.add(new LottoTicket(lottoNumbersMaker.makeLottoNumbers(Arrays.asList(1, 2, 31, 34, 20, 40))));
		LottoTickets lottoTickets = new LottoTickets(tickets);

		int number=17;
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(winningNumbers,bonusNumber);
		LottoMatchResult lottoMatchResult = lottoPrizeAnswer.matchTickets(lottoTickets);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(2.27);
	}
}
