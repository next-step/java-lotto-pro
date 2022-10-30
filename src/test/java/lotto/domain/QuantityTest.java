package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {

    @DisplayName("수동 및 자동 로또 개수를 포함하는 Quantity 생성 작업이 정상적으로 동작한다.")
    @ParameterizedTest(name = "{index} {displayName} input={arguments} ")
    @MethodSource("provideArgumentsOfQuantityTest")
    void getCount(PurchaseType purchaseType, int value) {
        Quantity quantity = new Quantity(0, 1);
        assertThat(quantity.getCount(purchaseType)).isEqualTo(value);

    }

    private static Stream<Arguments> provideArgumentsOfQuantityTest() {
        return Stream.of(
           Arguments.of(PurchaseType.AUTO, 1),
           Arguments.of(PurchaseType.MANUAL,0)
        );
    }
}
