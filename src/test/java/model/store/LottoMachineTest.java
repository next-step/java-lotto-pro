package model.store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.LottoPaper;
import model.LottoPapers;
import model.common.LottoNumber;
import model.common.LottoNumbers;
import model.common.StringNumberConverter;
import model.common.string.StringsProvider;
import model.generator.LottoGenerator;

@DisplayName("로또 기계")
class LottoMachineTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> LottoMachine.of(mock(StringNumberConverter.class), mock(LottoGenerator.class)));
	}

	@Test
	@DisplayName("변환자 없이 객채화 하면 IllegalArgumentException")
	void instance_nullConverter_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoMachine.of(null, mock(LottoGenerator.class)))
			.withMessage("'converter' must not be null");
	}

	@Test
	@DisplayName("로또 생성기 없이 객채화 하면 IllegalArgumentException")
	void instance_nullLottoGenerator_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoMachine.of(mock(StringNumberConverter.class), null))
			.withMessage("'randomGenerator' must not be null");
	}

	@Test
	@DisplayName("수동 로또 생성")
	void manualLotto() {
		//given
		StringsProvider mockProvider = mock(StringsProvider.class);
		when(mockProvider.provide())
			.thenReturn(Collections.singletonList("any"));

		StringNumberConverter mockConverter = mock(StringNumberConverter.class);
		when(mockConverter.lottoNumbers(mockProvider)).thenReturn(
			LottoNumbers.from(Collections.singleton(LottoNumber.from(1))));

		//when
		LottoPapers papers = LottoMachine.of(mockConverter, mock(LottoGenerator.class))
			.manualLotto(Arrays.asList(mockProvider, mockProvider, mockProvider));

		//then
		assertThat(papers.size())
			.isEqualTo(3);
	}

	@Test
	@DisplayName("랜덤 로또 생성")
	void randomLotto() {
		//given
		LottoGenerator<LottoPaper> mockGenerator = mock(LottoGenerator.class);
		when(mockGenerator.lotto())
			.thenReturn(LottoPaper.auto(LottoNumbers.from(Collections.singleton(LottoNumber.from(1)))));

		//when
		LottoPapers papers = LottoMachine.of(mock(StringNumberConverter.class), mock(LottoGenerator.class))
			.randomLotto(3);

		//then
		assertThat(papers.size())
			.isEqualTo(3);
	}
}
