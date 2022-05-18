package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DrawResult;

class LottosTest {
    @Test
    @DisplayName("당첨번호를 입력하면 당첨 결과를 받을 수 있다.")
    void 당첨결과_확인() {
        Lottos lottos = fixturesLotto();
        Lotto winningLotto = Lotto.from(Arrays.asList(1, 3, 5, 22, 44, 45));

        DrawResult expected = getExpectedDrawResult();
        assertThat(lottos.findWinnings(winningLotto, new LottoNumber(14))).isEqualTo(expected);
    }

    private DrawResult getExpectedDrawResult() {
        return new DrawResult(Arrays.asList(
                new DivisionResult(Division.DIVISION_ONE, 0L),
                new DivisionResult(Division.DIVISION_TWO, 1L),
                new DivisionResult(Division.DIVISION_THREE, 0L),
                new DivisionResult(Division.DIVISION_FOUR, 0L),
                new DivisionResult(Division.DIVISION_FIVE, 1L)
        ));
    }

    private Lottos fixturesLotto() {
        List<Lotto> lottoList = Arrays.asList(
                Lotto.from(Arrays.asList(8, 21, 23, 41, 42, 43)),
                Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 38)),
                Lotto.from(Arrays.asList(7, 11, 16, 35, 36, 44)),
                Lotto.from(Arrays.asList(13, 14, 16, 38, 42, 45)),
                Lotto.from(Arrays.asList(1, 3, 5, 14, 22, 45)));
        Lottos lottos = new Lottos(lottoList);
        return lottos;
    }
}
