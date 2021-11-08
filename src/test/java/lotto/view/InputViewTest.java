package lotto.view;

import lotto.exception.LottoActiveNumberException;
import lotto.exception.LottoBonusNumberException;
import lotto.exception.LottoMatchNumberException;
import lotto.exception.LottoPurchaseAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static lotto.utils.ValidationUtils.isEmpty;
import static lotto.utils.ValidationUtils.isNumeric;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;


public class InputViewTest {

    private final InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6")
    @DisplayName("당첨번호 입력 검증")
    public void matchNumberValidation(String inputString) {
        inputView.matchNumberValidation(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2,3,4,5,6,가")
    @DisplayName("당첨번호 입력 검증_오류")
    public void matchNumberValidation2(String inputString) {
        assertThatThrownBy(() -> {
            inputView.matchNumberValidation(inputString);
        }).isInstanceOf(LottoMatchNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "15000")
    @DisplayName("구입금액 입력 검증")
    public void purchaseAmountValidation(String inputString) {
        inputView.purchaseAmountValidation(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = "15000가나")
    @DisplayName("구입금액 입력 검증_오류")
    public void purchaseAmountValidation2(String inputString) {
        assertThatThrownBy(() -> {
            inputView.purchaseAmountValidation(inputString);
        }).isInstanceOf(LottoPurchaseAmountException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "15")
    @DisplayName("보너스 번호 검증")
    public void bonusNumberValidation(String inputString) {
        inputView.bonusNumberValidation(inputString);
    }

    @ParameterizedTest
    @ValueSource(strings = "15가")
    @DisplayName("보너스 번호 검증_오류")
    public void bonusNumberValidation_오류(String inputString) {
        assertThatThrownBy(() -> {
            inputView.bonusNumberValidation(inputString);
        }).isInstanceOf(LottoBonusNumberException.class);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("보너스 번호 검증_오류")
    public void bonusNumberValidation_오류2(String inputString) {
        assertThatThrownBy(() -> {
            inputView.bonusNumberValidation(inputString);
        }).isInstanceOf(LottoBonusNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "14")
    @DisplayName("수동 구매 회수 검증")
    public void activeCountValidation(String inputString) {
        inputView.activeCountValidation(inputString);
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("수동 구매 회수 검증_오류")
    public void activeCountValidation_오류(String inputString) {
        assertThatThrownBy(() -> {
            inputView.activeCountValidation(inputString);
        }).isInstanceOf(LottoActiveNumberException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = "15가")
    @DisplayName("수동 구매 회수 검증_오류")
    public void activeCountValidation_오류2(String inputString) {
        assertThatThrownBy(() -> {
            inputView.activeCountValidation(inputString);
        }).isInstanceOf(LottoActiveNumberException.class);
    }

}