package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Lotto;
import step3.model.LottoNumber;
import step3.model.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    List<LottoNumber> getLottoNumbers(int... numbers) {

        List<LottoNumber> lottoNumbers = new ArrayList();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.valueOf(number));
        }
        return lottoNumbers;
    }

    @Test
    @DisplayName("번호조회하면 번호를 반환")
    void test_that_it_returns_numbers() {
        //given
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        //when
        Lotto lotto = new Lotto(lottoNumbers);
        List<LottoNumber> numbers = lotto.getNumbers();

        //then;
        assertThat(numbers.get(0).value()).isEqualTo(1);
        assertThat(numbers.get(1).value()).isEqualTo(2);
        assertThat(numbers.get(2).value()).isEqualTo(3);
        assertThat(numbers.get(3).value()).isEqualTo(4);
        assertThat(numbers.get(4).value()).isEqualTo(5);
        assertThat(numbers.get(5).value()).isEqualTo(6);
    }

    @Test
    @DisplayName("번호개수가 6개가 아니면 예외발생")
    void test_that_throw_exception_when_number_size_not_6() {
        //given
        List<LottoNumber> numbers = IntStream.range(1, 8).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호는 6개만 허용합니다");
    }

    @Test
    @DisplayName("중복번호가 있으면 예외발생")
    void test_that_throw_exception_when_contains_duplicate_number() {
        //given
        List<LottoNumber> numbers = IntStream.range(1, 7).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        numbers.add(LottoNumber.valueOf(6));

        //when,then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복없는 번호만 허용합니다");
    }

    @Test
    @DisplayName("번호가 1에서 45사이가 아니면 예외발생")
    void test_that_throw_exception_when_number_is_outofrange() {
        //given
        List<LottoNumber> numbers = IntStream.range(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when,then
        assertThatThrownBy(() -> numbers.add(LottoNumber.valueOf(68)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호는 1에서 45사이만 허용합니다");
    }

    @Test
    @DisplayName("당첨번호가 3개 일치하면 5등조회")
    void test_that_it_returns_5th_if_3_winning_numbers_match() {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);
        Rank rank = lotto.getRank(new Lotto(getLottoNumbers(1, 2, 3, 11, 12, 13)));

        //then
        assertThat(rank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("당첨번호가 4개 일치하면 4등조회")
    void test_that_it_returns_4th_if_4_winning_numbers_match() {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
        //when
        Lotto lotto = new Lotto(numbers);
        Rank rank = lotto.getRank(new Lotto(getLottoNumbers(1, 2, 3, 4, 12, 13)));

        //then
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("당첨번호가 5개 일치하면 3등조회")
    void test_that_it_returns_3th_if_5_winning_numbers_match() {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);
        Rank rank = lotto.getRank(new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 13)));

        //then
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("당첨번호가 6개 일치하면 1등조회")
    void test_that_it_returns_1th_if_all_winning_numbers_match() {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);
        Rank rank = lotto.getRank(new Lotto(getLottoNumbers(1, 2, 3, 4, 5, 6)));

        //then
        assertThat(rank).isEqualTo(Rank.FIRST);
    }


    @Test
    @DisplayName("당첨번호가 3개 미만 일치하면 MISS값 조회")
    void test_that_it_returns_miss_if_less_then_3_winning_number_match() {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);
        Rank rank = lotto.getRank(new Lotto(getLottoNumbers(1, 2, 13, 14, 15, 16)));

        //then
        assertThat(rank).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("기본생성자인경우 로또조회시 자동로또")
    void test_that_returns_auto_if_base_constructor() {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers);

        //then
        assertThat(lotto.isAuto()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true,false})
    @DisplayName("생성자에서 로또 자동여부 지정시 메소드에서 조회")
    void test_that_returns_auto_if_selected_at_constructor(boolean isAuto) {
        //given
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 6).boxed()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());

        //when
        Lotto lotto = new Lotto(numbers,isAuto);

        //then
        assertThat(lotto.isAuto()).isEqualTo(isAuto);
    }


}
