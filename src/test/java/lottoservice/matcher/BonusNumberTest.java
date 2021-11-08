package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;
import lottoservice.testfactory.TestLottoDataFactory;

class BonusNumberTest {

	@ParameterizedTest
	@ValueSource(ints = {1,5,44,45})
	public void 보너스번호_생성(int number) {
		BonusNumber bonusNumber = new BonusNumber(number);
		assertThat(bonusNumber).isEqualTo(new BonusNumber(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-1,0,46})
	public void 보너스번호_유효하지않은_번호_예외(int number) {
		assertThatThrownBy(()->{
			BonusNumber bonusNumber = new BonusNumber(number);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1","10,10","45,45"})
	public void 보너스번호_문자열입력(String numberText, int number) {
		BonusNumber bonusNumber = new BonusNumber(numberText);
		assertThat(bonusNumber).isEqualTo(new BonusNumber(number));
	}

	@ParameterizedTest
	@ValueSource(strings = {"","1,2","1,","#"})
	public void 보너스번호_문자열_입력_예외(String numberText) {
		assertThatThrownBy(()->{
			BonusNumber bonusNumber = new BonusNumber(numberText);
		}).isInstanceOf(InvalidLottoFormatException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,true","10,true","45,false"})
	public void 보너스번호_매칭(int number, boolean matchBonus){
		LottoTicket lottoTicket = TestLottoDataFactory.getLottoTicket(1,5,10,25,30,6);
		BonusNumber bonusNumber = new BonusNumber(number);
		assertThat(bonusNumber.matchTicket(lottoTicket)).isEqualTo(matchBonus);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,1,true","10,17,false","45,45,true"})
	public void 로또번호와_보너스번호_매칭(int lottoNum, int bonusNum, boolean matchBonus){
		BonusNumber bonusNumber = new BonusNumber(bonusNum);
		LottoNumber lottoNumber = LottoNumber.valueOf(lottoNum);
		assertThat(bonusNumber.isMatchNumber(lottoNumber)).isEqualTo(matchBonus);
	}
}