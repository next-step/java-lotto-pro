package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    private Lotto createLotto(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.from(number));
        }
        return new Lotto(lottoNumbers);
    }

    @Test
    @DisplayName("로또 번호는 6개만 가능합니다.")
    void size_test() {
        assertThatThrownBy(() -> {
            Lotto lotto = createLotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("로또 번호들은 중복이 되면 안됩니다.")
    void duplicate_test() {
        assertThatThrownBy(() -> {
            Lotto lotto = createLotto(Arrays.asList(1, 1, 3, 4, 5, 6));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호들은 중복이 되면 안됩니다.");
    }

    @Test
    @DisplayName("로또 번호는 1 ~ 45 사이의 값이어야 합니다.")
    void range_test() {
        assertThatThrownBy(() -> {
            Lotto lotto = createLotto(Arrays.asList(1, 46, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContainingAll("로또 번호는 1 ~ 45 사이의 값이어야 합니다.");
    }

    @Test
    @DisplayName("두 개의 로또를 비교하여 매칭 결과를 반환한다.")
    void match_test() {
        Lotto lotto = createLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winLotto = createLotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto.matchCounts(winLotto)).isEqualTo(3);
    }
}
