package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    Lotto lotto;

    @BeforeEach
    public void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    static Stream<Arguments> generateWinningNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 16), LottoRank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 15, 16), LottoRank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 14, 15, 16), LottoRank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 13, 14, 15, 16), LottoRank.NONE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateWinningNumbers")
    public void 로또번호와_당첨번호_비교_후_당첨결과_반환(List<Integer> inputWinningNumbers, LottoRank rank) {
        //given
        LottoNumbers lottoWinningNumbers = new LottoNumbers(inputWinningNumbers);

        //when
        lotto.compareWinningNumbers(lottoWinningNumbers);

        //then
        assertThat(lotto.getLottoRank()).isEqualTo(rank);
    }

}
