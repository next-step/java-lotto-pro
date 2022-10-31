package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoReturnRateTest {

    @Test
    @DisplayName("수익률을 계산한다.")
    void 수익률_계산(){
        LottoReturnRate returnRate = new LottoReturnRate(15000, 20000);
        assertThat(returnRate).isEqualTo(new LottoReturnRate(0.75));
    }

    @Test
    @DisplayName("구매금액 0원에 대한 예외 처리")
    void 구매금액_0원_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoReturnRate(15000, 0)
        );
    }
}
