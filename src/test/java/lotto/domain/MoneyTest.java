package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @Test
    @DisplayName("돈이 입력됐는지 확인")
    void 돈_입력() {
        Money money = new Money(500000);
        assertThat(money.getMoney()).isEqualTo(500000);
    }

    @DisplayName("로또를 얼마나 살수있는지 확인")
    @ParameterizedTest
    @CsvSource(value = { "15000:15", "1000:1", "500:0", "7500:7" }, delimiter = ':')
    void 로또_구매가능수량_확인(int money, int expected) {
        assertThat(new Money(money).buyableQuantity()).isEqualTo(expected);
    }
}
