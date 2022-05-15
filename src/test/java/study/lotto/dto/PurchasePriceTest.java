package study.lotto.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PurchasePriceTest {
    @Test
    void 유효한_숫자() {
        PurchasePrice purchasePrice = new PurchasePrice("14000");
        assertThat(purchasePrice.value()).isEqualTo(new BigDecimal(14000));
    }

    @Nested
    @DisplayName("무효한 숫자")
    class 무효한_숫자 {
        @Test
        @DisplayName("null 을 입력받으면 IllegalArgumentException 을 발생시킨다.")
        void null_입력() {
            assertThatThrownBy(() -> new PurchasePrice(null)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("빈 문자열을 입력받으면 IllegalArgumentException 을 발생시킨다.")
        void 공백_입력() {
            assertThatThrownBy(() -> new PurchasePrice("")).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자가 아니면 IllegalArgumentException 을 발생시킨다.")
        void 숫자가_아닌_값_입력() {
            assertThatThrownBy(() -> new PurchasePrice("1,002")).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
