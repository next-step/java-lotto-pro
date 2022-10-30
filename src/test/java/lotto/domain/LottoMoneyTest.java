package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMoneyTest {

    @DisplayName("로또 구매 실패 확인")
    @ParameterizedTest(name = "\"{0}\"원은 로또 구매를 할 수 없습니다.")
    @ValueSource(strings = {"", " ", "100", "-1", "10004", "1000a"})
    void lotto_purchase_failure_confirmation(String input) {
        assertThatThrownBy(() -> new LottoMoney(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

