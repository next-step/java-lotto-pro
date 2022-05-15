package camp.nextstep.edu.level1.lotto.lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoTest {
    private static final int LOTTO_PRICE = 1000;

    @Test
    void 로또_가격보다_작거나_음수_금액을_입력하면_예외가_발생한다() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(LOTTO_PRICE - 1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(- 1));
    }

    @Test
    void 로또_구입_후_당첨_여부를_확인하면_결과가_반환된어야_한다() {
        Lotto lotto = new Lotto(10000);
        LottoNumbers correctWinningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber("7");

        assertThat(lotto.compareWinningNumber(correctWinningNumbers, bonusNumber)).isInstanceOf(LottoResult.class);
    }

    @Test
    void 로또_구입_금액을_입력한_뒤_수동_구입_금액_입력_후_해당_수_만큼_로또를_입력해야_한다() {
        Lotto lotto = new Lotto(3000);
        List<LottoNumbers> manualPurchaseLottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        assertThatNoException().isThrownBy(() -> lotto.manualLottoPurchase(manualPurchaseLottoNumbers));
    }

    @Test
    void 로또_구입_금액_입력_후_최대_구입_가능한_로또_수_보다_많은_수의_수동_로또를_구입하면_예외가_발생해야_한다() {
        Lotto lotto = new Lotto(2000);
        List<LottoNumbers> manualPurchaseLottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        );

        assertThatIllegalArgumentException().isThrownBy(() -> lotto.manualLottoPurchase(manualPurchaseLottoNumbers));
    }

    @Test
    void 로또_당첨_번호_입력_시_숫자와_구분자를_제외한_문자나_음수나_숫자_6개_를_입력하지_않으면_예외가_발생한다() {
        Lotto lotto = new Lotto(10000);
        LottoNumbers invalidWinningNumbers = new LottoNumbers("1, 2, 3, abc4, 5!@# 6");
        LottoNumbers includeMinusWinningNumbers = new LottoNumbers("1, -2, 3, 4, -5, 6");
        LottoNumbers invalidWinningNumberCount = new LottoNumbers("1, 2, 3, 4, 5");
        LottoNumber bonusNumber = new LottoNumber("7");

        assertThatIllegalArgumentException().isThrownBy(() -> lotto.compareWinningNumber(invalidWinningNumbers, bonusNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> lotto.compareWinningNumber(includeMinusWinningNumbers, bonusNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> lotto.compareWinningNumber(invalidWinningNumberCount, bonusNumber));
    }

    @Test
    void 로또의_당첨본호에_보너스_번호가_포함되어_있으면_예외가_발생한다() {
        Lotto lotto = new Lotto(10000);
        LottoNumbers winningNumbersWithDuplicatedBonusNumber = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumberDuplicatedInWinningNumbers = new LottoNumber("6");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto.compareWinningNumber(winningNumbersWithDuplicatedBonusNumber, bonusNumberDuplicatedInWinningNumbers);
        });
    }
}
