package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumbersTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("LottoNumbers 생성자 파라미터 int 테스트")
	public void LottoNumbersConstructorIntTest(int lottoNumber) {
		//given
		//when
		LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
		//then
		assertThat(lottoNumbers.getLottoNumbers().contains(new LottoNumber(lottoNumber))).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("LottoNumbers 생성자 파라미터 String 테스트")
	public void LottoNumbersConstructorStringTest(int lottoNumber) {
		//given
		String StringLottoNumbers = "1, 2, 3, 4, 5, 6";
		//when
		LottoNumbers lottoNumbers = new LottoNumbers(StringLottoNumbers);
		//then
		assertThat(lottoNumbers.getLottoNumbers().contains(new LottoNumber(lottoNumber))).isTrue();
	}

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("LottoNumbers 생성자 파라미터 리스트 테스트")
	public void LottoNumbersConstructorListTest(int lottoNumber) {
		//given
		List<LottoNumber> lottoNumberList = new ArrayList<>();
		for (int i = 1; i <= 6; i++) {
			lottoNumberList.add(new LottoNumber(i));
		}
		//when
		LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberList);
		//then
		assertThat(lottoNumbers.getLottoNumbers().contains(new LottoNumber(lottoNumber))).isTrue();
	}

	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:1", "3:1", "4:1", "5:1", "6:1", "8:0",}, delimiter = ':')
	@DisplayName("LottoNumbers 당첨번호 1개 확인 테스트")
	public void LottoNumbersMatchTest(int lottoNumber, int expectedValue) {
		//given
		//when
		LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
		//then
		assertThat(lottoNumbers.ifMatchCount(new LottoNumber(lottoNumber))).isEqualTo(expectedValue);
	}

	@Test
	@DisplayName("LottoNumbers 숫자외의 값 예외처리 테스트")
	public void LottoNumbersValueExceptionTest() {
		assertThatThrownBy(() -> new LottoNumbers("가, 2, 3, 4, 5, 6"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또번호는 숫자만 입력가능합니다.");
	}

	@Test
	@DisplayName("LottoNumbers 중복 값 예외처리 테스트")
	public void LottoNumbersDuplicateExceptionTest() {
		assertThatThrownBy(() -> new LottoNumbers("1, 2, 3, 35, 35, 6"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 중복 될 수 없습니다.");
	}

	@Test
	@DisplayName("LottoNumbers 6자리 숫자 가지는지 여부 예외 테스트")
	public void LottoNumbersLengthExceptionTest() {
		assertThatThrownBy(() -> new LottoNumbers(1, 2, 3, 4, 5))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 6자리 숫자를 가져야 합니다.");
	}
}