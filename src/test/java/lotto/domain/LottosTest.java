package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {

    @Test
    @DisplayName("로또 구매 개수")
    void purchaseLottoCnt() {
        assertThat(new Lottos(new Payment("14000")).getLottosSize()).isEqualTo(14);
    }

}
