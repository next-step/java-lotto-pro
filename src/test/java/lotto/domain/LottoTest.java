package lotto.domain;

import static lotto.constants.LottoConstants.SPLIT_SYMBOL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또에 대한 테스트")
class LottoTest {

    @DisplayName("로또에 당첨번호를 넘기면 당첨 개수를 정상적으로 반환해야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:3", "10,2,43,6,19,22:1", "45,4,5,19,23,30:2",
        "12,10,7,5,4,44:3"}, delimiter = ':')
    void lotto_winning_number_test(String 당첨_번호, int 예상_당첨_개수) {
        List<LottoNo> 로또_번호 = convert(Arrays.asList(4, 5, 6, 7, 8, 9));

        WinningNumbers winningNumbers = new WinningNumbers(당첨_번호);
        winningNumbers.addBonusNumber(new LottoNo(42));

        Lotto lotto = new Lotto(로또_번호);
        int 당첨_개수 = winningNumbers.getMatchOfCount(lotto);

        assertThat(당첨_개수).isEqualTo(예상_당첨_개수);
    }

    @DisplayName("로또에 번호를 전달하면 정렬되어야 한다")
    @Test
    void lotto_sort_test() {
        List<LottoNo> given = convert(Arrays.asList(11, 15, 28, 43, 12, 7));
        Lotto lotto = new Lotto(given);

        List<LottoNo> actual = convert(Arrays.asList(7, 11, 12, 15, 28, 43));
        assertThat(lotto.getNumbers()).containsExactly(actual.get(0), actual.get(1), actual.get(2),
            actual.get(3), actual.get(4), actual.get(5));
    }

    @DisplayName("로또의 길이가 6 이외의 값이 오면 예외가 발생해야 한다")
    @Test
    void lotto_number_size_test() {
        List<LottoNo> numbers = convert(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThatThrownBy(() -> {
            new Lotto(numbers);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    private List<LottoNo> convert(List<Integer> numbers) {
        return numbers.stream().map(LottoNo::new)
            .collect(Collectors.toList());
    }

    private List<LottoNo> convert(String input) {
        return Stream.of(input.split(SPLIT_SYMBOL)).map(LottoNo::new)
            .collect(Collectors.toList());
    }
}
