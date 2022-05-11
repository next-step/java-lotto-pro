package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void creator() {
        Lottos lottos = new Lottos(5);
        assertEquals(5, lottos.getQuantity());
    }
}