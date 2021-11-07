package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 14, 50})
    void generateAuto(int size) {
        final Lottos lottos = Lottos.generateAuto(size);
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    void calculateWinning() {
        final Lottos lottos = Lottos.generateAuto(5);
        final LottoNumbers winNumbers = LottoNumbers.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        final Winnings winnings = lottos.calculateWinning(winNumbers);

        assertThat(winnings.size()).isEqualTo(5);
    }
}
