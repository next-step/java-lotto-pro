package model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 상점")
class LottoStoreTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(
				() -> LottoStore.of(oneHundredMoney(), Seller.of(oneHundredMoney(), mock(LottoGenerator.class))));
	}

	@Test
	@DisplayName("초기 돈 없이 객체화하면 IllegalArgumentException")
	void instance_nullInitialMoney_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(null, Seller.of(oneHundredMoney(), mock(LottoGenerator.class))))
			.withMessage("'initialMoney' must not be null");
	}

	@Test
	@DisplayName("판매자 없이 객체화하면 IllegalArgumentException")
	void instance_nullSeller_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(oneHundredMoney(), null))
			.withMessage("'seller' must not be null");
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
		Lottos lottos = LottoStore.of(Money.from(initialMoney),
			Seller.of(oneHundredMoney(), mock(LottoGenerator.class)))
			.lottos();

		//then
		assertThat(lottos.size())
			.isEqualTo(expectedSize);
	}

	private Money oneHundredMoney() {
		return Money.from(100);
	}
}
