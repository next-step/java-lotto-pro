package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    void test() {
        LottoReports lottoReports = new LottoReports(lottoRank, new LottoMoney("10000"));
        assertEquals(1, lottoReports.countOfFirst());
        assertEquals(1, lottoReports.countOfSecond());
        assertEquals(1, lottoReports.countOfThird());
        assertEquals(1, lottoReports.countOfFifty());
    }
}
