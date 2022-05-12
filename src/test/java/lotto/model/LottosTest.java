package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void creator() {
        Lottos lottos = new Lottos(5);
        assertEquals(5, lottos.getQuantity());
    }

    @Test
    void getResults() {
        Lottos lottos = new Lottos(5);
        List<Result> results = lottos.getResults(new Lotto());
        assertEquals(5, results.size());
    }
}