package lotto.auto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private final int DEFAULT_PRICE = 1000;

    @Test
    public void 로또_가격_저장_확인(){
        Lotto lotto = new Lotto(DEFAULT_PRICE);
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }
}
