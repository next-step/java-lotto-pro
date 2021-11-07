package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoReportsTest {
    private final List<Rank> lottoRank = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoRank.addAll(Arrays.asList(
            Rank.FIRST, Rank.SECOND, Rank.THIRD,
            Rank.FOURTH, Rank.FIFTH
        ));
    }

    @DisplayName("당첨 등수에 대한 테스트")
    @Test
    void getRankCount() {
        LottoReports lottoReports = new LottoReports(lottoRank, new LottoMoney("10000"));
        assertEquals(1, lottoReports.getCountOfFirst());
        assertEquals(1, lottoReports.getCountOfSecond());
        assertEquals(1, lottoReports.getCountOfThird());
        assertEquals(1, lottoReports.getCountOfFifty());
    }

    @DisplayName("수익률 테스트")
    @Test
    void getProfitRatio() {
        LottoReports lottoReports = new LottoReports(lottoRank, new LottoMoney("10000"));
        assertEquals(203150.5, lottoReports.getProfitRatio());
    }
}
