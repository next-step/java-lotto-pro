package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LottosTest {

    @Test
    void 로또들의_총_구입_금액_반환() {
        Lottos lottos = new Lottos(new Money(5500));
        assertThat(lottos.findTotalPrice()).isEqualTo(new Money(5000));
    }
}