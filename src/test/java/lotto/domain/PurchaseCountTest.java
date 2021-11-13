package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PurchaseCountTest {

    @Test
    void 음수() {
        // given
        int count = -1;

        // when, then
        assertThatThrownBy(() -> new PurchaseCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 갯수는 0개 이상이어야 합니다. (입력값: " + count + ")");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false, 1:true"}, delimiter = ':')
    void 값이_0_보다_큰지_검사(int input, boolean expectResult) {
        // given
        PurchaseCount purchaseCount = new PurchaseCount(input);

        // when
        boolean result = purchaseCount.isGreaterThanZero();

        // then
        assertThat(result).isEqualTo(expectResult);
    }

    @Test
    void 갯수_빼기() {
        // given
        int init = 3;
        PurchaseCount purchaseCount = new PurchaseCount(init);
        int minus = 1;

        // when
        PurchaseCount result = purchaseCount.minus(minus);

        // then
        assertThat(result).isEqualTo(new PurchaseCount(init - minus));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:true", "3:false", "4:false"}, delimiter = ':')
    void 입력된_수보다_큰지_검사(int input, boolean expectedResult) {
        // given
        PurchaseCount purchaseCount = new PurchaseCount(3);

        // when
        boolean result = purchaseCount.isGreaterThan(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:-1", "3:0", "4:1"}, delimiter = ':')
    void 차이_계산(int input, int expectedResult) {
        // given
        PurchaseCount purchaseCount = new PurchaseCount(3);

        // when
        int result = purchaseCount.gap(input);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    void 값이_0인지_확인(int input, boolean expectedResult) {
        // given
        PurchaseCount inputCount = new PurchaseCount(input);

        // when
        boolean result = inputCount.isZero();

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}