package lotto.model.lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import lotto.model.winning.WinningLotto;
import lotto.type.LottoRank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    @DisplayName("로또 숫자가 중복될 경우 에러 출력")
    void 로또_숫자가_중복될_경우() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Lotto.of(Arrays.asList("1", "2", "2", "3", "4", "5")));
    }

    @Test
    @DisplayName("로또 숫자가 설정값과 다를경우 에러 출력")
    void 숫자개수가_일치하지_않을_경우() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Lotto.of(Arrays.asList("1", "2")));
    }

    @Test
    @DisplayName("로또숫자 안에 당첨번호가 포함되는지 확인한다.")
    void 로또숫자를_포함하는지_확인한다() {
        Lotto lotto = Lotto.of(Arrays.asList("1", "2", "3", "4", "5", "6"));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList("1", "2", "3", "7", "8", "9"), "10");

        assertEquals(winningLotto.match(lotto), LottoRank.THREE);
    }

}
