package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
    private final String[] input = {
            "1,2,3,4,5,6",
            "1,3,5,7,9,11",
            "2,4,6,8,10,12"
    };

    @DisplayName("로또들 구매 이후 로또들 사이즈 테스트")
    @Test
    void lottosSize() {
        Lottos lottos = Lottos.buy(input);
        assertThat(lottos.readOnlyLottos()).hasSize(3);
    }
}
