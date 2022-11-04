package lotto;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusNumberTest {

    @Test
    @DisplayName("보너스번호 정상생성 테스트")
    void name() {
        assertThat((BonusNumber.of(3)).equals(BonusNumber.of(3))).isTrue();
    }


}
