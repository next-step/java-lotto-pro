package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("정상적으로 6개의 중복 없는 로또 번호를 생성해야 한다")
    void lotto_generate_not_duplicated_six_numbers() {

        // when
        Lotto lotto = Lotto.generate();

        // then
        Set<Integer> expected = new HashSet<>(lotto.getNumbers());
        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).containsAll(expected);
    }

}