package model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Score.from(Collections.singleton(LottoRank.FIRST)));
	}

	@Test
	@DisplayName("당첨 순위가 비어있는 상태로 객체화하면 IllegalArgumentException")
	void instance_nullRule_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Score.from(Collections.emptyList()))
			.withMessage("'lottoRanks' must not be empty");
	}

	@ParameterizedTest(name = "{displayName}[{index}] {0} count is {1}")
	@DisplayName("당첨 순위 갯수")
	@CsvSource({"FIRST,1", "SECOND,2", "THIRD,3", "FOURTH,4", "NONE,0"})
	void count(LottoRank target, int expected) {
		//when
		int count = Score.from(ranks())
			.count(target);

		//then
		assertThat(count)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("우승 상금 계산")
	void prizeMoney() {
		//when
		Money money = Score.from(ranks())
			.prizeMoney();

		//then
		assertThat(money)
			.isEqualTo(Money.from(2003170000));
	}

	private List<LottoRank> ranks() {
		return Arrays.asList(LottoRank.FIRST,
			LottoRank.SECOND, LottoRank.SECOND,
			LottoRank.THIRD, LottoRank.THIRD, LottoRank.THIRD,
			LottoRank.FOURTH, LottoRank.FOURTH, LottoRank.FOURTH, LottoRank.FOURTH);
	}
}
