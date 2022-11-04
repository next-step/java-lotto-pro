package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static final Lotto lotto = numbersToLotto(Arrays.asList(1,2,3,4,5,6));;


    @ParameterizedTest
    @DisplayName("로또번호와 입력된 숫자가 일치하면 true가 불일치하면 false가 오는지 확인")
    @CsvSource(value = {"1:true","2:true","3:true","4:true","5:true","6:true","7:false"}, delimiter = ':')
    void lotto_number_match_test(String input, boolean expected) {
        assertThat(lotto.isMatch(LottoNumber.of(input))).isEqualTo(expected);
    }

    static Stream<Arguments> lotto_match_number_check_test() {
        return Stream.of(Arguments.of(numbersToLotto(Arrays.asList(1,7,8,9,10,11)),1),
                Arguments.of(numbersToLotto(Arrays.asList(1,2,3,4,5,6)),6),
                Arguments.of(numbersToLotto(Arrays.asList(7,8,9,10,11,12)),0));
    }

    @ParameterizedTest
    @DisplayName("로또번호와 일치하는 숫자 개수가 정확히 오는지 확인")
    @MethodSource
    void lotto_match_number_check_test(Lotto input, int expected) {
        assertThat(lotto.getMatchNumber(input)).isEqualTo(expected);
    }

    public static Lotto numbersToLotto(List<Integer> numberList) {
        return new Lotto(numberList.stream()
                .map(number -> LottoNumber.of(number.toString()))
                .collect(Collectors.toList()));
    }
}
