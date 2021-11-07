package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoStatusTest {
	@Test
	@DisplayName("당첨숫자별 로또 개수 반환 테스트")
	void resultStatus() {
		Lottos lottos = new Lottos(Arrays.asList(
			new Lotto(new LottoNumbers(3,6,23,24,32,34)),
			new Lotto(new LottoNumbers(3,7,23,24,32,34)),
			new Lotto(new LottoNumbers(5,7,13,34,36,37)),
			new Lotto(new LottoNumbers(3,7,17,22,31,34))
		));
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(3,7,17,18,32,34);
		WinningLottoStatus status = lottos.getWinningStatus(winningLottoNumbers);
		int matchThreeCount = status.getMatchCount(LottoResult.MATCH_THREE);
		int matchFourCount = status.getMatchCount(LottoResult.MATCH_FOUR);
		int matchFiveCount = status.getMatchCount(LottoResult.MATCH_FIVE);
		int matchSixCount = status.getMatchCount(LottoResult.MATCH_SIX);

		assertThat(matchThreeCount).isEqualTo(1);
		assertThat(matchFourCount).isEqualTo(2);
		assertThat(matchFiveCount).isEqualTo(0);
		assertThat(matchSixCount).isEqualTo(0);
	}

	@Test
	@DisplayName("총 상금 및 총 수익률 반환")
	void totalRewardAndRate() {
		Lottos lottos = new Lottos(Arrays.asList(
			new Lotto(new LottoNumbers(3,6,23,24,32,34)),
			new Lotto(new LottoNumbers(3,7,23,24,32,34)),
			new Lotto(new LottoNumbers(5,7,13,34,36,37)),
			new Lotto(new LottoNumbers(3,7,17,22,31,34))
		));
		WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(3,7,17,18,32,34);
		WinningLottoStatus status = lottos.getWinningStatus(winningLottoNumbers);
		int useMoney = 4000;	//로또구매에 사용한 금액
		int totalReward = status.getTotalReward();
		double rateOfReturn = status.getRateOfReturn(useMoney);

		assertThat(totalReward).isEqualTo(105000);
		assertThat(rateOfReturn).isEqualTo(26.25);
	}
}
