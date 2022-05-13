package study.lotto.automatic.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        assertAll(() -> assertThat(drawResult.numberOfWin(Division.DIVISION_ONE)).isOne(),
                () -> assertThat(drawResult.numberOfWin(Division.DIVISION_TWO)).isZero(),
                () -> assertThat(drawResult.numberOfWin(Division.DIVISION_THREE)).isEqualTo(2),
                () -> assertThat(drawResult.numberOfWin(Division.DIVISION_FOUR)).isEqualTo(5));
    }

    @Test
    @DisplayName("전체 당첨결과를 순서대로 반환한다.")
    void 전체_당첨결과_확인() {
        Map<Division, Long> allDrawResult = drawResult.get();
        assertThat(allDrawResult).containsExactly(
                entry(Division.DIVISION_FOUR, 5L),
                entry(Division.DIVISION_THREE, 2L),
                entry(Division.DIVISION_TWO, 0L),
                entry(Division.DIVISION_ONE, 1L));
    }

    private Map<Division, Long> generateFeatures() {
        Map<Division, Long> result = new LinkedHashMap<>();
        result.put(Division.DIVISION_FOUR, 5L);
        result.put(Division.DIVISION_THREE, 2L);
        result.put(Division.DIVISION_TWO, 0L);
        result.put(Division.DIVISION_ONE, 1L);
        return result;
    }
}
