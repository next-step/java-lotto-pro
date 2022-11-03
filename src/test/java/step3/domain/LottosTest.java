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
        Rewards checkResult = lottos.check(new WinningLottoNumber("1, 2, 3, 4, 5, 6", 15));
        assertThat(checkResult.count(Rank.FIRST)).isEqualTo(1);
        assertThat(checkResult.count(Rank.SECOND)).isEqualTo(1);
        assertThat(checkResult.count(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 로또_목록_출력() {
        String expectedString = "[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 15]\n[2, 4, 5, 7, 9, 11]";
        assertThat(lottos.toString()).isEqualTo(expectedString);
    }

    @Test
    void 로또를_병합할_수_있다() {
        Lottos mergeLottos = lottos.merge(lottos);
        assertThat(mergeLottos.getHasLottoSize()).isEqualTo(6);
    }
}
