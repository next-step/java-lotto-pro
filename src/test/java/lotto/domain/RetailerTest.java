package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetailerTest {

    @Test
    @DisplayName("로또를 구매할 수 있다.")
    void buy_size() {
        final Playslips playslips = Retailer.buy(new Price(14_000L));
        assertThat(playslips.size()).isEqualTo(14);
    }
}
