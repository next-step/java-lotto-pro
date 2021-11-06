package utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RandomNumberTest {
	@DisplayName("주어진 범위에 해당하는 랜덤값 추출")
	@ParameterizedTest
	@CsvSource(value = {
		"0,0",
		"1,2",
		"1,45",
	})
	public void pickRandomNumberBetweenStartAndEndTest(int start, int end) {
		assertThat(RandomNumber.pickBetweenStartAndEnt(start, end))
			.isBetween(start, end);
	}

	@DisplayName("유효하지 않은 범위의 랜덤값 추출 시 오류 반환")
	@ParameterizedTest
	@CsvSource(value = {
		"1,0,시작값보다 마지막값이 클 수 없습니다.",
		"1,2147483647, 마지막값이 너무 큽니다.",
		"-1,2147483647, 범위가 너무 큽니다.",
	})
	public void throwWhenGivenIllegalRangeTest(int start, int end, String errorMessage) {
		assertThatThrownBy(() -> RandomNumber.pickBetweenStartAndEnt(start, end))
			.isInstanceOf(IllegalArgumentException.class)
			.withFailMessage(errorMessage);
	}
}
