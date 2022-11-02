package model;

import model.strategy.MockStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTest {

    @Test
    void 천원이하의_금액을_입력하면_오류를_리턴한다() {
        int money = 100;
        assertThatThrownBy(() -> {
            new Money(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력해주세요.");
    }


    @ParameterizedTest
    @MethodSource("autoAvailableTest")
    void 구매가능한_자동_로또_갯수를_리턴한다(int money, int manualCount, int expect) {
        int count = new Money(money).availableBuyAutoLottoCount(manualCount);

        Assertions.assertThat(count).isEqualTo(expect);
    }

    public static Stream<Arguments> autoAvailableTest() {
        return Stream.of(
                Arguments.of(10000, 5, 5),
                Arguments.of(3000, 1, 2),
                Arguments.of(5000, 0, 5),
                Arguments.of(8000, 8, 0)
        );
    }
}