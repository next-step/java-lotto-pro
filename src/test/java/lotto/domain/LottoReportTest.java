package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoReportTest {

    private List<LottoRank> lottoRanks;
    private LottoReport lottoReport;

    @BeforeEach
    void setUp() {
        lottoRanks = new ArrayList<>();
        lottoRanks.add(LottoRank.FAIL);
        lottoRanks.add(LottoRank.THIRD);
        lottoRanks.add(LottoRank.THIRD);
        lottoRanks.add(LottoRank.FOURTH);
        lottoRanks.add(LottoRank.SECOND);
        lottoReport = new LottoReport(lottoRanks);
    }

    @Test
    @DisplayName("로또가 등수에 맞은 갯수를 구한다.")
    void collectCount() {
        assertAll(()-> {
            assertThat(lottoReport.lottoResultCount(LottoRank.FAIL)).isEqualTo(1);
            assertThat(lottoReport.lottoResultCount(LottoRank.THIRD)).isEqualTo(2);
            assertThat(lottoReport.lottoResultCount(LottoRank.FOURTH)).isEqualTo(1);
            assertThat(lottoReport.lottoResultCount(LottoRank.SECOND)).isEqualTo(1);
        });
    }


    @Test
    @DisplayName("로또 결과에 금액의 합계를 구한다.")
    void rewordTotalMoney() {
        assertThat(lottoReport.rewordTotalMoney())
                .isEqualTo(1_605_000);
    }

    @Test
    @DisplayName("로또 결과의 수익률을 구한다.")
    void lottoYield(){
        assertThat(lottoReport.yield()).isEqualTo(321);
    }


}
