package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp() {
        Lotto first = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));
        Lotto second = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 15"));
        Lotto fifth = new Lotto(new LottoNumbers("2, 4, 5, 7, 9, 11"));
        lottos = new Lottos(Arrays.asList(first, second, fifth));
    }

    @Test
    void 구매한_로또의_당첨_결과를_확인한다() {
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber(15);
        Rewards checkResult = lottos.check(winningNumbers, bonusNumber);
        assertThat(checkResult.count(Rank.FIRST)).isEqualTo(1);
        assertThat(checkResult.count(Rank.SECOND)).isEqualTo(1);
        assertThat(checkResult.count(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 로또_목록_출력() {
        assertThat(lottos.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n[2, 4, 5, 7, 9, 11]");
    }
}
