package step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.factory.Automatic;
import step3.domain.factory.Manual;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("자동 로또를 생성한다.")
    void createDefaultLotto() {
        Lotto lotto = new Lotto(new Automatic());
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("수동 로또를 생성한다.")
    void createManualLotto() {
        Lotto lotto = new Lotto(new Manual(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.value()).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
