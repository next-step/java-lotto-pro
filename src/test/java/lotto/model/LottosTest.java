package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 로또의_갯수를_알려준다() {
        Lottos lottos = new Lottos(
            Arrays.asList(
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6))
            )
        );

        assertThat(lottos.count()).isEqualTo(2L);
    }

    @Test
    void 로또_구입_총비용_계산() {
        Lottos lottos = new Lottos(
            Arrays.asList(
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6))
            )
        );
        assertThat(lottos.getTotalSpent()).isEqualTo(new Money(6000L));
    }

    @Test
    void 로또_병합_개발() {
        Lottos lottos = new Lottos(
            Arrays.asList(
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6))
            )
        );
        Lottos mergedLotto = lottos.merge(
            new Lottos(
                Arrays.asList(
                    new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6))
                )
            )
        );

        assertThat(mergedLotto).isEqualTo(
            new Lottos(
                Arrays.asList(
                    new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6)),
                    new Lotto(LottoNumber.of(1, 2, 3, 4, 5, 6))
                )
            )
        );
    }

}
