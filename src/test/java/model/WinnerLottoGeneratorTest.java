package model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("우승 로또 번호 생성기")
class WinnerLottoGeneratorTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> WinnerLottoGenerator.of(mock(StringsProvider.class), "10", defaultLottoRule()));
	}

	@Test
	@DisplayName("문자열 제공자 없이 객체화하면 IllegalArgumentException")
	void instance_nullProvider_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLottoGenerator.of(null, "10", defaultLottoRule()))
			.withMessage("'stringsProvider' must not be null");
	}

	@Test
	@DisplayName("규칙 없이 객체화하면 IllegalArgumentException")
	void instance_nullRule_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> WinnerLottoGenerator.of(mock(StringsProvider.class), "10", null))
			.withMessage("'rule' must not be null");
	}

	@Test
	@DisplayName("정상적인 로또 생성")
	void lotto() {
		//given
		StringsProvider mockStringsProvider = mock(StringsProvider.class);
		when(mockStringsProvider.provide())
			.thenReturn(Arrays.asList("1", "2", "3", "4", "5", "6"));

		//when
		WinnerLotto lotto = WinnerLottoGenerator.of(mockStringsProvider, "10", defaultLottoRule())
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
		ThrowingCallable lottoCall = () -> WinnerLottoGenerator.of(mockStringsProvider, "10",
			defaultLottoRule()).lotto();

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
		ThrowingCallable lottoCall = () -> WinnerLottoGenerator.of(mockStringsProvider, "a",
			defaultLottoRule()).lotto();

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
		ThrowingCallable lottoCall = () -> WinnerLottoGenerator.of(mockProvider, "10", defaultLottoRule()).lotto();

		//then
		assertThatIllegalArgumentException()
			.isThrownBy(lottoCall)
			.withMessageMatching("Lotto Number must be \\d*, but provided \\d*");
	}

	private LottoRule defaultLottoRule() {
		return LottoRule.of(1, 45, 6);
	}

}
