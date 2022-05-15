package lotto.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CouponTest {
    @ParameterizedTest
    @MethodSource("천원_미만_금액")
    void 쿠폰_교환_천원_미만_예외(Money money) {
        assertThatThrownBy(() -> new Coupon(money)).isInstanceOf(IllegalArgumentException.class)
                                                   .hasMessageContaining("로또 구입 금액은 최소 1,000원 입니다.");
    }

    static Stream<Arguments> 천원_미만_금액() {
        return Stream.of(
                Arguments.of(new Money(1)),
                Arguments.of(new Money(100)),
                Arguments.of(new Money(500))
        );
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("천원_단위가_아닌_금액")
    void 쿠폰_교환_천원_단위_예외(Money money, String exceptionMessage) {
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> new Coupon(money));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> 천원_단위가_아닌_금액() {
        return Stream.of(
                Arguments.of(new Money(1100), "로또 구입 금액은 1,000원 단위입니다."),
                Arguments.of(new Money(1111), "로또 구입 금액은 1,000원 단위입니다."),
                Arguments.of(new Money(10001), "로또 구입 금액은 1,000원 단위입니다.")
        );
    }
}