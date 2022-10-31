package study.step3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 순위_구하기() {
        Numbers winLottoNumbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers lottoNumbers = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        lotto.rank(winLottoNumbers);

        assertThat(lotto.isSameRank(Rank.FIRST)).isTrue();
    }
}
