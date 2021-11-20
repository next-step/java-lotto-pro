package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BonusBallTest {

    @Test
    void 당첨로또와_번호로_보너스볼을_만들수있다() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
            new LottoNumber(3), new LottoNumber(2), new LottoNumber(42),
            new LottoNumber(11), new LottoNumber(43), new LottoNumber(12)
        ));

        final int bonusLottoNumber = 7;
        final BonusBall bonusBall = new BonusBall(winningLotto, new LottoNumber(bonusLottoNumber));

        assertThat(bonusBall).isEqualTo(new BonusBall(winningLotto, new LottoNumber(bonusLottoNumber)));
    }

    @Test
    void 당첨로또에_있는_번호로_보너스볼을_만드려고하면_예외가_발생한다() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
            new LottoNumber(3), new LottoNumber(2), new LottoNumber(42),
            new LottoNumber(11), new LottoNumber(43), new LottoNumber(12)
        ));

        assertThatThrownBy(() -> new BonusBall(winningLotto, new LottoNumber(12)))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입한_로또에_보너스볼과_일치하는_것이_있는지_확인한다() {
        //given
        final LottoNumber sameLottoNumberOne = new LottoNumber(3);
        final LottoNumber sameLottoNumberTwo = new LottoNumber(12);
        final LottoNumber sameLottoNumberThree = new LottoNumber(11);

        final LottoNumber bonusLottoNumber = new LottoNumber(9);

        final Lotto purchasedLotto = new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberTwo, sameLottoNumberThree,
            new LottoNumber(1), new LottoNumber(40), bonusLottoNumber
        ));

        final Lotto winningLotto = new Lotto(Arrays.asList(
            sameLottoNumberOne, new LottoNumber(2), new LottoNumber(42),
            sameLottoNumberTwo, new LottoNumber(43), sameLottoNumberThree
        ));

        final BonusBall bonusBall = new BonusBall(winningLotto, bonusLottoNumber);

        //when
        final boolean isMatchedByBonusBall = bonusBall.isMatchedBy(purchasedLotto);

        //then
        assertThat(isMatchedByBonusBall).isTrue();
    }
}