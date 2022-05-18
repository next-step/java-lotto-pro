package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 로또_생성() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumberValues()).contains(1, 3, 5, 7, 9, 23);
    }

    @Test
    void 로또는_6개의_숫자로_구성된다() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumberValues()).hasSize(numbers.length);
    }

    @Test
    void 예외테스트_로또는_6개의_숫자로_구성된다() {
        int[] numbers = {1, 3, 5, 7, 9, 23, 43};

        assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_변환() {
        int[] winningNumbers = {1, 2, 3, 4, 5, 6};
        Lotto winningLotto = new Lotto(winningNumbers);

        assertThat(winningLotto.getNumberValues()).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 일치_숫자_확인() {
        int[] numbers = {1, 3, 5, 7, 9, 23};
        Lotto lotto = new Lotto(numbers);

        int[] winningNumbers = {1, 3, 5, 7, 9, 23};
        Lotto winningLotto = new Lotto(winningNumbers);

        int count = lotto.getCount(winningLotto);
        assertThat(count).isEqualTo(6);
    }

}