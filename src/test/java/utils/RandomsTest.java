package utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomsTest {

	@ParameterizedTest
	@CsvSource(value = {"1,2,1", "1,11,10", "5,10,5"})
	void 중복_없는_랜덤_숫자_생성(int 최소값_이상, int 최대값_미만, int 갯수) {
		List<Integer> 랜덤_숫자 = Randoms.generateUniqueNumbers(최소값_이상, 최대값_미만, 갯수);
		HashSet<Integer> 중복_제거_숫자 = new HashSet<>(랜덤_숫자);
		assertThat(중복_제거_숫자).hasSize(갯수);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1,1", "100,100,1"})
	void 최소값_최대값이_같으면_예외를_던진다(int 최소값_이상, int 최대값_미만, int 갯수) {
		assertThatThrownBy(() -> Randoms.generateUniqueNumbers(최소값_이상, 최대값_미만, 갯수))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,10,10", "5,10,6"})
	void 갯수가_생성할_숫자보다_많을_경우_예외를_던진다(int 최소값_이상, int 최대값_미만, int 갯수) {
		assertThatThrownBy(() -> Randoms.generateUniqueNumbers(최소값_이상, 최대값_미만, 갯수))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
