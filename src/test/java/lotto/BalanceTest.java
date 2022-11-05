package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BalanceTest {
    @Test
    void 생성() {
        assertThat(new Balance(10000)).isEqualTo(new Balance(10000));
    }

    @Test
    void 구매_가능_횟수() {
        assertThat(new Balance(10000).getPurchasableCount()).isEqualTo(10);
    }

    @Test
    void 구매_횟수가_증가할_때마다_잔고_차감() {
        Balance balance = new Balance(10000);
        balance.minusBalance();
        assertThat(balance.getBalance()).isEqualTo(9000);
    }
}
