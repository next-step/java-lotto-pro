package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPaymentTest {

    @Test
    @DisplayName("입력받은 구매금액에 문자는 올 수 없다.")
    void 가격_문자_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoPayment("가나다")
        );
    }

    @Test
    @DisplayName("입력받은 구매금액에 음수는 올 수 없다.")
    void 가격_음수_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoPayment("-10000")
        );
    }
}
