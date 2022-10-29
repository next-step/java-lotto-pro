package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 44, 45})
	void 로또_번호는_1보다_크거나_같으며_45보다_작거나_같다(int 로또_번호_입력) {
		LottoNumber 로또_번호 = LottoNumber.of(로또_번호_입력);
		assertThat(로또_번호).isEqualTo(LottoNumber.of(로또_번호_입력));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 46, Integer.MAX_VALUE})
	void 로또_번호_생성시_1보다_작거나_45보다_크면_오류를_던진다(int 로또_번호_입력) {
		assertThatThrownBy(() -> LottoNumber.of(로또_번호_입력))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
