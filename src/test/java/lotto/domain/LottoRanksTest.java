package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRanksTest {

	@Test
	@DisplayName("로또 순위들이 주어지면, 각 순위 별 갯수를 반환한다")
	public void getRankCountTest() {
		// given
		LottoRank rank1 = new LottoRank(LottoRank.RANK_5ST);
		LottoRank rank2 = new LottoRank(LottoRank.RANK_4ST);
		LottoRank rank3 = new LottoRank(LottoRank.RANK_4ST);
		LottoRank rank4 = new LottoRank(LottoRank.RANK_3ST);
		LottoRank rank5 = new LottoRank(LottoRank.RANK_2ST);

		// when
		LottoRanks ranks = new LottoRanks(Arrays.asList(rank1, rank2, rank3, rank4, rank5));

		// then
		assertThat(ranks.getFirstCnt()).isEqualTo(0);
		assertThat(ranks.getSecondCnt()).isEqualTo(1);
		assertThat(ranks.getThirdCnt()).isEqualTo(1);
		assertThat(ranks.getFourthCnt()).isEqualTo(2);
		assertThat(ranks.getFifthCnt()).isEqualTo(1);

	}
}
