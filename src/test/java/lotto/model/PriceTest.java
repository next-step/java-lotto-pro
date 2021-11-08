package lotto.model;

import lotto.model.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @DisplayName("금액을 나눠서 로또를 몇개 사는지 계산하는 기능")
    @Test
    void divisionPrice() {
        assertThat(Price.numberPurchases(14000)).isEqualTo(14);
    }
}
