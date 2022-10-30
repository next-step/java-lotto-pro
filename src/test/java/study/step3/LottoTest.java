package study.step3;

import org.junit.jupiter.api.Test;
import study.step3.exception.LottoConsistOfSameNumbersException;
import study.step3.exception.LottoNumberListSizeException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또_만들기() {
        assertThatNoException().isThrownBy(Lotto::new);
    }

    @Test
    void 로또_숫자_리스트_크기_예외() {
        // 숫자 5개
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(LottoNumberListSizeException.class);
        // 숫자 7개
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(LottoNumberListSizeException.class);
    }

    @Test
    void 로또_서로_다른_수_구성_예외() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 1, 3, 4, 5, 6)))
                .isInstanceOf(LottoConsistOfSameNumbersException.class);
    }

    @Test
    void 당첨_번호와_일치하는_갯수_구하기() {
        // given
        Lotto winNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.asList(1, 3, 4, 5, 6, 8));

        // when
        int countOfMatch = lotto.countMatchingNumbers(winNumbers);

        // then
        assertThat(countOfMatch).isEqualTo(5);
    }
}
