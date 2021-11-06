package model.common;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.common.string.StringsProvider;

@DisplayName("로또 숫자 변환기")
class StringNumberConverterTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> StringNumberConverter.from(defaultLottoRule()));
	}

	@Test
	@DisplayName("규칙 없이 객체화하면 IllegalArgumentException")
	void instance_nullRule_illegalArgumentExceptionThrown() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> StringNumberConverter.from(null))
			.withMessage("'rule' must not be null");
	}

	@Test
	@DisplayName("규칙에 맞는 로또 번호들 변환")
	void lottoNumbers() {
		//given
		StringsProvider provider = mock(StringsProvider.class);
		when(provider.provide())
			.thenReturn(Arrays.asList("1", "2", "3", "4", "5", "6"));

		//when
		LottoNumbers lottoNumbers = StringNumberConverter.from(defaultLottoRule())
			.lottoNumbers(provider);

		assertThat(lottoNumbers)
			.hasToString("1, 2, 3, 4, 5, 6");
	}

	@Test
	@DisplayName("규칙에 어긋나는 문자 갯수로 로또 번호 변환시 IllegalArgumentException")
	void lottoNumbers_invalidCount_thrownIllegalArgumentException() {
		//given
		StringsProvider provider = mock(StringsProvider.class);
		when(provider.provide())
			.thenReturn(Arrays.asList("1", "2", "3"));

		//when
		ThrowingCallable lottoNumbersCall = () -> StringNumberConverter.from(defaultLottoRule())
			.lottoNumbers(provider);

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoNumbersCall)
			.withMessageMatching("lotto Number must be \\d+, but provided \\d+");
	}

	@Test
	@DisplayName("로또 번호 변환")
	void lottoNumber() {
		//given, when
		LottoNumber lottoNumber = StringNumberConverter.from(defaultLottoRule())
			.lottoNumber("1");

		//then
		assertThat(lottoNumber)
			.isEqualTo(LottoNumber.from(1));
	}

	@Test
	@DisplayName("숫자 형태가 아닌 로또 번호 변환하면 IllegalArgumentException")
	void lottoNumber_invalidString_thrownIllegalArgumentException() {
		//given, when
		ThrowingCallable lottoNumberCall = () -> StringNumberConverter.from(defaultLottoRule())
			.lottoNumber("a");

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoNumberCall)
			.withMessageContaining("can not be changed to number");
	}

	@Test
	@DisplayName("규칙 범위에 벗어난 숫자로 변환하면 IllegalArgumentException")
	void lottoNumber_outOfRange_thrownIllegalArgumentException() {
		//given, when
		ThrowingCallable lottoNumberCall = () -> StringNumberConverter.from(defaultLottoRule())
			.lottoNumber(String.valueOf(Integer.MAX_VALUE));

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoNumberCall)
			.withMessageMatching(".* must be between min\\(\\d*\\) and max\\(\\d*\\)");
	}

	private LottoRule defaultLottoRule() {
		return LottoRule.of(Range.of(1, 45), 6);
	}
}
