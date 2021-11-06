package lotto;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @DisplayName("로또 결과들 생성 테스트")
    @Test
    void constructLottoResults_success() {
        LottoResults lottoResults = new LottoResults(Arrays.asList(LottoResult.THREE, LottoResult.NONE));
        assertThat(lottoResults).isEqualTo(new LottoResults(Arrays.asList(LottoResult.THREE, LottoResult.NONE)));
    }

    @DisplayName("수익률 계산 테스트")
    @Test
    void calculateEarningRate_success() {
        LottoResults lottoResults = new LottoResults(
            Arrays.asList(LottoResult.THREE, LottoResult.THREE, LottoResult.NONE, LottoResult.NONE));
        assertThat(lottoResults.calculateEarningRate()).isEqualTo(new EarningRate(BigDecimal.valueOf(2.5)));
    }

    @DisplayName("로또 결과물 메시지 생성 테스트")
    @Test
    void makePrintableMessage() {
        LottoResults lottoResults = new LottoResults(
            Arrays.asList(LottoResult.THREE, LottoResult.NONE, LottoResult.FIVE));
        assertThat(lottoResults.makePrintableMessage()).isEqualTo(
            "3개 일치 (5000원)- 1개\n"
                + "4개 일치 (50000원)- 0개\n"
                + "5개 일치 (1500000원)- 1개\n"
                + "6개 일치 (2000000000원)- 0개"
        );
    }
}
