package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3, 4, 5, 6})
	@DisplayName("LottoNumbers 생성자 파라미터 int 테스트")
	public void LottoNumbersConstructorIntTest(int lottoNumber) {
		//given
		//when
		Lotto lottoNumbers = new Lotto(1, 2, 3, 4, 5, 6);
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
		Lotto lottoNumbers = new Lotto(StringLottoNumbers);
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
		Lotto lottoNumbers = new Lotto(lottoNumberList);
		//then
		assertThat(lottoNumbers.getLottoNumbers().contains(new LottoNumber(lottoNumber))).isTrue();
	}


	@Test
	@DisplayName("LottoNumbers 숫자외의 값 예외처리 테스트")
	public void LottoNumbersValueExceptionTest() {
		assertThatThrownBy(() -> new Lotto("가, 2, 3, 4, 5, 6"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또번호는 숫자만 입력가능합니다.");
	}

	@Test
	@DisplayName("LottoNumbers 중복 값 예외처리 테스트")
	public void LottoNumbersDuplicateExceptionTest() {
		assertThatThrownBy(() -> new Lotto("1, 2, 3, 35, 35, 6"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 중복 될 수 없습니다.");
	}

	@Test
	@DisplayName("LottoNumbers 6자리 숫자 가지는지 여부 예외 테스트")
	public void LottoNumbersLengthExceptionTest() {
		assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("[ERROR] 로또 번호는 6자리 숫자를 가져야 합니다.");
	}

	@ParameterizedTest
	@CsvSource(value = {"1, 13, 26, 38, 41, 8:6", "2, 13, 25, 38, 42, 8:3", "3, 15, 22, 31, 33, 4:0"}, delimiter = ':')
	@DisplayName("번호 개수 일치 확인 테스트")
	public void LottoMatchCountTest(String inputData, int expectedValue) {
		//given
		Lotto lotto = new Lotto(inputData);
		Lotto otherLotto = new Lotto(1, 13, 26, 38, 41, 8);
		//when
		long count = lotto.matchCount(otherLotto);
		//then
		assertThat(count).isEqualTo(expectedValue);
	}
}