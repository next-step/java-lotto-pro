package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @DisplayName("Hit Three 부터 값을 저장하고 있다.")
    @ParameterizedTest
    @MethodSource("provideParametersFromCreateTest")
    void createTest(final Hit[] input, final Hit[] other) {
        assertThat(new LottoResult(input)).isEqualTo(new LottoResult(other));
    }

    private static Stream<Arguments> provideParametersFromCreateTest() {
        return Stream.of(
                Arguments.of(new Hit[]{Hit.ONE, Hit.ALL}, new Hit[]{Hit.ALL}),
                Arguments.of(new Hit[]{Hit.ONE, Hit.TWO, Hit.THREE, Hit.FOUR}, new Hit[]{Hit.THREE, Hit.FOUR})
        );
    }

    @DisplayName("result 메소드 호출시 총 수익률을 반환한다.")
    @ParameterizedTest
    @MethodSource("provideResultInputAndToTalAmount")
    void resultTest(final Hit[] input, final int totalAmount) {
        final int userBuyAmount = 14000;
        assertThat(new LottoResult(input).result(userBuyAmount)).isEqualTo(new EarningsRate(totalAmount, userBuyAmount));
    }

    private static Stream<Arguments> provideResultInputAndToTalAmount() {
        return Stream.of(
                Arguments.of(new Hit[]{Hit.ONE, Hit.TWO, Hit.THREE, Hit.FOUR}, (Hit.THREE.cost(1) + Hit.FOUR.cost(1)),
                        Arguments.of(new Hit[]{Hit.ZERO}, Hit.ZERO.cost(1)))
        );
    }

    @DisplayName("출력 테스트")
    @Test
    void printTest() {
        assertThat(new LottoResult(new Hit[] {Hit.THREE, Hit.FOUR}).toString())
                .isEqualTo("3개 일치 (5000원)- 1개\n" + "4개 일치 (50000원)- 1개\n" + "5개 일치 (1500000원)- 0개\n" + "6개 일치 (2000000000원)- 0개\n");
    }
}
