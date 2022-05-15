package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_생성() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers()).contains(
                new Number(1),
                new Number(3),
                new Number(5),
                new Number(7),
                new Number(9),
                new Number(23));
    }

    @Test
    void 로또는_6개의_숫자로_구성된다() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.size()).isEqualTo(numbers.length);
    }

    @Test
    void 예외테스트_로또는_6개의_숫자로_구성된다() {
        int[] numbers = {1, 3, 5, 7, 9, 23, 43};

        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외테스트_로또는_1부터_45까지의_숫자로_이루어져_있다() {
        int[] numbers = {1, 68, 5, 7, 9, 23};

        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

}