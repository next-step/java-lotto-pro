package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchingNumberCountTest {

	@Test
	@DisplayName("일치한 개수가 1, 보너스볼 일치한 경우 결과는 ONE")
	void matchingNumberCount1() {
		MatchingNumberCount result = MatchingNumberCount.getByCount(Count.from(1), true);

		assertThat(result).isEqualTo(MatchingNumberCount.ONE);
	}

	@Test
	@DisplayName("일치한 개수가 5, 보너스볼 일치한 경우 결과는 FIVE_AND_BONUS")
	void matchingNumberCount2() {
		MatchingNumberCount result = MatchingNumberCount.getByCount(Count.from(5), true);

		assertThat(result).isEqualTo(MatchingNumberCount.FIVE_AND_BONUS);
	}

	@Test
	@DisplayName("일치한 개수가 5, 보너스볼 일치하지 않은 경우 결과는 FIVE")
	void matchingNumberCount3() {
		MatchingNumberCount result = MatchingNumberCount.getByCount(Count.from(5), false);

		assertThat(result).isEqualTo(MatchingNumberCount.FIVE);
	}
}