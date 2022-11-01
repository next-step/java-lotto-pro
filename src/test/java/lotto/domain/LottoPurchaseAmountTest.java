package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseAmountTest {
    @Test
    @DisplayName("구입 금액 1000원 이하일 경우 예외 발생")
    void amount_less_than_1000_throw_exception() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구매 금액은 1000원 입니다.");
    }

    @Test
    @DisplayName("구입 금액은 1000 단위로 입력")
    void amount_unit_of_1000() {
        assertThat(new LottoPurchaseAmount(1000)).isEqualTo(new LottoPurchaseAmount(1000));
        assertThatThrownBy(() -> new LottoPurchaseAmount(15500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000 단위로 입력해주세요.");
    }
    
    @Test
    @DisplayName("구입 금액은 양수만 입력 가능")
    void amount_only_positive_number() {
        assertThatThrownBy(() -> new LottoPurchaseAmount(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 구매 금액은 1000원 입니다.");
    }

    @Test
    @DisplayName("수량 구하기")
    void lotto_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(10000);
        assertThat(lottoPurchaseAmount.calculateQuantity()).isEqualTo(10);
    }
    
    @Test
    @DisplayName("수익률 구하기")
    void calculate_earning_amount() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(14000);
        assertThat(lottoPurchaseAmount.calculateEarningRatio(5000)).isEqualTo(0.35d);
    }

    @Test
    @DisplayName("로또 복권 생성 테스트")
    void create_lotto_lottery() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(1000);
        LottoLottery lottoLottery = lottoPurchaseAmount.toLottoLottery(new ManualNumberGenerator("1,2,3,4,5,6"));
        assertThat(lottoLottery).isEqualTo(LottoLottery.of(LottoPurchaseQuantity.of(1), new ManualNumberGenerator("1,2,3,4,5,6")));
    }

    @Test
    @DisplayName("수동 로또 구매 횟수를 통해 자동 로또 구매 횟수를 구한다")
    void calculate_auto_lotto_quantity_by_manual_lotto_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(10000);
        assertThat(lottoPurchaseAmount.calculateAutoQuantity(LottoPurchaseQuantity.manualQuantity("3")))
                .isEqualTo(LottoPurchaseQuantity.of(7));
    }

    @Test
    @DisplayName("수동 로또 구매 횟수는 총 구매 횟수 보다 클수 없다")
    void manual_quantity_cannot_be_greater_than_purchase_quantity() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(10000);
        assertThatThrownBy(() -> lottoPurchaseAmount.calculateAutoQuantity(LottoPurchaseQuantity.manualQuantity("11")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 구매 가능 횟수는 최대 10장 입니다.");
    }
}
