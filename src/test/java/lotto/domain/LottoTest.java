package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("6개의 로또번호가 발급되는지 검증한다.")
    void 로또번호_6개_발급_검증() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6L);
    }

    @Test
    @DisplayName("잘못된 갯수의 로또번호일 때 예외처리한다.")
    void 로또번호_갯수_오류_예외() {
        assertThatThrownBy(
                () -> {
                    new Lotto(Arrays.asList(1, 2, 3, 4, 5));
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
