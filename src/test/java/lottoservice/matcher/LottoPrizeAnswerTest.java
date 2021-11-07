package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;
import lottoservice.lottoticket.LottoTicket;

public class LottoPrizeAnswerTest {

	private LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@Test
	public void 당첨정답_생성() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);
		int number=17;
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(lottoWinningNumbers,bonusNumber);

		lottoNumbers.stream().forEach(it->
			assertThat(lottoPrizeAnswer.hasNumberInWinningNumbers(it)).isEqualTo(true));
		assertThat(lottoPrizeAnswer.isMatchBonusNumber(LottoNumber.valueOf(number))).isEqualTo(true);
	}

	@Test
	public void 당첨정답과_티켓_비교() {
		int number=17;
		List<LottoNumber> winningNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(lottoWinningNumbers,bonusNumber);

		List<LottoNumber> ticketNumbers = Arrays.asList(1,22,10,2,30,45)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(ticketNumbers);

		LottoMatchRank rank = lottoPrizeAnswer.matchTicket(lottoTicket);
		assertThat(rank).isEqualTo(LottoMatchRank.FOUR_POINT);
	}

	@Test
	public void 당첨정답과_티켓_비교_2등() {
		int number=17;
		List<LottoNumber> winningNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningNumbers);
		BonusNumber bonusNumber = new BonusNumber(number);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(lottoWinningNumbers,bonusNumber);

		List<LottoNumber> ticketNumbers = Arrays.asList(1,22,17,7,30,45)
			.stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(ticketNumbers);

		LottoMatchRank rank = lottoPrizeAnswer.matchTicket(lottoTicket);
		assertThat(rank).isEqualTo(LottoMatchRank.FIVE_POINT_AND_BONUS);
	}
}
