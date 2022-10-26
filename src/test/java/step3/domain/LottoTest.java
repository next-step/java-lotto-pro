package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoTest {

    @Test
    @DisplayName("정상적으로 6개의 중복 없는 로또 번호를 생성해야 한다")
    void lotto_generate_not_duplicated_six_numbers() {

        // when
        Lotto lotto = Lotto.generate();

        // then
        Set<Integer> expected = new HashSet<>(lotto.getNumbers());
        assertThat(lotto.getNumbers()).hasSize(6);
        assertThat(lotto.getNumbers()).containsAll(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,10,15,20:3", "1,8,15,22,29,36:2,9,16,23,30,37:0"}, delimiter = ':')
    @DisplayName("로또 당첨번호와 로또번호를 비교하여 카운팅 결과를 반환한다")
    void lotto_return_number_count_compare_winNumbers(String lottoNumbers, String winNumbers, int expected) {
        // given
        List<Integer> numbers = getIntegerCollectionBy(lottoNumbers);
        List<Integer> wins = getIntegerCollectionBy(winNumbers);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.getNumberCountContainsBy(wins)).isEqualTo(expected);
    }

    private List<Integer> getIntegerCollectionBy(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}