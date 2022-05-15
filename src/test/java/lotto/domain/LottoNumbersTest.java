package lotto.domain;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoNumbersTest {

    @ParameterizedTest
    @MethodSource("provideLottoSize")
    @DisplayName("로또의 숫자는 6자리만 가능하다.")
    void lottoSize(List<Integer> lottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(lottoNumber));
    }

    @Test
    @DisplayName("로또의 숫자는 순서대로 되어 있다.")
    void autoLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 4, 3, 5, 6, 7));

        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1, 3, 4, 5, 6, 7)));
    }

    @Test
    @DisplayName("로또숫자들의 맞은 갯수를 구한다.")
    void matchLottoNumberCount() {
        LottoNumbers result = new LottoNumbers(Arrays.asList(1, 4, 3, 5, 6, 7));
        LottoNumbers match = new LottoNumbers(Arrays.asList(1, 3, 5, 40, 44, 45));

        assertThat(result.matchCount(match)).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 숫자들이 중복 되지 않아야 한다")
    void isNotDuplicated() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(Arrays.asList(1, 3, 5, 40, 44, 44)));
    }

    private static Stream<Arguments> provideLottoSize() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 3, 4, 5, 6, 7, 8)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(new ArrayList<>()),
                Arguments.of((Object) null)
        );
    }


}
