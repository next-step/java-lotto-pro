package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static domain.LottoWinning.*;
import static domain.strategy.RandomNumberGenerateStrategy.DEFAULT;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {
    @Test
    void 일치한_번호를_계산() {
        List<Set<Integer>> selfPickNumbers = Arrays.asList(
            new HashSet<>(Arrays.asList(1, 2, 10, 11, 12, 13)),
            new HashSet<>(Arrays.asList(1, 2, 3, 10, 11, 12)),
            new HashSet<>(Arrays.asList(1, 2, 3, 4, 10, 11)),
            new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 10)),
            new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)));
        Lottos lottos = new Lottos(new SelfPickLottos(selfPickNumbers),
                QuickPickLottos.of(1000, (numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        LottoResult lottoResult = LottoResult.of(lottos, new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), new BonusWinningNumber(7)));

        assertThat(lottoResult.countOfMatch(FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countOfMatch(SECOND_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countOfMatch(THIRD_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countOfMatch(FOURTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countOfMatch(FIFTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countOfMatch(NONE)).isEqualTo(1);
        assertThat(lottoResult.earningRate()).isEqualTo(338592.5f);
    }

    @Test
    void 로또를_구매하지_않은_경우_수익률_예외처리() {
        Lottos lottos = new Lottos(new SelfPickLottos(Collections.emptyList()), QuickPickLottos.of(0, DEFAULT));
        LottoResult lottoResult = LottoResult.of(lottos,
                new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), new BonusWinningNumber(7)));
        assertThat(lottoResult.earningRate()).isEqualTo(0.0f);
    }
}
