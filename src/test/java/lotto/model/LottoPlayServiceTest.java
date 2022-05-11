package lotto.model;

import lotto.vo.Lottos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoPlayServiceTest {

    private LottoPlayService lottoPlayService;

    @BeforeEach
    void init() {
        lottoPlayService = new LottoPlayService();
    }

    @DisplayName("입력받은 구매금액을 로또 개수로 변환한다.")
    @ParameterizedTest(name = "[{0}]원 -> [{1}]게임")
    @CsvSource(value = {"10000:10", "5000:5", "3000:3"}, delimiter = ':')
    void convertMoneyToLottos(int money, int expectedPlayCount) {
        Lottos lottos = lottoPlayService.convertMoneyToLottos(money);
        assertEquals(expectedPlayCount, lottos.getPlayCount());
    }

    @DisplayName("구매 금액이 1000원 미만(로또 최소 금액)인 경우")
    @ParameterizedTest
    @ValueSource(ints = {100, 0, 900})
    void convertMoneyToLottos_low_money(int money) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.convertMoneyToLottos(money))
                .withMessage("[ERROR] 로또 최소 가격은 1000원 입니다.");
    }

    @DisplayName("구매 금액이 10_000_000원 이상인 경우")
    @ParameterizedTest
    @ValueSource(ints = {10_000_000, Integer.MAX_VALUE})
    void convertMoneyToLottos_over_money(int money) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.convertMoneyToLottos(money))
                .withMessage("[ERROR] 로또 구매 최대 가격은 10_000_000원 입니다.");
    }

    @DisplayName("구매 금액이 1000원 단위가 아닌 경우")
    @ParameterizedTest
    @ValueSource(ints = {1500, 1200, 59900})
    void convertMoneyToLottos_incorrect_unit(int money) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoPlayService.convertMoneyToLottos(money))
                .withMessage("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
    }

}
