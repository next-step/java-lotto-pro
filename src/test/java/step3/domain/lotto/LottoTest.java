package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.generator.Random;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("기본 - 1장에 1000원짜리 로또를 생성한다.")
    void createDefaultLotto() {
        Lotto lotto = new Lotto(new LottoNumbers(new Random()));
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }
}
