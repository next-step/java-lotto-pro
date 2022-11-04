package lotto;

import lotto.controller.LottoController;
import lotto.domain.BuyAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {

    LottoController lottoController = new LottoController();

    @ParameterizedTest
    @DisplayName("지난주 당첨번호 입력값 유효성체크 통과 안되는거 확인")
    @ValueSource(strings = {"10","aaa","a,b,c,d,e,f",
            "1,2,3,4,5,5","1,2,3,4,5","1,2,3,4,5,6,7",
            "1,2,3,4,5,46","1,0,3,4,5,6","1,-1,2,3,4,5"})
    void winningNumbers_invalidate_test(String input) {
        assertThatThrownBy(() -> lottoController.getWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보너스번호 유효성 체크")
    @ValueSource(strings = {"aa","-10","46","0"})
    void bonusNumber_invalidate_test(String input) {
        assertThatThrownBy(() -> lottoController.getBonusNumber(lottoController.getWinningNumbers("1,2,3,4,5,6"), input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구매금액으로 천원미만의 값, 문자, 음수, 0을 입력했을 경우 Exception을 던지는지 확인")
    @ValueSource(strings = {"500","aaa","-10","0"})
    void buyAmount_invalidate_test(String input) {
        assertThatThrownBy(() -> lottoController.buyLotto(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
