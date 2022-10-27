package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatisticsTest {

    @Test
    @DisplayName("입력받은 지난 주 당첨번호는 6개여야 한다." +
            "또한 1~45사이의 숫자형으로만 이루어져야 한다.")
    void input_number_count_is_6_and_numberic() {
        assertThatThrownBy(() -> new Lotto("5, 6, 41, 26"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto("5, 6, 41, 26, 문자"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 지난 주 당첨번호와 이번 로또가 동일한지 확인할 수 있어야 한다.")
    void input_number_same_new_lotto() {
        assertThat(new Lotto("5, 6, 41, 26, 19, 33")
                .equals(new Lotto("5, 6, 41, 26, 19, 33")))
                .isTrue();
    }

    @Test
    @DisplayName("입력받은 지난주 당첨번호와 이번 로또의 몇개의 숫자가 일치하는지 계산해야한다.")
    void calculator_same_number_count() {
        assertThat(new Lotto("5, 6, 41, 26, 19, 33")
                .sameNumberCount(new Lotto("1, 6, 31, 26, 29, 33"))).isEqualTo(3);
    }

}
