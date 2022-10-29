package domain;

import static domain.LottoWinning.FIRST_PRIZE;
import static domain.LottoWinning.FOURTH_PRIZE;
import static domain.LottoWinning.NONE;
import static domain.LottoWinning.SECOND_PRIZE;
import static domain.LottoWinning.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    void 일치한_번호를_계산() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto((numberPool, size) -> Arrays.asList(1, 2, 10, 11, 12, 13)),
            new Lotto((numberPool, size) -> Arrays.asList(1, 2, 3, 10, 11, 12)),
            new Lotto((numberPool, size) -> Arrays.asList(1, 2, 3, 4, 10, 11)),
            new Lotto((numberPool, size) -> Arrays.asList(1, 2, 3, 4, 5, 10)),
            new Lotto((numberPool, size) -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers);

        assertThat(lottoResult.findWinning(FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.findWinning(SECOND_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.findWinning(THIRD_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.findWinning(FOURTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.findWinning(NONE)).isEqualTo(1);
        assertThat(lottoResult.getEarningRate()).isEqualTo(400311.0f);
    }
}
