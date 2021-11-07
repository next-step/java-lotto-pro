package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnersTest {

	@Test
	@DisplayName("등수 별 당첨자수 기록 및 인원수 확인 테스트")
	public void WinnersTest() {
		//given
		Winners winners = new Winners();
		//when
		winners.record(3);
		//then
		assertThat(winners.count(Rank.FIFTH.getMatchedNumber())).isEqualTo(1);
	}

}