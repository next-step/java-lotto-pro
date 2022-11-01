package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("결과 테스트")
class ResultTest {

	@Test
	@DisplayName("결과 생성")
	void createResult() {
		Result result = Result.of(Ranks.from(List.of(4)), Money.from(1L));
		assertThat(result).isInstanceOf(Result.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"50000, 1", "100000, 0.5", "10000, 5", "30000, 1.67"}, delimiter = ',')
	@DisplayName("수익률 반환 테스트")
	void profitTest(Long inputMoney, Double expected) {
		// given
		Result result = Result.of(Ranks.from(List.of(4)), Money.from(inputMoney));

		// when
		double profitRate = result.getProfitRate();

		// then
		assertThat(profitRate).isEqualTo(expected);
	}

}