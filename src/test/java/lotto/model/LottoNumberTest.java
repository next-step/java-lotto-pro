package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {
	@Test
	@DisplayName("로또 번호 생성 테스트")
	void create() {
		LottoNumber no1 = new LottoNumber(23);
		assertThat(no1).isEqualTo(new LottoNumber(23));
	}



	@ParameterizedTest
	@ValueSource(ints = {1,45})
	@DisplayName("로또 번호가 유효한지 검증(올바른 번호)")
	void validateMoneyCorrect(int no) {
		assertThatCode(()->{
			new LottoNumber(no);
		}).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@ValueSource(ints = {-3,46})
	@DisplayName("로또 번호가 유효한지 검증(틀린 번호)")
	void validateMoneyIncorrect(int no) {
		assertThatThrownBy(()->{
			new LottoNumber(no);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
