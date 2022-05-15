package study.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.draw.Division;
import study.lotto.domain.draw.DivisionResult;
import study.lotto.domain.draw.DivisionResults;

public class LottosTest {
    @Test
    @DisplayName("당첨번호를 입력하면 당첨 결과를 받을 수 있다.")
    void 당첨결과_확인() {
        Lottos lottos = fixturesLotto();
        DivisionResults divisionResults = expectedDivisionResults();
        assertThat(lottos.findWinnings(new LottoNumbers(Arrays.asList(1, 3, 5, 22, 44, 45)))).isEqualTo(
                divisionResults);
    }

    private DivisionResults expectedDivisionResults() {
        List<DivisionResult> divisionResultList = Arrays.asList(
                new DivisionResult(Division.DIVISION_ONE, 0L),
                new DivisionResult(Division.DIVISION_TWO, 1L),
                new DivisionResult(Division.DIVISION_THREE, 0L),
                new DivisionResult(Division.DIVISION_FOUR, 1L));

        DivisionResults divisionResults = new DivisionResults(divisionResultList);
        return divisionResults;
    }

    private Lottos fixturesLotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(new LottoNumbers(Arrays.asList(8, 21, 23, 41, 42, 43))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 38))),
                new Lotto(new LottoNumbers(Arrays.asList(7, 11, 16, 35, 36, 44))),
                new Lotto(new LottoNumbers(Arrays.asList(13, 14, 16, 38, 42, 45))),
                new Lotto(new LottoNumbers(Arrays.asList(1, 3, 5, 14, 22, 45))));
        Lottos lottos = new Lottos(lottoList);
        return lottos;
    }
}
