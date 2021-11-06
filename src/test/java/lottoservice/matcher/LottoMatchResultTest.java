package lottoservice.matcher;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lottoservice.matcher.LottoMatchRank;
import lottoservice.matcher.LottoMatchResult;

class LottoMatchResultTest {

	@Test
	public void addMatchCount_로또_비교_결과_추가(){
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		lottoMatchResult.addMatchCount(LottoMatchRank.ONE_POINT);

		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.SIX_POINT)).isEqualTo(0);
		Assertions.assertThat(lottoMatchResult.getRankMatchCount(LottoMatchRank.ONE_POINT)).isEqualTo(1);
	}

	@Test
	public void calculateProfit_수익금_계산(){
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for(int i=1; i<=9; i++){
			lottoMatchResult.addMatchCount(LottoMatchRank.ONE_POINT);
		}
		lottoMatchResult.addMatchCount(LottoMatchRank.THREE_POINT);

		Assertions.assertThat(lottoMatchResult.calculateProfit()).isEqualTo(5000);
	}

	@Test
	public void calculateProfitPercentage_수익률_계산(){
		LottoMatchResult lottoMatchResult = new LottoMatchResult();
		for(int i=1; i<=13; i++){
			lottoMatchResult.addMatchCount(LottoMatchRank.ONE_POINT);
		}
		lottoMatchResult.addMatchCount(LottoMatchRank.THREE_POINT);

		Assertions.assertThat(lottoMatchResult.calculateProfitPercentage()).isEqualTo(0.35);
	}
} 