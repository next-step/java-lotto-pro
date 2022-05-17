package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("로또번호 정답 갯수를 확인한다.")
    void 로또번호_정답_갯수_확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        assertThat(Lottos.countMatchedNumber(lotto, answerLotto)).isEqualTo(3);
    }
}
