package model.generator;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.WinnerLotto;
import model.common.LottoRule;
import model.common.Range;
import model.common.StringNumberConverter;
import model.common.string.StringsProvider;

@DisplayName("우승 로또 번호 생성기")
class WinnerLottoGeneratorTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(
				() -> WinnerLottoGenerator.of(mock(StringNumberConverter.class), mock(StringsProvider.class), "10"));
	}

	@Test
	@DisplayName("변환자 없이 객체화하면 IllegalArgumentException")
	void instance_nullConverter_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLottoGenerator.of(null, mock(StringsProvider.class), "10"))
			.withMessage("'converter' must not be null");
	}

	@Test
	@DisplayName("문자열 제공자 없이 객체화하면 IllegalArgumentException")
	void instance_nullProvider_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLottoGenerator.of(mock(StringNumberConverter.class), null, "10"))
			.withMessage("'stringsProvider' must not be null");
	}

	@Test
	@DisplayName("보너스 번호 없이 객체화하면 IllegalArgumentException")
	void instance_nullRule_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(
				() -> WinnerLottoGenerator.of(mock(StringNumberConverter.class), mock(StringsProvider.class), null))
			.withMessage("'bonusString' must not be empty");
	}

	@Test
	@DisplayName("정상적인 로또 생성")
	void lotto() {
		//given
		StringsProvider mockStringsProvider = mock(StringsProvider.class);
		when(mockStringsProvider.provide())
			.thenReturn(Arrays.asList("1", "2", "3", "4", "5", "6"));

		//when
		WinnerLotto lotto = WinnerLottoGenerator
			.of(StringNumberConverter.from(defaultLottoRule()), mockStringsProvider, "10")
			.lotto();

		//then
		assertThat(lotto.numbers())
			.hasToString("1, 2, 3, 4, 5, 6");
	}

	@Test
	@DisplayName("주어지는 문자가 숫자 형태가 아닌 로또를 생성할 경우 IllegalArgumentException")
	void lotto_notNumberString_thrownIllegalArgumentException() {
		//given
		StringsProvider mockStringsProvider = mock(StringsProvider.class);
		when(mockStringsProvider.provide())
			.thenReturn(Arrays.asList("", "a", "b"));

		//when
		ThrowingCallable lottoCall = () -> WinnerLottoGenerator
			.of(StringNumberConverter.from(defaultLottoRule()), mockStringsProvider, "10").lotto();

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoCall)
			.withMessageContaining("can not be changed to number");
	}

	@Test
	@DisplayName("보너스 문자가 숫자가 아닌 로또를 생성할 경우 IllegalArgumentException")
	void lotto_bonusNotNumberString_thrownIllegalArgumentException() {
		//given
		StringsProvider mockStringsProvider = mock(StringsProvider.class);
		when(mockStringsProvider.provide())
			.thenReturn(Arrays.asList("1", "2", "3", "4", "5", "6"));

		//when
		ThrowingCallable lottoCall = () -> WinnerLottoGenerator
			.of(StringNumberConverter.from(defaultLottoRule()), mockStringsProvider, "a")
			.lotto();

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoCall)
			.withMessageContaining("can not be changed to number");
	}

	@Test
	@DisplayName("로또 규칙과 다른 갯수로 생성할 경우 IllegalArgumentException")
	void lotto_mismatchedCount_thrownIllegalArgumentException() {
		//given
		StringsProvider mockProvider = mock(StringsProvider.class);
		when(mockProvider.provide())
			.thenReturn(Arrays.asList("1", "2", "3", "4"));

		//when
		ThrowingCallable lottoCall = () -> WinnerLottoGenerator
			.of(StringNumberConverter.from(defaultLottoRule()), mockProvider, "10")
			.lotto();

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoCall)
			.withMessageMatching("lotto Number must be \\d*, but provided \\d*");
	}

	private LottoRule defaultLottoRule() {
		return LottoRule.of(Range.of(1, 45), 6);
	}

}
