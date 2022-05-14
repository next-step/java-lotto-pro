package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("로또 번호는 6개로 구성되어 있어야합니다");
    }

    @Test
    @DisplayName("로또 번호가 중복되면  IllegalArgumentException을 발생시킨다.")
    void 로또중복_test() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(2, 3, 4, 5, 6, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .withFailMessage("로또 각 번호는 중복될수 없습니다.");
    }
}
