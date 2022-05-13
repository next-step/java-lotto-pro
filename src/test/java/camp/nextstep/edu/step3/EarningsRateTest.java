package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EarningsRateTest {

    @DisplayName("총당첨금과 구매금액 정보를 입력 받는다.")
    @Test
    void createTest() {
        assertThat(new EarningsRate(5000, 14000))
                .isEqualTo(new EarningsRate(5000, 14000));
    }

    @DisplayName("rate 값이 같으면 동일한 객체이다.")
    @Test
    void sameTest() {
        assertThat(new EarningsRate(10000, 2000))
                .isEqualTo(new EarningsRate(50000, 10000));
    }

    @DisplayName("출력 값 테스트")
    @ParameterizedTest
    @MethodSource("provideTotalAmountAndBuyAmountAndExpectedMessage")
    void displayTest(final double totalAmount, final int buyAmount, final String expectedMessage) {
        assertThat(new EarningsRate(totalAmount, buyAmount).toString())
                .isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> provideTotalAmountAndBuyAmountAndExpectedMessage() {
        return Stream.of(
                Arguments.of(5000, 14000, "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
                Arguments.of(5000, 5000, "총 수익률은 1.00입니다.(기준이 1이기 때문에 결과적으로 같다라는 의미임)"),
                Arguments.of(5000, 4000, "총 수익률은 1.25입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)")
        );
    }
}
