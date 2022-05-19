package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TicketTest {
    @ParameterizedTest
    @MethodSource("천원_미만_금액")
    void 쿠폰_교환_천원_미만_예외(Money money) {
        assertThatThrownBy(() -> new Ticket(money)).isInstanceOf(IllegalArgumentException.class)
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
                IllegalArgumentException.class, () -> new Ticket(money));
        assertThat(e.getMessage()).isEqualTo(exceptionMessage);
    }

    static Stream<Arguments> 천원_단위가_아닌_금액() {
        return Stream.of(
                Arguments.of(new Money(1100), "로또 구입 금액은 1,000원 단위입니다."),
                Arguments.of(new Money(1111), "로또 구입 금액은 1,000원 단위입니다."),
                Arguments.of(new Money(10001), "로또 구입 금액은 1,000원 단위입니다.")
        );
    }

    @ParameterizedTest()
    @MethodSource("천원_단위_금액")
    void 쿠폰_교환(Money money, int size) {
        assertThat(new Ticket(money).size()).isEqualTo(size);
    }

    static Stream<Arguments> 천원_단위_금액() {
        return Stream.of(
                Arguments.of(new Money(1000), 1),
                Arguments.of(new Money(10000), 10),
                Arguments.of(new Money(100000), 100)
        );
    }
}