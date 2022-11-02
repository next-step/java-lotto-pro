package domain;

import static domain.LottoWinning.FOURTH_PRIZE;
import static domain.LottoWinning.FIRST_PRIZE;
import static domain.LottoWinning.NONE;
import static domain.LottoWinning.SECOND_PRIZE;
import static domain.LottoWinning.FIFTH_PRIZE;
import static domain.LottoWinning.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    void 일치한_번호를_계산() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto((numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 10, 11, 12, 13))),
            new Lotto((numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 3, 10, 11, 12))),
            new Lotto((numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 10, 11))),
            new Lotto((numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 10))),
            new Lotto((numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))),
            new Lotto((numberPool, size) -> new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        LottoResult lottoResult = LottoResult.of(lottos,
            new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7));

        assertThat(lottoResult.getCountOfWinning(FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.getCountOfWinning(SECOND_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.getCountOfWinning(THIRD_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.getCountOfWinning(FOURTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.getCountOfWinning(FIFTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.getCountOfWinning(NONE)).isEqualTo(1);
        assertThat(lottoResult.getEarningRate()).isEqualTo(338592.5f);
    }
}
