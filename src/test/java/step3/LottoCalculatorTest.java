package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoCalculator;
import step3.model.LottoGenerator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCalculatorTest {
    private LottoCalculator lottoCalculator = new LottoCalculator();

    @Test
    @DisplayName("지난주 우승 번호 유효성 테스트")
    void 지난주_우승_번호_유효성_테스트() {
        assertThatThrownBy(() -> lottoCalculator.validateLastWeekWinner("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
