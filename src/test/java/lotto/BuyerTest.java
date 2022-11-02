package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {
    private Buyer buyer;

    @BeforeEach
    void setUp() {
        buyer = new Buyer("10000");
    }

    @DisplayName("구매자 객체는 금액(잔액)을 가진다.")
    @Test
    public void 구매자_잔액_저장_테스트() {
        // then
        assertThat(buyer.getAmount()).isEqualTo(10000);
    }

    @DisplayName("구매자는 잔액만큼의 로또를 구매할 수 있다.")
    @Test
    public void 구매자_로또_구입_기능_테스드() {
        // when
        buyer.buyLotto();
        // then
        assertThat(buyer.getLottos()).hasSize(10);

    }
}
