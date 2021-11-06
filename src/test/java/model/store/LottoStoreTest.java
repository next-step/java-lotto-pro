package model.store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import model.LottoPaper;
import model.LottoPapers;
import model.common.Money;
import model.common.string.StringDelimiters;

@DisplayName("로또 상점")
class LottoStoreTest {

	@Test
	@DisplayName("객체화")
	void instance() {
		assertThatNoException()
			.isThrownBy(() -> LottoStore.of(customer(), oneHundredMoney(), mock(LottoMachine.class)));
	}

	@Test
	@DisplayName("고객 없이 객체화하면 IllegalArgumentException")
	void instance_nullInitialMoney_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(null, oneHundredMoney(), mock(LottoMachine.class)))
			.withMessage("'customer' must not be null");
	}

	@Test
	@DisplayName("가격 없이 객체화하면 IllegalArgumentException")
	void instance_nullPrice_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(customer(), null, mock(LottoMachine.class)))
			.withMessage("'price' must not be null");
	}

	@Test
	@DisplayName("로또 기계 없이 객체화하면 IllegalArgumentException")
	void instance_nullLottoMachine_thrownIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> LottoStore.of(customer(), oneHundredMoney(), null))
			.withMessage("'lottoMachine' must not be null");
	}

	@ParameterizedTest(name = "{displayName}[{index}] customer who has one hundred can buy {1} lotto")
	@DisplayName("100원 가진 고객이 로또 구매")
	@CsvSource({"1, 100", "10,10", "100,1", "1000,0"})
	void lottoPapers(int price, int expectedSize) {
		//given
		LottoMachine mockLottoMachine = mock(LottoMachine.class);
		when(mockLottoMachine.manualLotto(anyCollection()))
			.thenReturn(LottoPapers.from(Collections.emptyList()));
		when(mockLottoMachine.randomLotto(expectedSize))
			.thenReturn(LottoPapers.from(Collections.nCopies(expectedSize, mock(LottoPaper.class))));

		//when
		LottoPapers lottoPapers = LottoStore.of(customer(), Money.from(price), mockLottoMachine)
			.lottoPapers();

		//then
		assertThat(lottoPapers.size())
			.isEqualTo(expectedSize);
	}

	@Test
	@DisplayName("수동 번호를 가지고 있지만 돈이 부족한 고객의 경우 IllegalStateException")
	void lottoPapers_lackOfMoney_thrownIllegalStateException() {
		//given, when
		Customer customer = Customer.of(
			oneHundredMoney(), Collections.singletonList("1,2,3,4,5,6"), StringDelimiters.of(","));
		ThrowingCallable lottoPapersCall = () ->
			LottoStore.of(customer, Money.from(10000), mock(LottoMachine.class)).lottoPapers();

		//then
		assertThatIllegalStateException()
			.isThrownBy(lottoPapersCall)
			.withMessageContaining("customer does not have enough money");
	}

	private Customer customer() {
		return Customer.of(oneHundredMoney(),
			Collections.emptyList(),
			StringDelimiters.of(","));
	}

	private Money oneHundredMoney() {
		return Money.from(100);
	}

}
