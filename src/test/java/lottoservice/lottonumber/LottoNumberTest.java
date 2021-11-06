package lottoservice.lottonumber;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoNumber;

class LottoNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 45})
	public void 로또_번호_생성(int number){
		LottoNumber lottoNumber = LottoNumber.valueOf(number);
		assertThat(lottoNumber.getNumber()).isEqualTo(number);
	}

	@ParameterizedTest
	@ValueSource(ints = {-1, 46})
	public void 로또_번호_생성_유효하지않은_숫자_예외(int number){
		assertThatThrownBy(()->{
			LottoNumber lottoNumber = LottoNumber.valueOf(number);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2,-1","5,5,0","10,7,1"})
	public void compareTo_로또번호_비교(int number, int compareNumber,int expected){
		LottoNumber lottoNumber= LottoNumber.valueOf(number);
		assertThat(lottoNumber.compareTo(LottoNumber.valueOf(compareNumber))).isEqualTo(expected);
	}
}