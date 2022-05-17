package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinnerLottoTest {

    @Test
    @DisplayName("보너스 넘버는 추출된 로또번호와 중복되지 않는다.")
    void isNotDistinctWinnerNumber() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new WinnerLotto(Lotto.createCustomLotto(Arrays.asList(1, 3, 4, 5, 6, 7)), LottoNumber.of(3))
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoResult")
    @DisplayName("로또의 결과를 맞춰 본다")
    void LottoMatch(List<Integer> lottoNumbers, LottoRank result) {
        Lotto winLotto = Lotto.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnerLotto winnerLotto = new WinnerLotto(winLotto, LottoNumber.of(7));
        Lotto lotto = Lotto.createCustomLotto(lottoNumbers);

        LottoRank lottoRank = winnerLotto.match(lotto);

        assertThat(lottoRank).isEqualTo(result);
        assertThat(lottoRank.rewordMoney()).isEqualTo(result.rewordMoney());
    }

    private static Stream<Arguments> provideLottoResult() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 9), LottoRank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 9, 7), LottoRank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 11, 12, 7), LottoRank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 42, 11, 12, 7), LottoRank.FAIL)

        );
    }



}
