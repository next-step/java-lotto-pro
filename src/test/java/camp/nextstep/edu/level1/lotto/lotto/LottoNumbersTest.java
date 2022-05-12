package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoNumbersTest {

    @Test
    void 로또_번호_생성_시_1_에서_45_사이의_숫자_6개로_생성하면_정상_생성된다() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 9, 13, 24, 35, 45));

        assertThatNoException().isThrownBy(() -> new LottoNumbers(numbers));
    }

    @Test
    void 로또_번호_생성_시_1_에서_45_이외의_숫자_6개로_생성하면_예외가_발생한다() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, -9, 13, 24, 35, 46));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(numbers));
    }

    @Test
    void 로또_번호_생성_시_숫자가_6개가_아니면_예외가_발생한다() {
        Set<Integer> overCountNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> lackCountNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(overCountNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lackCountNumbers));
    }
}