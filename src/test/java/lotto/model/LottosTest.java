package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @Test
    void create() {
        final Lottos lottos = new Lottos(3, 2);
        assertThat(lottos.getTotalCount()).isEqualTo(3);
        assertThat(lottos.getAutoCount()).isEqualTo(1);
        assertThat(lottos.getManualCount()).isEqualTo(2);
    }

    @Test
    void create_실패() {
        assertThatThrownBy(() -> new Lottos(3, 10))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lottos(3, -1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lottos(-3, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void generateManual() {
        final Lottos lottos = new Lottos(2, 2,
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(2, 3, 4, 5, 6, 7)
                )
        );

        final List<LottoTicket> expected = Arrays.asList(
                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                LottoTicket.of(Arrays.asList(2, 3, 4, 5, 6, 7))
        );
        assertThat(lottos.hasEqualTickets(expected)).isTrue();
    }

    @Test
    void generateManual_숫자순서다름() {
        final Lottos lottos = new Lottos(1, 1,
                Collections.singletonList(Arrays.asList(6, 5, 4, 3, 2, 1)));

        final List<LottoTicket> expected = Collections.singletonList(
                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        assertThat(lottos.hasEqualTickets(expected)).isTrue();
    }

    @Test
    void generateAuto() {
        final Lottos lottos = new Lottos(3, 0);
        assertThat(lottos.getManualCount()).isEqualTo(0);
        assertThat(lottos.getAutoCount()).isEqualTo(3);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 14, 50})
    void generateAllAuto(int size) {
        final Lottos lottos = Lottos.ofAllAuto(size);
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    void calculateWinning() {
        final Lottos lottos = Lottos.ofAllAuto(5);
        final WinTicket winTicket = WinTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        final LottoResult lottoResult = lottos.calculateWinning(winTicket);

        assertThat(lottoResult.size()).isEqualTo(5);
    }

    @Test
    void getSellingPrice() {
        final Lottos lottos = Lottos.ofAllAuto(5);
        final Money price = lottos.calculateTotalSellingPrice();
        assertThat(price).isEqualTo(new Money(5 * 1000));
    }
}
