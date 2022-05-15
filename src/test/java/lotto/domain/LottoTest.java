package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
        List<Integer> 로또_번호 = Arrays.asList(4, 5, 6, 7, 8, 9);

        Lotto lotto = new Lotto(로또_번호);
        int 당첨_개수 = lotto.getWinningOfNumbersCount(convert(당첨_번호));

        assertThat(당첨_개수).isEqualTo(예상_당첨_개수);
    }

    private List<Integer> convert(String input) {
        return Stream.of(input.split(WinningNumbers.SPLIT_SYMBOL)).mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    @DisplayName("로또에 번호를 전달하면 정렬되어야 한다")
    @Test
    void lotto_sort_test() {
        List<Integer> given = Arrays.asList(11, 15, 28, 43, 12, 7);
        Lotto lotto = new Lotto(given);

        assertThat(lotto.getNumbers()).containsExactly(7, 11, 12, 15, 28, 43);
    }
}
