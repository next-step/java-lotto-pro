package lotto.auto;

import org.junit.jupiter.api.Test;

import static lotto.auto.common.Constants.DEFAULT_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또_가격_저장_확인(){
        Lotto lotto = new Lotto(DEFAULT_PRICE);
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }
}
