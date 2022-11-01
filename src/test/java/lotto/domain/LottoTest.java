package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 번호가 6개가 아닌 경우 에러가 발생되는지 확인")
    @Test
    void Count() {
        List<Integer> numbers = Arrays.asList(1, 20, 30, 40, 45);

        assertThatThrownBy(() -> Lotto.from(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자 값이 있는 경우 에러가 발생되는지 확인")
    @Test
    void Duplication() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 40, 44);

        assertThatThrownBy(() -> Lotto.from(numbers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다른 로또와 로또 번호가 일치하는 개수를 반환되는지 확인")
    @Test
    void winningMatchCount() {
        Lotto lotto1 = Lotto.from(Arrays.asList(1, 10, 20, 30, 40, 45));
        Lotto lotto2 = Lotto.from(Arrays.asList(1, 11, 22, 33, 44, 45));

        assertThat(lotto1.matchLottoNumber(lotto2)).isEqualTo(2);
    }

    @DisplayName("당첨 로또 보너스 번호와 일치하는지 확인")
    @Test
    void matchBounsNumber() {
        LottoNumber winningLottoNumber = LottoNumber.from(7);
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 7));

        assertThat(lotto.matchBounsNumber(winningLottoNumber)).isTrue();
    }
}
