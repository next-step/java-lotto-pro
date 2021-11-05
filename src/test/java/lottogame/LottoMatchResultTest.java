package lottogame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMatchResultTest {

	@Test
	public void 로또_비교결과(){
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		lottoMatchResult.addCount(LottoMatchRank.ONE_POINT);

		Assertions.assertThat(lottoMatchResult.getResult().get(LottoMatchRank.SIX_POINT)).isEqualTo(0);
		Assertions.assertThat(lottoMatchResult.getResult().get(LottoMatchRank.ONE_POINT)).isEqualTo(1);
	}

	@Test
	public void 수익금_계산(){
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for(int i=1; i<=9; i++){
			lottoMatchResult.addCount(LottoMatchRank.ONE_POINT);
		}
		lottoMatchResult.addCount(LottoMatchRank.THREE_POINT);

		Assertions.assertThat(lottoMatchResult.calculateProfit()).isEqualTo(5000);
	}

	@Test
	public void 수익률_계산(){
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for(int i=1; i<=13; i++){
			lottoMatchResult.addCount(LottoMatchRank.ONE_POINT);
		}
		lottoMatchResult.addCount(LottoMatchRank.THREE_POINT);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(0.35);
	}
} 