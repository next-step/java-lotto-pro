package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoNumbersTest {

    @Test
    void 로또_번호_생성_시_1_에서_45_사이의_숫자_6개로_생성하면_정상_생성된다() {
        List<LottoNumber> numbers = createLottoNumbers(1, 9, 13, 24, 35, 45);

        assertThatNoException().isThrownBy(() -> new LottoNumbers(numbers));
    }

    @Test
    void 로또_번호_생성_시_comma_를_기준으로_6개의_1_에서_45_사이의_문자열_숫자로_생성하면_정상_생성된다() {
        assertThatNoException().isThrownBy(() -> new LottoNumbers("1, 2, 3, 4, 5, 45"));
    }

    @Test
    void 중복된_숫자가_포함된_1_에서_45_사이의_숫자로_생성하면_예외가_발생한다() {
        List<LottoNumber> numbers = createLottoNumbers(1, 2, 2, 3, 3, 4);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(numbers));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers("1, 2, 2, 3, 3, 4"));
    }

    @Test
    void 로또_번호_생성_시_숫자가_6개가_아니면_예외가_발생한다() {
        List<LottoNumber> overCountNumbers = createLottoNumbers(1, 2, 3, 4, 5);
        List<LottoNumber> lackCountNumbers = createLottoNumbers(1, 2, 3, 4, 5, 6, 7);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(overCountNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lackCountNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers("1, 2, 3, 4, 5"));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers("1, 2, 3, 4, 5, 6, 7"));
    }

    @Test
    void 로또_번호에_포함된_번호를_찾는_메소드는_정상_동작해야_한다() {
        List<LottoNumber> numbers = createLottoNumbers(1, 9, 13, 24, 35, 45);
        LottoNumbers lottoNumbers = new LottoNumbers(numbers);
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumbers.hasContainLottoNumber(lottoNumber)).isTrue();
    }

    private List<LottoNumber> createLottoNumbers(Integer ...args) {
        List<LottoNumber> result = new ArrayList<>();

        for (Integer number : args) {
            result.add(new LottoNumber(number));
        }

        return result;
    }
}
