package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	@Test
	@DisplayName("로또 결과 당첨자 수 확인 테스트")
	public void LottoResultCountWinnerTest() {
		//given
		Map<Rank, Integer> map = new EnumMap<Rank, Integer>(Rank.class);
		map.put(Rank.MISS, 3);
		//when
		LottoResult lottoResult = new LottoResult(map);
		//then
		assertThat(lottoResult.countWinner(Rank.MISS)).isEqualTo(3);
	}

	@Test
	@DisplayName("당첨자 없는 등수 조회 시 결과 확인")
	public void LottoResultNonCountWinnerTest() {
		//given
		Map<Rank, Integer> map = new EnumMap<Rank, Integer>(Rank.class);
		map.put(Rank.MISS, 3);
		//when
		LottoResult lottoResult = new LottoResult(map);
		//then
		assertThat(lottoResult.countWinner(Rank.FIFTH)).isEqualTo(0);
	}

	@Test
	@DisplayName("로또 전체 개수 확인")
	public void LottoResultCountLottoTest() {
		//given
		Map<Rank, Integer> map = new EnumMap<Rank, Integer>(Rank.class);
		map.put(Rank.MISS, 3);
		map.put(Rank.THIRD, 8);
		//when
		LottoResult lottoResult = new LottoResult(map);
		//then
		assertThat(lottoResult.countLotto()).isEqualTo(11);
	}
}