package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("당첨로또 생성 테스트")
    @Test
    void 당첨로또_생성() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(7));

        assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("당첨로또 번호와 보너스 번호가 중복된 경우 예외처리")
    @Test
    void 당첨로또_보너스번호_중복_예외() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()))
                , new LottoNumber(6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
