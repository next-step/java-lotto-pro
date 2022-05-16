package camp.nextstep.edu.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static camp.nextstep.edu.step3.Hit.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HitTest {

    @DisplayName("Hit 출력시 일치 갯수와 당청금이 출력된다")
    @ParameterizedTest
    @MethodSource("provideHitAndCountAndPrizeMoney")
    void printTest(final Hit hit, final int count, final int prizeMoney) {
        assertThat(hit.toString()).isEqualTo(expectedMessage(count, prizeMoney));
    }


    @DisplayName("일치한 갯수 값은 0 과 6 사이 값을 가진다.")
    @ParameterizedTest
    @MethodSource("provideHitCountAndHitBonusAndExpectedHit")
    void valueOfTest(final int hitCount, final boolean isHitBonus, Hit expectedHit) {
        assertThat(Hit.valueOf(hitCount, isHitBonus)).isEqualTo(expectedHit);
    }

    private static Stream<Arguments> provideHitCountAndHitBonusAndExpectedHit() {
        return Stream.of(
                Arguments.of(0,true,ZERO),
                Arguments.of(5,false,FIVE),
                Arguments.of(5,true,FIVE_BONUS),
                Arguments.of(6,true,ALL)
        );
    }

    @DisplayName("비교 테스트")
    @ParameterizedTest
    @MethodSource("비교대상_예상결과값_제공함수")
    void compareTest(final Hit source, final Hit destination, final boolean expectedResult) {
        assertThat(THREE.isWin(TWO)).isTrue();
    }

    private static Stream<Arguments> 비교대상_예상결과값_제공함수() {
        return Stream.of(
                Arguments.of(TWO,THREE,true),
                Arguments.of(THREE,TWO,false)
        );
    }

    @DisplayName("동일한 당첨금액의 갯수만큼 비용을 반환한다.")
    @Test
    void costTest() {
        assertThat(Hit.THREE.winningAmount(3)).isEqualTo(15000);
    }

    private String expectedMessage(final int count, final int prizeMoney) {
        return String.format("%d개 일치 (%d원)", count, prizeMoney);
    }

    @DisplayName("당첨금이 있는 값만 반환한다.")
    @Test
    void getPrizeMoneyListTest() {
        assertThat(Hit.winningList()).isEqualTo(new Hit[] {THREE,FOUR,FIVE,FIVE_BONUS,ALL});
    }

    private static Stream<Arguments> provideHitAndCountAndPrizeMoney() {
        return Stream.of(
                Arguments.of(ZERO, 0, 0),
                Arguments.of(ONE, 1, 0),
                Arguments.of(TWO, 2, 0),
                Arguments.of(THREE, 3, 5000),
                Arguments.of(FOUR, 4, 50000),
                Arguments.of(FIVE, 5, 1500000),
                Arguments.of(ALL, 6, 2000000000)
        );
    }
}
