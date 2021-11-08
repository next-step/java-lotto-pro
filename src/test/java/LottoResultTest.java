import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import model.LottoResult;
import model.Rank;

public class LottoResultTest {

	@Test
	@DisplayName("addMatchingCount 메소드가 호출되면 내부 값이 달라지는지 확인")
	void test_addMatchingCount1() {
		LottoResult lottoResult = new LottoResult();
		lottoResult.addMatchingCount();

		assertThat(lottoResult).isNotEqualTo(new LottoResult());
	}

	@Test
	@DisplayName("addMatchingCount 메소드가 호출된 횟수가 같으면 같은 값")
	void test_addMatchingCount2() {
		LottoResult lottoResult1 = new LottoResult();
		lottoResult1.addMatchingCount();

		LottoResult lottoResult2 = new LottoResult();
		lottoResult2.addMatchingCount();

		assertThat(lottoResult1).isEqualTo(lottoResult2);
	}

	@ParameterizedTest
	@DisplayName("matchingCount에 따라 rank 반환")
	@MethodSource("test_getRank1_param")
	void test_getRank1(int matchingCount, Rank rank) {
		LottoResult lottoResult = new LottoResult();
		for (int i = 0; i < matchingCount; ++i) {
			lottoResult.addMatchingCount();
		}

		assertThat(lottoResult.getRank()).isEqualTo(rank);
	}

	static Stream<Arguments> test_getRank1_param() {
		return Stream.of(
			Arguments.of(0, Rank.NONE),
			Arguments.of(1, Rank.NONE),
			Arguments.of(2, Rank.NONE),
			Arguments.of(3, Rank.FIFTH),
			Arguments.of(4, Rank.FOURTH),
			Arguments.of(5, Rank.THIRD),
			Arguments.of(6, Rank.FIRST)
		);
	}
}
