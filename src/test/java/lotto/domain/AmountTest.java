package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class AmountTest {

    @DisplayName("금액이 Null 또는 빈값인 경우 에러가 발생되는지 확인")
    @ParameterizedTest
    @NullAndEmptySource
    void amountNullOrEmpty(String amount) {
        assertThatThrownBy(() -> new Amount(amount))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 숫자가 아닌 경우 에러가 발생되는지 확인")
    @Test
    void amountOnlyNumber() {
        assertThatThrownBy(() -> new Amount("ABCDEF"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액이 양수가 아닌 경우 에러가 발생되는지 확인")
    @Test
    void amountOnlyPositive() {
        assertThatThrownBy(() -> new Amount("-1000"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액으로 구매한 로또 개수가 1개 이하인 경우 에러가 발생되는지 확인")
    @Test
    void buyLottoCount() {
        assertThatThrownBy(() -> new Amount("900").buyLottoCount())
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동으로 구매할 로또가 구입 가능한 로또보다 많으면 에러가 발생되는지 확인")
    @Test
    void purchaseAvailable() {
        assertThatThrownBy(() -> new Amount("3000").purchaseAvailable(4))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동으로 구매할 로또 개수가 일치하는지 확인")
    @Test
    void buyLottoAutoCount() {
        Amount buyAmount = new Amount("3000");

        assertThat(buyAmount.buyLottoAutoCount(2)).isEqualTo(1);
    }
}