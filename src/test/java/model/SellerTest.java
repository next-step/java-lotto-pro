package model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("판매자")
class SellerTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> Seller.of(Money.from(100), mock(LottoGenerator.class)));
	}

	@Test
	@DisplayName("가격 없이 객체화하면 IllegalArgumentException")
	void instance_nullPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Seller.of(null, mock(LottoGenerator.class)))
			.withMessage("'price' must not be null");
	}

	@Test
	@DisplayName("가격 없이 객체화하면 IllegalArgumentException")
	void instance_nullGenerator_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Seller.of(Money.from(100), null))
			.withMessage("'generator' must not be null");
	}

	@Test
	@DisplayName("가격 가져오기")
	void price() {
		//given
		Money expected = Money.from(100);

		//when
		Money price = Seller.of(expected, mock(LottoGenerator.class)).price();

		//then
		assertThat(price)
			.isEqualTo(expected);
	}

	@Test
	@DisplayName("로또 생성")
	void lotto() {
		//given
		LottoGenerator mockGenerator = mock(LottoGenerator.class);
		Lotto expected = mock(Lotto.class);
		when(mockGenerator.lotto())
			.thenReturn(expected);

		//when
		Lotto lotto = Seller.of(Money.from(100), mockGenerator).lotto();

		//then
		assertThat(lotto)
			.isEqualTo(expected);
	}
}
