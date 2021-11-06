package model.generator;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoPaper;
import model.common.LottoRule;
import model.common.Range;
import model.common.StringNumberConverter;
import model.common.string.StringsProvider;

@DisplayName("수동 번호 로또 생성기")
class ManualLottoGeneratorTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> ManualLottoGenerator.of(mock(StringNumberConverter.class), mock(StringsProvider.class)));
	}

	@Test
	@DisplayName("변화기 없이 객체화하면 IllegalArgumentException")
	void instance_nullConverter_illegalArgumentExceptionThrown() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ManualLottoGenerator.of(null, mock(StringsProvider.class)))
			.withMessage("'converter' must not be null");
	}

	@Test
	@DisplayName("문자 제공자 없이 객체화하면 IllegalArgumentException")
	void instance_nullStringsProvider_illegalArgumentExceptionThrown() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> ManualLottoGenerator.of(mock(StringNumberConverter.class), null))
			.withMessage("'stringsProvider' must not be null");
	}

	@Test
	@DisplayName("로또 생성")
	void lotto() {
		//given
		StringsProvider mockProvider = mock(StringsProvider.class);
		when(mockProvider.provide()).thenReturn(Arrays.asList("1", "2", "3"));

		//when
		LottoPaper lotto = ManualLottoGenerator
			.of(StringNumberConverter.from(LottoRule.of(Range.of(1, 5), 3)), mockProvider)
			.lotto();

		//then
		assertThat(lotto)
			.hasToString("1, 2, 3");
	}
}
