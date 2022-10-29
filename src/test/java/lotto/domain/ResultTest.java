package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("결과 테스트")
class ResultTest {

	@Test
	@DisplayName("결과 생성")
	void createResult() {
		Result result = Result.of(null);
		assertThat(result).isInstanceOf(Result.class);
	}

	@ParameterizedTest
	@ValueSource(longs = {0, 1, 2, 3, 4, 5, 6})
	@DisplayName("총 상금 반환 테스트")
	void getProfitRateTest(Long input) {
		Result result = Result.of(Map.of(
			Rank.FIRST, input,
			Rank.SECOND, input,
			Rank.THIRD, input,
			Rank.FOURTH, input,
			Rank.LOSE, input
		));
		long value = (Rank.FIRST.getPrize() * input)
			+ (Rank.SECOND.getPrize() * input)
			+ (Rank.THIRD.getPrize() * input)
			+ (Rank.FOURTH.getPrize() * input);
		assertThat(result.totalPrize()).isEqualTo(Money.of(value).getValue());
	}

}