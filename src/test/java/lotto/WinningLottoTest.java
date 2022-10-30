package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 번호와 보너스 볼이 중복되면 IllegalArgumentException 예외 발생")
    void generate_중복되는_보너스_볼() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generate()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() -> new WinningLotto(lottoNumbers, lottoNumbers.get(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
