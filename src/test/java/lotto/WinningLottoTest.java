package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    @DisplayName("보너스 볼 일치 여부 확인")
    void 보너스_볼_일치_여부() {
        List<LottoNumber> winningNumbers = LottoNumberGenerator.generate()
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        WinningLotto winningLotto = new WinningLotto(winningNumbers, new LottoNumber(10));

        Lotto lottoWithBonusBall = new Lotto(Stream.of(1, 10, 20, 30, 40, 45)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        Lotto lottoExceptBonusBall = new Lotto(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));

        assertThat(winningLotto.hasBonusBall(lottoWithBonusBall)).isTrue();
        assertThat(winningLotto.hasBonusBall(lottoExceptBonusBall)).isFalse();
    }
}
