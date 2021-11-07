package lottoservice.matcher;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lottoservice.exception.InvalidLottoFormatException;
import lottoservice.lottonumber.LottoNumber;
import lottoservice.lottoticket.LottoTicket;

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
		List<LottoNumber> lottoNumbers = Arrays.asList(1,5,10,25,30,6).stream().map(it -> LottoNumber.valueOf(it)).collect(Collectors.toList());
		LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
		BonusNumber bonusNumber = new BonusNumber(number);
		assertThat(bonusNumber.matchTicket(lottoTicket)).isEqualTo(matchBonus);
	}
}