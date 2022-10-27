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
		Money money = Money.of(1000);
		assertThat(money).isInstanceOf(Money.class);
	}

	@Test
	@DisplayName("금액이 0 이하일 경우 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionTest() {
		assertThatThrownBy(() -> Money.of(-1))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"1000:1", "1500:1", "2000:2", "2500:2", "3000:3", "3500:3", "4000:4", "4500:4", "5000:5",
		"5500:5", "6000:6", "6500:6", "7000:7", "7500:7", "8000:8", "8500:8", "9000:9", "9500:9",
		"10000:10"}, delimiter = ':')
	@DisplayName("천원 단위로 로또 티켓 구매 가능 수 반환 - 나머지 버림")
	void getLottoTicketCountTest(int money, int expected) {
		assertThat(Money.of(money).ticketCount(Money.of(1000)).count()).isEqualTo(expected);
	}

	@Test
	@DisplayName("티켓 가격이 0원 일 시 InvalidMoneyException 발생")
	void throwInvalidMoneyExceptionWhenTicketPriceIsZeroTest() {
		Money inputMoney = Money.of(1000);
		Money ticketPrice = Money.of(0);
		assertThatThrownBy(() -> inputMoney.ticketCount(ticketPrice))
			.isInstanceOf(InvalidMoneyException.class);
	}

	@ParameterizedTest
	@ValueSource(ints = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000})
	@DisplayName("같은 값의 Money 객체는 같은 객체")
	void equalsTest(int money) {
		assertThat(Money.of(money)).isEqualTo(Money.of(money));
	}

}