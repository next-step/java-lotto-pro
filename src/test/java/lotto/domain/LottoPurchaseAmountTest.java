package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseAmountTest {
    @Test
    @DisplayName("2147484000원 이상 구매시 예외 발생")
    void amonut_more_than_2147483000_throw_exception() {
        assertThatThrownBy(() -> new LottoPurchaseAmount("2147484000"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("최대 구매 금액을 초과했습니다.");
    }

    @Test
    @DisplayName("구입 금액 1000원 이하일 경우 예외 발생")
    void amount_less_than_1000_throw_exception() {
        assertThatThrownBy(() -> new LottoPurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구매 금액은 1000원 입니다.");
    }

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
        assertThatThrownBy(() -> new LottoPurchaseAmount("df1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("구입 금액은 양수만 입력 가능")
    void amount_only_positive_number() {
        assertThatThrownBy(() -> new LottoPurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구매 금액은 1000원 입니다.");
    }

    @Test
    @DisplayName("수량 구하기")
    void lotto_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("10000");
        assertThat(lottoPurchaseAmount.calculateQuantity()).isEqualTo(10);
    }
    
    @Test
    @DisplayName("수익률 구하기")
    void calculate_earning_amount() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("14000");
        assertThat(lottoPurchaseAmount.calculateEarningRatio(5000)).isEqualTo(0.35d);
    }

    @Test
    @DisplayName("로또 복권 생성 테스트")
    void create_lotto_lottery() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount("1000");
        LottoLottery lottoLottery = lottoPurchaseAmount.toLottoLottery(new ManualNumberGenerator("1,2,3,4,5,6"));
        assertThat(lottoLottery).isEqualTo(LottoLottery.of(LottoPurchaseQuantity.of(1), new ManualNumberGenerator("1,2,3,4,5,6")));
    }
}
