package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TotalMoneyTest {
    @Test
    void 생성() {
        assertThat(new TotalMoney(1000)).isEqualTo(new TotalMoney(1000));
    }

    @Test
    void 값_확인() {
        TotalMoney totalMoney = new TotalMoney(1000);
        assertThat(totalMoney.getTotalMoney()).isEqualTo(1000);
    }
}
