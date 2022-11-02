package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoUtil;
import step3.domain.Money;

public class LottoShopTest {

    @Test
    @DisplayName("가격에 따라 로또를 몇개 살 수 있는지 테스트")
    void lottoShopTest() {
        Money money = new Money(10000);
        assertThat(LottoUtil.buy(money)).isEqualTo(10);
    }

}
