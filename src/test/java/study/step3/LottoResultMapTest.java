package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.enumtype.LottoWinningType;

class LottoResultMapTest {
    @Test
    @DisplayName("당첨개수 확인")
    void test() {
        LottoResultMap lottoResultMap = new LottoResultMap();
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_0, new Lotto());
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_0, new Lotto());
        assertThat(lottoResultMap.matchCount(LottoWinningType.MATCH_COUNT_0)).isEqualTo(2);
    }

    @Test
    @DisplayName("전체 로또 개수")
    void allItemSize() {
        LottoResultMap lottoResultMap = new LottoResultMap();
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_0, new Lotto());
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_0, new Lotto());
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_1, new Lotto());
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_2, new Lotto());
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_3, new Lotto());
        lottoResultMap.append(LottoWinningType.MATCH_COUNT_6, new Lotto());
        assertThat(lottoResultMap.allItemSize()).isEqualTo(6);
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

        assertThat(lottoResultMap.calcLottoYield()).isEqualTo(0f);
    }

    @Test
    @DisplayName("수익률 계산 - 1등")
    void calcLottoYield_1() {
        LottoReport lottoReport = new LottoReport(Collections.singletonList(
                new Lotto("1,2,3,4,5,6")
        ), new Lotto("1,2,3,4,5,6"));
        LottoResultMap lottoResultMap = lottoReport.analyze();
        assertThat(lottoResultMap.calcLottoYield()).isEqualTo(200000000f);
    }
}
