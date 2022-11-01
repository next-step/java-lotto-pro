package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningResultTest {

    @DisplayName("당첨결과 집계 테스트입니다.")
    @Test
    // TODO : ParameterezdTest로 변경
    void 당첨결과집계() {
        WinningResult result = new WinningResult();
        result.addRank(WinningLottoRank.FOURTH);

        assertThat(result.getYield(new PurchaseAmount(14000))).isEqualTo(0.35);
    }
}
