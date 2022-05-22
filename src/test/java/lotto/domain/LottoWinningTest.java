package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoWinningTest {
    @Test
    @DisplayName("로또번호, 보너스볼 번호 중복 예외 테스트")
    void 보너스볼_중복_예외() {
        Lotto answerLotto = new Lotto(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoNumber bonusLottoNumber = new LottoNumber(6);

        assertThatThrownBy(() -> {
            new LottoWinning(answerLotto, bonusLottoNumber);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}
