package study.step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.enumtype.LottoWinningType;

class LottoReportTest {
    @Test
    @DisplayName("잘못된 초기값 - 리스트 크기 0")
    void constructor_listSize0() {
        List<Lotto> emptyLottos = Collections.emptyList();
        Lotto winningLotto = new Lotto();

        assertThatThrownBy(() -> new LottoReport(
                emptyLottos,
                winningLotto
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 초기값 - 당첨번호 널")
    void constructor_winningLottoIsNull() {
        List<Lotto> emptyLottos = Collections.singletonList(new Lotto());
        Lotto winningLotto = null;

        assertThatThrownBy(() -> new LottoReport(
                emptyLottos,
                winningLotto
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 통계")
    void analyze_matchCount() {
        LottoReport lottoReport = new LottoReport(Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,7"),
                new Lotto("1,2,3,4,7,8"),
                new Lotto("1,2,3,7,8,9"),
                new Lotto("1,2,3,7,8,9")
        ), new Lotto("1,2,3,4,5,6"));

        LottoResultMap lottoResultMap = lottoReport.analyze();

        assertThat(lottoResultMap.matchCount(LottoWinningType.MATCH_COUNT_6)).isEqualTo(2);
        assertThat(lottoResultMap.matchCount(LottoWinningType.MATCH_COUNT_5)).isEqualTo(1);
        assertThat(lottoResultMap.matchCount(LottoWinningType.MATCH_COUNT_0)).isZero();
    }

    @Test
    @DisplayName("수익률 계산 - 0")
    void calcLottoYield_0() {
        LottoReport lottoReport = new LottoReport(Arrays.asList(
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,6"),
                new Lotto("1,2,3,4,5,7"),
                new Lotto("1,2,3,4,7,8"),
                new Lotto("1,2,3,7,8,9"),
                new Lotto("1,2,3,7,8,9")
        ), new Lotto("11,12,13,14,15,16"));

        LottoResultMap lottoResultMap = lottoReport.analyze();

        assertThat(lottoReport.calcLottoYield(lottoResultMap)).isEqualTo(0f);
    }

    @Test
    @DisplayName("수익률 계산 - 1등")
    void calcLottoYield_1등() {
        LottoReport lottoReport = new LottoReport(Collections.singletonList(
                new Lotto("1,2,3,4,5,6")
        ), new Lotto("1,2,3,4,5,6"));
        LottoResultMap lottoResultMap = lottoReport.analyze();
        assertThat(lottoReport.calcLottoYield(lottoResultMap)).isEqualTo(200000000f);
    }
}
