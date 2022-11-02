package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.step3.domain.lottonumber.LottoMatchResult;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.utils.LottoNumbersGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @Test
    @DisplayName("당첨 로또는 발급 된 로또와 비교하면 당첨 번호 개수와 보너스볼 비교 결과를 반환한다")
    void test() {
        LottoNumbers lottoNumbers = LottoNumbersGenerator.createLottoNumbers(1, 2, 3, 4, 5, 12);
        Lotto lotto = new Lotto(lottoNumbers);
        LottoNumbers winningNumbers = LottoNumbersGenerator.createLottoNumbers(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new LottoNumber(12));

        LottoMatchResult lottoMatchResult = winningLotto.matchLotto(lotto);

        assertAll(
                () -> assertThat(lottoMatchResult.lottoMatchCount()).isEqualTo(5),
                () -> assertThat(lottoMatchResult.isGreaterThanZeroBonusMatchCount()).isTrue()
        );
    }

}
