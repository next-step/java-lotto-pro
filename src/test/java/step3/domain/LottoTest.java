package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void LottoNumbers_를_통한_생성() {
        LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        assertThatCode(() -> new Lotto(lottoNumbers)).doesNotThrowAnyException();
    }

    @Test
    void 로또_번호가_같을경우_동등() {
        LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        assertThat(new Lotto(lottoNumbers)).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    void 보유한_LottoNumbers_와_다른_LottoNumbers_를_비교해_숫자가_일치하는_개수를_찾을_수_있다() {
        Lotto lotto = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");
        assertThat(lotto.compareNumbers(winningNumbers)).isEqualTo(5);
    }

    @Test
    void 보유한_로또번호가_보너스_번호를_포함하고_있는지_확인() {
        Lotto lotto = new Lotto(new LottoNumbers("1, 2, 3, 4, 5, 6"));
        LottoNumber bonusNumber = LottoNumber.of(6);
        assertThat(lotto.isBonusWin(bonusNumber)).isTrue();
    }
}
