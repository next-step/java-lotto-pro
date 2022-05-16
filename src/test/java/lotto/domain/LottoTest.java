package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.LottoTestUtils;
import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoWinResult;
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
    void 로또_당첨_번호와_비교하여_갯수가_맞는지(LottoNumbers lottoNumbers, LottoNumbers winNumbers, LottoWinResult winResult) {
        // given
        final Lotto auto = Lotto.generate(lottoNumbers);

        // when & then
        assertThat(auto.confirm(winNumbers)).isEqualByComparingTo(winResult);
    }

    static Stream<Arguments> compareNumbers() {
        return Stream.of(
                Arguments.of(LottoTestUtils.lottoNumbers(1, 2, 3, 4, 5, 6),
                        LottoTestUtils.lottoNumbers(1, 2, 3, 4, 5, 6), LottoWinResult.FIRST),
                Arguments.of(LottoTestUtils.lottoNumbers(1, 2, 3, 4, 5, 6),
                        LottoTestUtils.lottoNumbers(1, 2, 3, 4, 7, 8), LottoWinResult.THIRD),
                Arguments.of(LottoTestUtils.lottoNumbers(1, 2, 3, 4, 5, 6),
                        LottoTestUtils.lottoNumbers(7, 8, 9, 10, 11, 12), LottoWinResult.NO_WIN)
        );
    }
}