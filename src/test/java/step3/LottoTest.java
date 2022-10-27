package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {


    @Test
    @DisplayName("가격조회하면 1000을 반환")
    void test_that_it_returns_1000() {
        //given
        List<Integer> numbers = IntStream.range(1, 7).boxed().collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.getPrice()).isEqualTo(1000);
    }


    @Test
    @DisplayName("번호조회하면 번호를 반환")
    void test_that_it_returns_numbers() {
        //given
        List<Integer> numbers = IntStream.range(1, 7).boxed().collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("번호개수가 6개가 아니면 예외발생")
    void test_that_throw_exception_when_number_size_not_6() {
        //given
        List<Integer> numbers = IntStream.range(1, 8).boxed().collect(Collectors.toList());

        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호는 6개만 허용합니다");
    }

    @Test
    @DisplayName("중복번호가 있으면 예외발생")
    void test_that_throw_exception_when_contains_duplicate_number() {
        //given
        List<Integer> numbers = IntStream.range(1, 7).boxed().collect(Collectors.toList());
        numbers.add(6);

        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복없는 번호만 허용합니다");
    }

    @Test
    @DisplayName("번호가 1에서 45사이가 아니면 예외발생")
    void test_that_throw_exception_when_number_is_outofrange() {
        //given
        List<Integer> numbers = IntStream.range(1, 6).boxed().collect(Collectors.toList());
        numbers.add(48);

        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1에서 45사이 번호만 허용합니다");
    }

    @Test
    @DisplayName("당첨번호가 3개 일치하면 5등조회")
    void test_that_it_returns_5th_if_3_winning_numbers_match() {
        //given
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 6).boxed()
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 11, 12, 13}).boxed().collect(Collectors.toList());
        Rank rank = lotto.getRank(winningNumbers);

        //then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨번호가 4개 일치하면 4등조회")
    void test_that_it_returns_4th_if_4_winning_numbers_match() {
        //given
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 6).boxed()
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 12, 13}).boxed().collect(Collectors.toList());
        Rank rank = lotto.getRank(winningNumbers);

        //then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("당첨번호가 5개 일치하면 3등조회")
    void test_that_it_returns_3th_if_5_winning_numbers_match() {
        //given
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 6).boxed()
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 13}).boxed().collect(Collectors.toList());
        Rank rank = lotto.getRank(winningNumbers);

        //then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨번호가 6개 일치하면 1등조회")
    void test_that_it_returns_1th_if_all_winning_numbers_match() {
        //given
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 6).boxed()
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList());
        Rank rank = lotto.getRank(winningNumbers);

        //then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }


    @ParameterizedTest
    @MethodSource("missLottoNumberProvider")
    @DisplayName("당첨번호가 3개 미만 일치하면 MISS값 조회")
    void test_that_it_returns_miss_if_less_then_3_winning_number_match(List<Integer> winningNumbers) {
        //given
        List<Integer> lottoNumbers = IntStream.rangeClosed(1, 6).boxed()
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(lottoNumbers);
        Rank rank = lotto.getRank(winningNumbers);

        //then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    static Stream<List> missLottoNumberProvider() {
        return Stream.of(
                Arrays.asList(1, 2, 13, 14, 15, 16),
                Arrays.asList(1, 22, 13, 14, 15, 16),
                Arrays.asList(11, 12, 13, 14, 15, 16));
    }


}
