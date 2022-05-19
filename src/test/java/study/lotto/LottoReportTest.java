package study.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.enumtype.LottoWinningType;

class LottoReportTest {
    @Test
    @DisplayName("잘못된 초기값 - 리스트 크기 0")
    void constructor_listSize0() {
        List<Lotto> emptyLottos = Collections.emptyList();
        WinningLotto winningLotto = new WinningLotto(
                new Lotto("1,2,3,4,5,7"),
                new LottoNumber(8)
        );

        assertThatThrownBy(() -> new LottoReport(
                emptyLottos,
                winningLotto
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 초기값 - 당첨번호 널")
    void constructor_winningLottoIsNull() {
        List<Lotto> emptyLottos = Collections.singletonList(new Lotto("1,2,3,4,5,7"));
        WinningLotto winningLotto = null;

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
        ), new WinningLotto(
                new Lotto("1,2,3,4,5,6"),
                new LottoNumber(33)
        ));

        LottoResultMap lottoResultMap = lottoReport.analyze();

        assertThat(lottoResultMap.matchCount(LottoWinningType.FIRST)).isEqualTo(2);
        assertThat(lottoResultMap.matchCount(LottoWinningType.THIRD)).isEqualTo(1);
        assertThat(lottoResultMap.matchCount(LottoWinningType.MISS)).isZero();
    }
}
