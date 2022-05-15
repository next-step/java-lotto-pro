package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("로또 번호는 6개만 가능합니다.")
    void size_test() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("로또 번호들은 중복이 되면 안됩니다.")
    void duplicate_test() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(1),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호들은 중복이 되면 안됩니다.");
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45 사이의 값이어야 합니다.")
    void range_test() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                    new LottoNumber(46),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호는 1 ~ 45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("두 개의 로또를 비교하여 매칭 결과를 반환한다.")
    void match_test() {
        Lotto lotto = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
        Lotto winLotto = new Lotto(Arrays.asList(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9)));
        assertThat(lotto.match(winLotto)).isEqualTo(Rank.FIFTH);
    }
}
