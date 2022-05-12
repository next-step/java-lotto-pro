package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoTest {
    private final int LOTTO_PRICE = 1000;

    @Test
    void 로또_가격보다_작거나_음수_금액을_입력하면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(LOTTO_PRICE - 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(- 1));
    }

    @Test
    void 로또_구입_후_당첨_여부를_확인하면_결과가_반환된어야_한다() {
        Lotto lotto = new Lotto(10000);
        String correctWinningNumbers = "1, 2, 3, 4, 5, 6";

        assertThatNoException().isThrownBy(() -> lotto.compareWinningNumber(correctWinningNumbers));
    }

    @Test
    void 로또_당첨_번호_입력_시_숫자와_구분자를_제외한_문자나_음수나_숫자_6개_를_입력하지_않으면_예외가_발생한다() {
        Lotto lotto = new Lotto(10000);
        String invalidWinningNumbers = "1, 2, 3, abc4, 5!@# 6";
        String includeMinusWinningNumbers = "1, -2, 3, 4, -5, 6";
        String invalidWinningNumberCount = "1, 2, 3, 4, 5";

        assertThatIllegalArgumentException().isThrownBy(() -> lotto.compareWinningNumber(invalidWinningNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> lotto.compareWinningNumber(includeMinusWinningNumbers));
        assertThatIllegalArgumentException().isThrownBy(() -> lotto.compareWinningNumber(invalidWinningNumberCount));
    }
}