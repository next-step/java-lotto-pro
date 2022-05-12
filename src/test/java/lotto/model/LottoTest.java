package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("로또 번호는 6개의 수로 이루어져 있다.")
    void 로또_test() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLottoNumber()).hasSize(6);
    }

    @Test
    @DisplayName("로또 번호 6개가 아니면 IllegalArgumentException을 발생시킨다.")
    void 로또_생성예외_test() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
