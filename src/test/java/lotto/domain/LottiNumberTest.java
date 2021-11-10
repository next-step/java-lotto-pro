package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottiNumberTest {

	@Test
	@DisplayName("로또번호 생성자 int 테스트")
	public void LottiNumberConstructorIntTest() {
		//given
		//when
		LottoNumber lottoNumber = new LottoNumber(10);
		//then
		assertThat(lottoNumber).isEqualTo(new LottoNumber(10));
	}

	@Test
	@DisplayName("로또번호 생성자 String 테스트")
	public void LottiNumberConstructorStringTest() {
		//given
		//when
		LottoNumber lottoNumber = new LottoNumber("5");
		//then
		assertThat(lottoNumber).isEqualTo(new LottoNumber(5));
	}

	@Test
	@DisplayName("로또번호 범위 에러 테스트")
	public void LottiNumberBoundaryTest() {
		assertThatThrownBy(() -> new LottoNumber(0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또번호는 1~45의 값을 가져야 합니다.");
	}

	@Test
	@DisplayName("로또번호 숫자 외의 값 에러 테스트")
	public void LottiNumberValueTest() {
		assertThatThrownBy(() -> new LottoNumber("가"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또번호는 숫자만 입력가능합니다.");
	}
}
