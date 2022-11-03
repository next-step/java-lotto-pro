package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.exception.InvalidMoneyException;

@DisplayName("금액 테스트")
class MoneyTest {

	@Test
	@DisplayName("금액 생성")
	void createMoneyTest() {
		Money money = Money.from(1000L);
		assertThat(money).isInstanceOf(Money.class);
	}

	@Test
	@DisplayName("금액이 0 이하일 경우 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionTest() {
		assertThatThrownBy(() -> Money.from(-1L))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000})
	@DisplayName("같은 값의 Money 객체는 같은 객체")
	void equalsTest(long money) {
		assertThat(Money.from(money)).isEqualTo(Money.from(money));
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:0.1", "10000:1", "100000:10"}, delimiter = ':')
	@DisplayName("나누기 테스트")
	void getProfitRateTest(long money, double expected) {
		Money inputMoney = Money.from(money);
		Money prizeMoney = Money.from(10000);
		assertThat(inputMoney.divide(prizeMoney)).isEqualTo(expected);
	}

	@Test
	@DisplayName("0으로 나누기 시 ArithmeticException 발생")
	void throwArithmeticExceptionTest() {
		Money inputMoney = Money.from(1000L);
		Money prizeMoney = Money.from(0);
		assertThatThrownBy(() -> inputMoney.divide(prizeMoney))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@Test
	@DisplayName("금액을 뺀 값을 반환")
	void subtractTest() {
		Money inputMoney = Money.from(1000L);
		Money prizeMoney = Money.from(500L);
		assertThat(inputMoney.subtract(prizeMoney)).isEqualTo(Money.from(500L));
	}

	@Test
	@DisplayName("금액을 뺀 값이 0보다 작을 경우 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionWhenSubtractTest() {
		Money inputMoney = Money.from(1000L);
		Money prizeMoney = Money.from(2000L);
		assertThatThrownBy(() -> inputMoney.subtract(prizeMoney))
			.isInstanceOf(InvalidMoneyException.class);
	}

}