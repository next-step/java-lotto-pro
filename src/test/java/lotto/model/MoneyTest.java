package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

	@ParameterizedTest
	@ValueSource(strings = {"1000", "500000", "123123"})
	@DisplayName("금액이 유효한지 검증(올바른 금액)")
	void validateMoneyCorrect(String strMoney) {
		assertThatCode(()->{
			new Money(strMoney);
		}).doesNotThrowAnyException();
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"asd", "50000e0", "123.123", "-23123"})
	@DisplayName("금액이 유효한지 검증(틀린 금액)")
	void validateMoneyIncorrect(String strMoney) {
		assertThatThrownBy(()->{
			new Money(strMoney);
		}).isInstanceOf(NumberFormatException.class);
	}
}
