package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoPurchaseQuantityTest {
    @Test
    @DisplayName("로또 갯수 생성")
    void lotto_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(10000);
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.of(lottoPurchaseAmount.calculateQuantity());
        assertThat(lottoPurchaseQuantity).isEqualTo(LottoPurchaseQuantity.of(10));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "10000:10", "15000:15"}, delimiter = ':')
    @DisplayName("구매 갯수 출력")
    void print_lotto_quantity(int input, int expect) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(input);
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.of(lottoPurchaseAmount.calculateQuantity());
        assertThat(lottoPurchaseQuantity.history()).isEqualTo(String.format(LottoPurchaseQuantity.PRINT_QUANTITY_FORMAT, expect));
    }

    @Test
    @DisplayName("수동 로또 횟수 생성")
    void create_manual_lotto_purchase_quantity() {
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.manualQuantity("3");
        assertThat(lottoPurchaseQuantity).isEqualTo(LottoPurchaseQuantity.manualQuantity("3"));
    }

    @Test
    @DisplayName("로또 구매 횟수는 숫자만 입력 가능")
    void lotto_purchase_quantity_is_only_number() {
        assertThatThrownBy(() -> LottoPurchaseQuantity.manualQuantity("d1"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("구매 갯수 출력(자동, 수동)")
    void print_lotto_quantity_auto_manual() {
        LottoPurchaseQuantity manualQuantity = LottoPurchaseQuantity.manualQuantity("5");
        LottoPurchaseQuantity autoQuantity = new LottoPurchaseAmount(9000).calculateAutoQuantity(manualQuantity);
        assertThat(LottoPurchaseQuantity.history(manualQuantity, autoQuantity)).isEqualTo("수동으로 5장, 자동으로 4장을 구매했습니다.");
    }
}
