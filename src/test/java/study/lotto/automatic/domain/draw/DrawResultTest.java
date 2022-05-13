package study.lotto.automatic.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DrawResultTest {
    private DrawResult drawResult;

    @BeforeEach
    void setUp() {
        Map<Division, Long> result = generateFeatures();
        drawResult = new DrawResult(result);
    }

    @Test
    @DisplayName("등수를 입력하면 당첨된 로또 개수를 반환한다.")
    void 당첨결과_확인() {
        assertAll(() -> assertThat(drawResult.numberOfWin(Division.DIVISION_ONE)).isZero(),
                () -> assertThat(drawResult.numberOfWin(Division.DIVISION_TWO)).isZero(),
                () -> assertThat(drawResult.numberOfWin(Division.DIVISION_THREE)).isZero(),
                () -> assertThat(drawResult.numberOfWin(Division.DIVISION_FOUR)).isOne());
    }

    @Test
    @DisplayName("전체 당첨결과를 순서대로 반환한다.")
    void 전체_당첨결과_확인() {
        Map<Division, Long> allDrawResult = drawResult.get();
        assertThat(allDrawResult).containsExactly(
                entry(Division.DIVISION_FOUR, 1L),
                entry(Division.DIVISION_THREE, 0L),
                entry(Division.DIVISION_TWO, 0L),
                entry(Division.DIVISION_ONE, 0L));
    }

    @Test
    @DisplayName("전체 당첨금액 합계를 구한다.")
    void 전체_당첨금액_반환() {
        assertThat(drawResult.getAllPrize()).isEqualTo(new BigDecimal(5000));
    }

    @Test
    @DisplayName("로또 구입 금액대비 수익률을 계산한다.")
    void 수익률_계산() {
        assertThat(drawResult.earningsRate(BigDecimal.valueOf(14000))).isEqualTo(BigDecimal.valueOf(0.35));
    }

    private Map<Division, Long> generateFeatures() {
        Map<Division, Long> result = new LinkedHashMap<>();
        result.put(Division.DIVISION_FOUR, 1L);
        result.put(Division.DIVISION_THREE, 0L);
        result.put(Division.DIVISION_TWO, 0L);
        result.put(Division.DIVISION_ONE, 0L);
        return result;
    }
}
