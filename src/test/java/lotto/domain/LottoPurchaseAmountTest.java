package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {
    @Test
    @DisplayName("구입 금액은 1000 단위로 입력")
    void amount_unit_of_1000() {
        assertThat(new LottoPurchaseAmount("1000")).isEqualTo(new LottoPurchaseAmount("1000"));
        assertThatThrownBy(() -> new LottoPurchaseAmount("15500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000 단위로 입력해주세요.");
    }

    @Test
    @DisplayName("구입 금액은 숫자만 입력 가능")
    void amount_only_number() {
        assertThatThrownBy(() -> new LottoPurchaseAmount("d"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("구입 금액은 양수만 입력 가능")
    void amount_only_positive_number() {
        assertThatThrownBy(() -> new LottoPurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수를 입력해주세요.");
    }

    @Test
    @DisplayName("수량 구하기")
    void lotto_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("10000");
        assertThat(lottoPurchaseAmount.getQuantity()).isEqualTo(10);
    }
    
    @Test
    @DisplayName("수익률 구하기")
    void calculate_earning_amount() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("14000");
        assertThat(lottoPurchaseAmount.calculateEarningRatio(5000)).isEqualTo(0.35d);
    }
}