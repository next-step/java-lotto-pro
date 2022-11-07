package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.exception.LottoFormatException;

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

    @DisplayName("생성자_체크")
    @Test
    public void LottoBuyCount_pass_02() {
        LottoBuyCount lottoBuyCount = new LottoBuyCount("1");
        LottoBuyCount otherBuyCount = new LottoBuyCount(1);
        assertThat(lottoBuyCount).isEqualTo(otherBuyCount);
    }


    @DisplayName("생성자_체크_문자나_음수가_들어오면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100", "a"})
    public void LottoBuyCount_fail_01(String count) {
        assertThatThrownBy(() -> new LottoBuyCount(count))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("생성자_체크_빈값이나_NULL이_들어오면_에러")
    @ParameterizedTest
    @NullSource
    @EmptySource
    void nullEmptyStrings(String text) {
        assertThatThrownBy(() -> new LottoBuyCount(text))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("숫자로_입력된_값이_음수면_에러반환")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-100"})
    public void LottoBuyCount_fail_02(int money) {
        assertThatThrownBy(() -> new LottoBuyCount(money))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("숫자간_뺄셈_체크")
    @Test
    public void LottoBuyCount_minus_01() {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(3);
        LottoBuyCount otherBuyCount = new LottoBuyCount(1);
        assertThat(lottoBuyCount.minus(otherBuyCount)).isEqualTo(new LottoBuyCount(2));
    }

    @DisplayName("숫자간_뺄셈_결과가_음수면_에러를_반환")
    @Test
    public void LottoBuyCount_minus_02() {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(1);
        LottoBuyCount otherBuyCount = new LottoBuyCount(3);
        assertThatThrownBy(() -> lottoBuyCount.minus(otherBuyCount))
                .isInstanceOf(LottoFormatException.class);
    }

    @DisplayName("equalValue_함수_테스트")
    @Test
    public void LottoBuyCount_equalValue_01() {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(1);
        assertThat(lottoBuyCount.isEqualValue(1)).isTrue();
    }

    @DisplayName("equalValue_함수_fail_테스트")
    @Test
    public void LottoBuyCount_equalValue_fail_01() {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(1);
        assertThat(lottoBuyCount.isEqualValue(0)).isFalse();
    }

    @DisplayName("isLessThan_함수_pass_테스트")
    @Test
    public void LottoBuyCount_isLessThan_pass_01() {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(1);
        assertThat(lottoBuyCount.isLessThan(new LottoBuyCount(2))).isTrue();
    }

    @DisplayName("isLessThan_함수_fail_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "100"})
    public void LottoBuyCount_isLessThan_fail_01(int otherCount) {
        LottoBuyCount lottoBuyCount = new LottoBuyCount(100);
        assertThat(lottoBuyCount.isLessThan(new LottoBuyCount(otherCount))).isFalse();
    }

}