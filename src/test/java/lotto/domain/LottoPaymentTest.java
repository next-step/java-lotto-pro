package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoPaymentTest {

    @ParameterizedTest
    @ValueSource(strings = {"가나다", "abc", "12!"})
    @DisplayName("입력받은 구매금액에 문자는 올 수 없다.")
    void 가격_문자_예외_테스트(String payment){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoPayment(payment)
        );
    }

    @Test
    @DisplayName("입력받은 구매금액에 음수는 올 수 없다.")
    void 가격_음수_예외_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoPayment("-10000")
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "15000:15", "4000:4", "1500:1"}, delimiterString = ":")
    @DisplayName("입력받은 구매금액으로 구매한 로또의 갯수를 구한다.(개당 1000원)")
    void 로또_구매_갯수_테스트(String payment, int count){
        assertThat(new LottoPayment(payment).buyLotto()).isEqualTo(count);
    }
}
