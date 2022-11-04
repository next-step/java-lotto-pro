package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 숫자_6개_생성() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getLottoNumbers()).hasSize(6);
    }
}
