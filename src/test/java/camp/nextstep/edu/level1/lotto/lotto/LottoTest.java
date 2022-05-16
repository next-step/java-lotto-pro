package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.common.PositiveNumber;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

class LottoTest {
    private static final int LOTTO_PRICE = 1_000;

    @Test
    void 로또_가격보다_작거나_음수_금액을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(new Money(LOTTO_PRICE - 1))).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Lotto(new Money(- 1))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또_구입_후_당첨_여부를_확인하면_결과가_반환된어야_한다() {
        Lotto lotto = new Lotto(new Money(10_000));
        LottoNumbers correctWinningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumber = new LottoNumber("7");

        assertThat(lotto.compareWinningNumber(correctWinningNumbers, bonusNumber)).isInstanceOf(LottoResult.class);
    }

    @Test
    void 로또_구입_금액을_입력한_뒤_수동_구입_금액_입력_후_해당_수_만큼_로또를_입력해야_한다() {
        Lotto lotto = new Lotto(new Money(3_000));
        List<LottoNumbers> manualPurchaseLottoNumbers = Arrays.asList(
                new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 6))
        );

        assertThatNoException().isThrownBy(() -> lotto.manualLottoPurchase(manualPurchaseLottoNumbers));
    }

    @Test
    void 로또_구입_금액_입력_후_최대_구입_가능한_로또_수_보다_많은_수의_수동_로또를_구입하면_예외가_발생해야_한다() {
        Lotto lotto = new Lotto(new Money(2_000));
        List<LottoNumbers> manualPurchaseLottoNumbers = Arrays.asList(
                new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(createLottoNumberCollection(1, 2, 3, 4, 5, 6))
        );

        assertThatThrownBy(() -> lotto.manualLottoPurchase(manualPurchaseLottoNumbers)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 로또의_당첨번호에_보너스_번호가_포함되어_있으면_예외가_발생한다() {
        Lotto lotto = new Lotto(new Money(10_000));
        LottoNumbers winningNumbersWithDuplicatedBonusNumber = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumber bonusNumberDuplicatedInWinningNumbers = new LottoNumber("6");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto.compareWinningNumber(winningNumbersWithDuplicatedBonusNumber, bonusNumberDuplicatedInWinningNumbers);
        });
    }

    private List<LottoNumber> createLottoNumberCollection(Integer ...args) {
        List<LottoNumber> result = new ArrayList<>();

        for (Integer number : args) {
            result.add(new LottoNumber(number));
        }

        return result;
    }
}
