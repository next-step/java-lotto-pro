package lotto.domain;

import static lotto.LottoTestUtils.lottoNumbers;
import static lotto.LottoTestUtils.winningNumbers;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    @Test
    void 로또_생성_테스트() {
        // when & then
        assertThat(Lotto.generate()).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("compareNumbers")
    void 로또_당첨_번호와_비교하여_갯수가_맞는지(LottoNumbers lottoNumbers, WinningNumbers winNumbers, LottoWinResult winResult) {
        // given
        final Lotto auto = Lotto.generate(lottoNumbers);

        // when & then
        assertThat(auto.confirm(winNumbers)).isEqualByComparingTo(winResult);
    }

    static Stream<Arguments> compareNumbers() {
        return Stream.of(
                Arguments.of(lottoNumbers(1, 2, 3, 4, 5, 6),
                        winningNumbers(1, 2, 3, 4, 5, 6, 7), LottoWinResult.FIRST),
                Arguments.of(lottoNumbers(1, 2, 3, 4, 5, 6),
                        winningNumbers(1, 2, 3, 4, 5, 7, 8), LottoWinResult.THIRD),
                Arguments.of(lottoNumbers(1, 2, 3, 4, 5, 6),
                        winningNumbers(7, 8, 9, 10, 11, 12, 13), LottoWinResult.NO_WIN)
        );
    }

}