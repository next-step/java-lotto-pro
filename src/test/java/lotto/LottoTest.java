package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3"}, delimiter = ':')
    @DisplayName("번호 일치 개수")
    void 로또_번호_일치_개수(String input, int expected) {
        Lotto winLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        assertThat(winLotto.getCorrectCount(lotto)).isEqualTo(expected);
    }
}
