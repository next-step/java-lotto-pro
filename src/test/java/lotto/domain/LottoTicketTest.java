package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {
    @Test
    @DisplayName("6개의 숫자 배열을 파라미터로 로또 티켓이 생성되어야 한다")
    void create() {
        // given
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        final LottoTicket lottoTicket = new LottoTicket(numbers);

        // then
        assertThat(lottoTicket).isInstanceOf(LottoTicket.class);
        assertThat(lottoTicket).isEqualTo(new LottoTicket(numbers));
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
            Assertions.assertThatThrownBy(() -> new LottoTicket(numbers))
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
            Assertions.assertThatThrownBy(() -> new LottoTicket(numbers))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
