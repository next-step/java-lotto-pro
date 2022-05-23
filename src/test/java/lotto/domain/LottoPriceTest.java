package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPriceTest {
	@ParameterizedTest
	@ValueSource(ints = {-2, -10, -30000})
	@DisplayName("0 이상의 숫자 입력 검증")
	void valid_number(int money) {
		assertThatThrownBy(() -> new LottoPrice(money))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest
	@CsvSource(value = {"13000,13", "13500,13", "17000,17", "5000,5"})
	@DisplayName("복권 살수 있는 양 구하기")
	void quantity(int money, int quantity) {
		LottoPrice lottoPrice = new LottoPrice(money);
		assertThat(lottoPrice.availableQuantity()).isEqualTo(quantity);
	}

	@ParameterizedTest
	@CsvSource(value = {"13000,13000", "13500,13000", "13000,13000", "700,0"})
	@DisplayName("들어간 비용 구하기")
	void expenses(int money, int cost) {
		LottoPrice lottoPrice = new LottoPrice(money);
		assertThat(lottoPrice.expenses()).isEqualTo(cost);
	}

	@Test
	@DisplayName("살 수 없는 개수를 입력하면 오류 발생")
	void validateOrder() {
		LottoPrice lottoPrice = new LottoPrice(3000);

		assertThatThrownBy(() -> lottoPrice.validateOrder(5))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
