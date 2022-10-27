package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,10,15,20:3", "1,8,15,22,29,36:2,9,16,23,30,37:0"}, delimiter = ':')
    @DisplayName("로또 당첨번호와 로또번호를 비교하여 카운팅 결과를 반환한다")
    void lotto_return_number_count_compare_winNumbers(String lottoNumbers, String winNumbers, int expected) {
        // given
        List<Integer> numbers = getIntegerCollectionBy(lottoNumbers);
        Lotto winLotto = Lotto.of(getIntegerCollectionBy(winNumbers));

        // when
        Lotto lotto = Lotto.of(numbers);

        // then
        assertThat(lotto.getNumberCountContainsBy(winLotto)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "4,5,6", "1,2,3,10,15", "1,8,15,22,29,36,2,9,16,23,30,37"})
    @DisplayName("로또 생성 시 로또 번호가 6개가 아닐경우 에러 발생")
    void lotto_throw_exception_when_number_size_is_not_six(String lottoNumbers) {
        // given
        List<Integer> numbers = getIntegerCollectionBy(lottoNumbers);

        // when && then
        assertThatThrownBy(() -> Lotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> getIntegerCollectionBy(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
