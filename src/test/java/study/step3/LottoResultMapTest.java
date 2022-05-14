package study.step3;

import static org.assertj.core.api.Assertions.assertThat;

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
}
