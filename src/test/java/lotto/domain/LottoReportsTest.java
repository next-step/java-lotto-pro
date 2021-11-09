package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    @DisplayName("당첨 등수가 제대로 카운트 되는지 확인한다")
    @Test
    void getRankCount() {
        LottoReports lottoReports = new LottoReports(lottoRank, new LottoMoney("10000"));
        assertEquals(1, lottoReports.getCountOfFirst());
        assertEquals(1, lottoReports.getCountOfSecond());
        assertEquals(1, lottoReports.getCountOfThird());
        assertEquals(1, lottoReports.getCountOfFourth());
        assertEquals(1, lottoReports.getCountOfFifty());
    }

    @DisplayName("1등 수익률을 제대로 계산하는지 확인한다")
    @Test
    void getFirstProfitRatio() {
        LottoReports lottoReports = new LottoReports(Collections.singletonList(Rank.FIRST), new LottoMoney("1000"));
        assertEquals(2000000.0, lottoReports.getProfitRatio());
    }

    @DisplayName("2등 수익률을 제대로 계산하는지 확인한다")
    @Test
    void getSecondProfitRatio() {
        LottoReports lottoReports = new LottoReports(Collections.singletonList(Rank.SECOND), new LottoMoney("1000"));
        assertEquals(30000.0, lottoReports.getProfitRatio());
    }

    @DisplayName("3등 수익률을 제대로 계산하는지 확인한다")
    @Test
    void getThirdProfitRatio() {
        LottoReports lottoReports = new LottoReports(Collections.singletonList(Rank.THIRD), new LottoMoney("1000"));
        assertEquals(1500.0, lottoReports.getProfitRatio());
    }

    @DisplayName("4등 수익률을 제대로 계산하는지 확인한다")
    @Test
    void getFourthProfitRatio() {
        LottoReports lottoReports = new LottoReports(Collections.singletonList(Rank.FOURTH), new LottoMoney("1000"));
        assertEquals(50.0, lottoReports.getProfitRatio());
    }

    @DisplayName("5등 수익률을 제대로 계산하는지 확인한다")
    @Test
    void getFifthProfitRatio() {
        LottoReports lottoReports = new LottoReports(Collections.singletonList(Rank.FIFTH), new LottoMoney("1000"));
        assertEquals(5.0, lottoReports.getProfitRatio());
    }

    @DisplayName("미당첨 수익률을 제대로 계산하는지 확인한다")
    @Test
    void getMissProfitRatio() {
        LottoReports lottoReports = new LottoReports(Collections.singletonList(Rank.MISS), new LottoMoney("1000"));
        assertEquals(0.0, lottoReports.getProfitRatio());
    }
}
