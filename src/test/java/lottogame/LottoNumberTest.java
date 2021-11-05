package lottogame;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 45})
	public void 로또_번호_생성(int number){
		LottoNumber lottoNumber = new LottoNumber(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 46})
	public void 로또_번호_생성_유효하지않은_숫자_예외(int number){
		assertThatThrownBy(()->{
			LottoNumber lottoNumber = new LottoNumber(number);
		}).isInstanceOf(InvalidScopeOfLottoFormatException.class);
	}

}