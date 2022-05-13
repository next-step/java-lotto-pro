package lotto.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoStoreTest {

    @DisplayName("구매 금액이 1000원 미만(로또 최소 금액)인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"100", "0", "900"})
    void buyLottoCount_low_money(String moneyWord) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(moneyWord))
                .withMessage("[ERROR] 로또 최소 가격은 1000원 입니다.");
    }

    @DisplayName("구매 금액이 10_000_000원 이상인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"10001000","100000000"})
    void buyLottoCount_over_money(String moneyWord) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(moneyWord))
                .withMessage("[ERROR] 로또 구매 최대 가격은 10_000_000원 입니다.");
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "1200", "59900"})
    void buyLottoCount_incorrect_unit(String moneyWord) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(moneyWord))
                .withMessage("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
    }

    @DisplayName("잘못된 구매금액을 입력하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"천원", "2dollars", "$2"})
    void buyLottoCount_incorrect_input_money(String moneyWord) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoStore(moneyWord))
                .withMessage("[ERROR] 구매금액 변환에 오류가 발생했습니다.");
    }

}
