package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @Test
    void match_test() {
        WinningLotto winningLotto = WinningLotto.from(LottoNumbers.from(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumbers lottoNumbers = LottoNumbers.from(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoRank rank = winningLotto.match(lottoNumbers);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }
}
