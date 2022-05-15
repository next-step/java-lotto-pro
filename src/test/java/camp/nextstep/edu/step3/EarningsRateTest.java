package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EarningsRateTest {

    @DisplayName("총수익률 정보를 가진다.")
    @Test
    void createTest() {
        assertThat(new EarningsRate(3.5)).isEqualTo(new EarningsRate(3.5));
    }

    @DisplayName("출력 값 테스트")
    @ParameterizedTest
    @MethodSource("provideTotalAmountAndBuyAmountAndExpectedMessage")
    void displayTest(final double rate, final String expectedMessage) {
        assertThat(new EarningsRate(rate).toString()).isEqualTo(expectedMessage);
    }

    private static Stream<Arguments> provideTotalAmountAndBuyAmountAndExpectedMessage() {
        return Stream.of(
                Arguments.of(0.35, "총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
                Arguments.of(1.00, "총 수익률은 1.00입니다.(기준이 1이기 때문에 결과적으로 같다라는 의미임)"),
                Arguments.of(1.25, "총 수익률은 1.25입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)")
        );
    }
}
