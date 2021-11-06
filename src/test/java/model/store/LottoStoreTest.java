package model.store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import model.Lotto;
import model.generator.LottoGenerator;
import model.LottoPapers;
import model.common.Money;

@DisplayName("로또 상점")
class LottoStoreTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(
				() -> LottoStore.of(oneHundredMoney(), oneHundredMoney(), mock(LottoGenerator.class)));
	}

	@Test
	@DisplayName("초기 돈 없이 객체화하면 IllegalArgumentException")
	void instance_nullInitialMoney_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(null, oneHundredMoney(), mock(LottoGenerator.class)))
			.withMessage("'initialMoney' must not be null");
	}

	@Test
	@DisplayName("가격 없이 객체화하면 IllegalArgumentException")
	void instance_nullPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(oneHundredMoney(), null, mock(LottoGenerator.class)))
			.withMessage("'price' must not be null");
	}

	@Test
	@DisplayName("로또 생성기 없이 객체화하면 IllegalArgumentException")
	void instance_nullLottoGenerator_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(oneHundredMoney(), oneHundredMoney(), null))
			.withMessage("'lottoGenerator' must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] if the initialized money is {0}, you can buy {1} lotto worth 100 won")
	@DisplayName("100원짜리 로또들 구매")
	@CsvSource({"0, 0", "100,1", "150,1", "1000,10"})
	void lottos(int initialMoney, int expectedSize) {
		//given
		LottoGenerator mockGenerator = mock(LottoGenerator.class);
		when(mockGenerator.lotto())
			.thenReturn(mock(Lotto.class));

		//when
		LottoPapers lottoPapers = LottoStore.of(Money.from(initialMoney),
			oneHundredMoney(), mock(LottoGenerator.class))
			.lottoPapers();

		//then
		assertThat(lottoPapers.size())
			.isEqualTo(expectedSize);
	}

	private Money oneHundredMoney() {
		return Money.from(100);
	}
}
