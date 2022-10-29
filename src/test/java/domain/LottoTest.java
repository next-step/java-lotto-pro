package domain;

import static domain.LottoWinning.FIRST_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 일치한_번호_개수에_따른_당첨() {
        Lotto lotto = new Lotto((numberPool, size) -> Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lotto.findWinning(winningNumbers)).isEqualTo(FIRST_PRIZE);
    }
}
