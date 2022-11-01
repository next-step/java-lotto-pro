package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoCoinTest {


    @Test
    @DisplayName("로또 코인은 Money 1000원 이상을 입력받아 생성한다")
    void create_1000원() {
        // given
        Money money = Money.of(1000);

        // when
        LottoCoin lottoCoin = LottoCoin.of(money);

        // then
        assertThat(lottoCoin).isEqualTo(LottoCoin.of(money));
    }

    @Test
    @DisplayName("로또 코인은 Money 900원을 입력 받으면 생성할 수 없다")
    void create_900원() {
        // given
        Money money = Money.of(900);

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoCoin.of(money);
        });
    }

    @Test
    @DisplayName("3개의 로또 코인은 pop을 이용해서 2개를 꺼낼 수 있다")
    void pop_2개() {
        // given
        Money money = Money.of(3000);
        LottoCoin lottoCoin = LottoCoin.of(money);

        // then
        LottoCoin popLottoCoin = lottoCoin.pop(2);

        // then
        assertThat(popLottoCoin).isEqualTo(LottoCoin.of(Money.of(2000)));
    }

    @Test
    @DisplayName("3개의 로또 코인은 pop을 이용해서 4개를 꺼낼 수 없다")
    void pop_4개() {
        // given
        Money money = Money.of(3000);
        LottoCoin lottoCoin = LottoCoin.of(money);

        // expect
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoCoin.pop(4);
        });
    }


}
