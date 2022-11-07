package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.utils.LottoNumbersGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("일치하는 보너스볼 번호가 있는경우 [1]를 반환한다")
    void match_bonus_lotto_Number_test() {
        LottoNumbers lottoNumbers = LottoNumbersGenerator.createLottoNumbers(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumber bonusNumber = LottoNumber.of(1);

        boolean isMatchedBonusLottoNumber = lotto.isMatchedBonusLottoNumber(bonusNumber);

        assertThat(isMatchedBonusLottoNumber).isTrue();
    }

    @Test
    @DisplayName("일치하는 보너스볼 번호가 없는경우 [0]를 반환한다")
    void not_match_bonus_lotto_Number_test() {
        LottoNumbers lottoNumbers = LottoNumbersGenerator.createLottoNumbers(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumber bonusNumber = LottoNumber.of(7);

        boolean isMatchedBonusLottoNumber = lotto.isMatchedBonusLottoNumber(bonusNumber);

        assertThat(isMatchedBonusLottoNumber).isFalse();
    }
}
