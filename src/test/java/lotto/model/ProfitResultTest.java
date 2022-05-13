package lotto.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ProfitResultTest {

    @Test
    @DisplayName("기준보다 큰 값이면 수익")
    void gainProfitMoreThanStandard() {
        assertEquals(ProfitResult.GAIN, ProfitResult.of(1.5));
    }

    @ParameterizedTest(name = "기준보다 작거나 같은 값({0})이면 손해")
    @ValueSource(doubles = {1.0, 0.7})
    void lossProfitLessThanOrEqualStandard(double profitRate) {
        assertEquals(ProfitResult.LOSS, ProfitResult.of(profitRate));
    }
}
