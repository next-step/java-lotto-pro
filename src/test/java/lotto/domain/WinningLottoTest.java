package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {
    @Test
    @DisplayName("5개가 동일하고 보너스 번호를 가지고 있으면 2등을 반환함")
    void test1() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));

        Rank rank = lotto.getRankBy(winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND_WITH_BONUS);
    }

    @Test
    @DisplayName("5개가 동일하고 보너스 번호가 없다면 3등을 반환함")
    void test2() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));

        Rank rank = lotto.getRankBy(winningLotto);

        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    @DisplayName("보너스 번호가 없는 로또일 때는 항상 false를 반환함")
    void hasBonus(int bonusTry) {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.hasBonus(LottoNumber.of(bonusTry))).isFalse();
    }
}