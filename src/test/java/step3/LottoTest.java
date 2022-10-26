package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void lotto_generation() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
    
}
