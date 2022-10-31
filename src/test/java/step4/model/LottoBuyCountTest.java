package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.LottoFormatException;
import step3.model.LottoBuyCount;
import step3.model.Money;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또_구입_개수_WRAPPING_클래스")
public class LottoBuyCountTest {

    @DisplayName("입력된_금액에_맞추어_로또_구매_개수_조회")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10"}, delimiter = ':')
    void LottoBuyCount_pass_01(int money, int count) {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(new Money(money));
        assertThat(lottoBuyCount).isEqualTo(new LottoBuyCount(count));

    }

    @DisplayName("숫자로_입력된_값이_음수면_에러반환")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100"})
    public void LottoBuyCount_fail_02(int money) {
        assertThatThrownBy(() -> new LottoBuyCount(money))
                .isInstanceOf(LottoFormatException.class);
    }
}
