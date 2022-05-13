package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {
    @Test
    @DisplayName("6개의 숫자 배열을 파라미터로 로또 번호가 생성되어야 한다")
    void create() {
        // given
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        final LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        // then
        assertThat(lottoNumbers).isInstanceOf(LottoNumbers.class);
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(numbers));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 IllegalArgumentException을 발생시킨다")
    void when_amount_of_numbers_is_not_six_should_throw_IllegalArgumentException() {
        // given
        final List<Integer> empty = new ArrayList<>();
        final List<Integer> lessThanSix = Arrays.asList(1);
        final List<Integer> greaterThanSix = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        final List<List<Integer>> numbersList = new ArrayList<>();
        numbersList.add(empty);
        numbersList.add(lessThanSix);
        numbersList.add(greaterThanSix);

        // when and then
        for (List<Integer> numbers : numbersList) {
            Assertions.assertThatThrownBy(() -> new LottoNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("1보다 작거나 45보다 큰 번호가 하나라도 있으면 IllegalrgumentException을 발생시킨다")
    void when_number_is_invalid_should_throw_IllegalArgumentException() {
        // given
        final List<Integer> zero = Arrays.asList(1, 2, 3, 4, 5, 0);
        final List<Integer> lessThanZero = Arrays.asList(-1, 1, 2, 3, 4, 5);
        final List<Integer> greaterThanFortyFIve = Arrays.asList(1, 2, 46, 3, 4, 5);
        final List<List<Integer>> numbersList = new ArrayList<>();
        numbersList.add(zero);
        numbersList.add(lessThanZero);
        numbersList.add(greaterThanFortyFIve);

        // when and then
        for (List<Integer> numbers : numbersList) {
            Assertions.assertThatThrownBy(() -> new LottoNumbers(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    @DisplayName("주어진 번호가 3개 미만으로 일치하면 0이 반환되어야 한다")
    void when_no_matches_should_return_0() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers noMatchesNumbers = new LottoNumbers(Arrays.asList(13, 21, 34, 37, 41, 44));
        final LottoNumbers oneMatchesNumbers = new LottoNumbers(Arrays.asList(3, 21, 34, 37, 41, 44));
        final LottoNumbers twoMatchesNumbers = new LottoNumbers(Arrays.asList(2, 5, 34, 37, 41, 44));

        // when and then
        assertThat(noMatchesNumbers.matches(winningNumbers)).isEqualTo(0);
        assertThat(oneMatchesNumbers.matches(winningNumbers)).isEqualTo(0);
        assertThat(twoMatchesNumbers.matches(winningNumbers)).isEqualTo(0);
    }

    @Test
    @DisplayName("주어진 번호가 3개 일치하면 3이 반환되어야 한다")
    void when_three_matches_should_return_3() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(2, 3, 6, 37, 41, 44));

        // when and then
        assertThat(numbers.matches(winningNumbers)).isEqualTo(3);
    }

    @Test
    @DisplayName("주어진 번호가 4개 일치하면 4가 반환되어야 한다")
    void when_four_matches_should_return_4() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(1, 3, 5, 6, 41, 44));

        // when and then
        assertThat(numbers.matches(winningNumbers)).isEqualTo(4);
    }

    @Test
    @DisplayName("주어진 번호가 5개 일치하면 5가 반환되어야 한다")
    void when_five_matches_should_return_5() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(1, 3, 4, 5, 6, 44));

        // when and then
        assertThat(numbers.matches(winningNumbers)).isEqualTo(5);
    }

    @Test
    @DisplayName("주어진 번호가 6개 일치하면 6이 반환되어야 한다")
    void when_six_matches_should_return_6() {
        // given
        final LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers numbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when and then
        assertThat(numbers.matches(winningNumbers)).isEqualTo(6);
    }
}
