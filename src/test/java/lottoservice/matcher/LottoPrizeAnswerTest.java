package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.lottonumber.LottoArrangeManipulator;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottonumber.LottoNumbersMaker;

public class LottoPrizeAnswerTest {

	private LottoNumbersMaker lottoNumbersMaker = new LottoNumbersMaker(new LottoArrangeManipulator());

	@Test
	public void 보너스번호_포함_당첨번호와_티켓_매칭() {
		List<LottoNumber> lottoNumbers = lottoNumbersMaker.makeLottoNumbers(
			Arrays.asList(1, 22, 3, 7, 30, 45));
		LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(lottoNumbers);
		BonusNumber bonusNumber = new BonusNumber(17);
		LottoPrizeAnswer lottoPrizeAnswer = new LottoPrizeAnswer(lottoWinningNumbers,bonusNumber);

		lottoNumbers.stream().forEach(it->
			assertThat(lottoPrizeAnswer.hasNumberInWinningNumbers(it)).isEqualTo(true));
		assertThat(lottoPrizeAnswer.isMatchBonusNumber(LottoNumber.valueOf(17))).isEqualTo(true);
	}
}
