import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoNumber;
import model.LottoNumbers;

public class LottoNumbersTest {

	@Test
	@DisplayName("로또 숫자가 6개가 주어지지 않으면 예외")
	void test_constructor1() {
		assertThatThrownBy(() -> new LottoNumbers(
			Arrays.asList(new LottoNumber(1), new LottoNumber(2))
		)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(LottoNumbers.MESSAGE_NOT_ALLOW_LENGTH);
	}

	@Test
	@DisplayName("로또 숫자에 중복된 값이 포함되어있으면 예외")
	void test_constructor2() {
		assertThatThrownBy(() -> new LottoNumbers(
			Arrays.asList(new LottoNumber(1), new LottoNumber(1), new LottoNumber(3),
				new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))
		)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage(LottoNumbers.MESSAGE_NOT_ALLOW_DUPLICATION);
	}

	@Test
	@DisplayName("로또 숫자가 6개가 포함되면서 겹치는 값이 없으면 성공")
	void test_constructor3() {
		assertThatNoException().isThrownBy(() -> new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			)
		));

		assertThat(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			)
		)).isEqualTo(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			)
		));
	}

	@Test
	@DisplayName("로또 숫자 6개가 포함된 문자열로도 생성 가능")
	void test_constructor4() {
		assertThatNoException().isThrownBy(() -> new LottoNumbers("1, 2, 3, 4, 5, 6"));

		assertThat(new LottoNumbers("1, 2, 3, 4, 5, 6"))
			.isEqualTo(new LottoNumbers(
				Arrays.asList(
					new LottoNumber(1),
					new LottoNumber(2),
					new LottoNumber(3),
					new LottoNumber(4),
					new LottoNumber(5),
					new LottoNumber(6)
				)
			));
	}

	@Test
	@DisplayName("equals의 구현이 정상적으로 되었는지 확인")
	void test1() {
		assertThat(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(7)
			)
		)).isEqualTo(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(7)
			)
		));
	}

	@Test
	@DisplayName("hashcode의 구현이 정상적으로 되었는지 확인")
	void test2() {
		Set<LottoNumbers> set = new HashSet<>();
		set.add(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			)
		));
		set.add(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(7)
			)
		));
		set.add(new LottoNumbers(
			Arrays.asList(
				new LottoNumber(1),
				new LottoNumber(2),
				new LottoNumber(3),
				new LottoNumber(4),
				new LottoNumber(5),
				new LottoNumber(6)
			)
		));

		assertThat(set.size()).isEqualTo(2);
	}
}
