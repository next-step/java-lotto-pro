package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoStoreTest {

    @DisplayName("자동 로또 시도 회수를 계산")
    @ParameterizedTest
    @CsvSource(value = {"2500,2", "1500,1"}, delimiter = ',')
    void calculateTryCount(int inputMoney, int tryCount) {
        Money money = new Money(inputMoney);

        LottoGame game = LottoStore.sell(Collections.emptyList(), money);

        assertThat(game.getAutoTryCount()).isEqualTo(tryCount);
    }

    @DisplayName("자동, 수동 로또 시도 회수를 계산")
    @Test
    void calculateManualTryCount() {
        Money money = new Money(5000);
        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6","1,2,4,5,6,7");

        LottoGame game = LottoStore.sell(manualNumbers, money);

        assertAll(
                () -> assertThat(game.getAutoTryCount()).isEqualTo(3),
                () -> assertThat(game.getManualTryCount()).isEqualTo(2)
        );

    }

}
