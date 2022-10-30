package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCalculatorTest {

    @Test
    @DisplayName("로또 계산기 생성")
    void create() {
        Money money = new Money(10000);
        assertThat(new LottoCalculator(money)).isEqualTo(new LottoCalculator(money));
    }

    @Test
    @DisplayName("로또 구매 최소비용 이상인지 확인")
    void validateMoney() {
        assertThatThrownBy(() -> {
            new LottoCalculator(new Money(500));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구매 가능 갯수 계산")
    void availableToPurchaseCount() {
        assertThat(new LottoCalculator(new Money(5000)).availableToPurchaseCount()).isEqualTo(5);
    }

}
