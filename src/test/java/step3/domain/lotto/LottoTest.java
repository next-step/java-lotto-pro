package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("기본 - 1장에 1000원짜리 로또를 생성한다.")
    void createDefaultLotto() {
        Lotto lotto = new Lotto(new LottoNumbers());
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("가격변동 - 1장에 2000원짜리 로또를 생성한다.")
    void createLotto() {
        Lotto lotto = new Lotto(2000, new LottoNumbers());
        assertThat(lotto.getPrice()).isEqualTo(2000);
    }
}
