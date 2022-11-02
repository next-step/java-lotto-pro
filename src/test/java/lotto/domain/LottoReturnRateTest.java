package lotto.domain;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoReturnRateTest {

    @Test
    @DisplayName("수익률을 계산한다.")
    void 수익률_계산(){
        assertThat(new LottoReturnRate(15000L, 20000))
                .isEqualTo(new LottoReturnRate(new BigDecimal(String.valueOf(0.75))));
    }

    @Test
    @DisplayName("구매금액 0원에 대한 예외 처리")
    void 구매금액_0원_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoReturnRate(15000L, 0)
        );
    }
}
