package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("Lottos 생성 테스트")
    void Lottos_생성_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertThat(lottos.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("Lottos price 테스트")
    void Lottos_price_테스트(){
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
        assertThat(lottos.price()).isEqualTo(Money.LOTTO_PRICE);
    }
}
