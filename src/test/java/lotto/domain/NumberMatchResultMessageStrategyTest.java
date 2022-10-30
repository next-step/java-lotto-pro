package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberMatchResultMessageStrategyTest {

	@Test
	void resultMessage() {
		ResultMessageStrategy resultMessageStrategy = new NumberMatchResultMessageStrategy(3, 5000);

		assertThat(resultMessageStrategy.resultMessage(5)).isEqualTo("3개 일치 (5000원)- 5개");
	}
}
