package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨 로또 번호에 보너스 번호가 포함되어 있으면 예외가 발생되는지 확인")
    @Test
    void winningAndBounsDuplication() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.from(6);

        assertThatThrownBy(() -> WinningLotto.from(lotto, lottoNumber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또가 정상적으로 당첨되는지 확인")
    @Test
    void winningMatch() {
        WinningLotto winningLotto = WinningLotto.from(
            Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.from(7));
        Lotto first = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto second = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));
        Lotto third = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 8));
        Lotto fourth = Lotto.from(Arrays.asList(1, 2, 3, 4, 9, 10));
        Lotto fifth = Lotto.from(Arrays.asList(1, 2, 3, 11, 12, 13));
        Lotto none = Lotto.from(Arrays.asList(11, 12, 13, 14, 15, 16));

        assertAll(
            () -> assertThat(winningLotto.winningMatch(first)).isEqualTo(LottoRank.FIRST),
            () -> assertThat(winningLotto.winningMatch(second)).isEqualTo(LottoRank.SECOND),
            () -> assertThat(winningLotto.winningMatch(third)).isEqualTo(LottoRank.THIRD),
            () -> assertThat(winningLotto.winningMatch(fourth)).isEqualTo(LottoRank.FOURTH),
            () -> assertThat(winningLotto.winningMatch(fifth)).isEqualTo(LottoRank.FIFTH),
            () -> assertThat(winningLotto.winningMatch(none)).isEqualTo(LottoRank.NONE)
        );
    }
}