package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoReportsTest {
    private final List<Rank> lottoRank = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottoRank.add(Rank.FIRST);
        lottoRank.add(Rank.SECOND);
        lottoRank.add(Rank.THIRD);
        lottoRank.add(Rank.FIFTH);
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
        assertEquals(200155.5, lottoReports.getProfitRatio());
    }
}
