package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void create() {
        final Lottos lottos = new Lottos(3, 2);
        assertThat(lottos.getTotalCount()).isEqualTo(3);
        assertThat(lottos.getAutoCount()).isEqualTo(1);
        assertThat(lottos.getManualCount()).isEqualTo(2);
    }

    @Test
    void generateManual() {
        final Lottos lottos = new Lottos(3, 2);
        lottos.generateManual(
                Arrays.asList(
                        "1, 2, 3, 4, 5, 6",
                        "2, 3, 4, 5, 6, 7"
                )
        );

        final List<LottoTicket> expected = Arrays.asList(
                LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
                LottoTicket.of(Arrays.asList(2, 3, 4, 5, 6, 7))
        );
        assertThat(lottos.hasEqualTickets(expected)).isTrue();
    }

    @Test
    void generateAuto() {
        final Lottos lottos = new Lottos(3, 0);
        lottos.generateAuto();
        assertThat(lottos.getManualCount()).isEqualTo(0);
        assertThat(lottos.getAutoCount()).isEqualTo(3);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 4, 5, 14, 50})
    void generateAllAuto(int size) {
        final Lottos lottos = Lottos.generateAllAuto(size);
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(size);
    }

    @Test
    void calculateWinning() {
        final Lottos lottos = Lottos.generateAllAuto(5);
        final WinTicket winTicket = WinTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        final LottoResult lottoResult = lottos.calculateWinning(winTicket);

        assertThat(lottoResult.size()).isEqualTo(5);
    }

    @Test
    void getSellingPrice() {
        final Lottos lottos = Lottos.generateAllAuto(5);
        final Money price = lottos.calculateTotalSellingPrice();
        assertThat(price).isEqualTo(new Money(5 * 1000));
    }
}
