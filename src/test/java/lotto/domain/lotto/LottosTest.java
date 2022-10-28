package lotto.domain.lotto;

import lotto.prize.Prize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @ParameterizedTest
    @MethodSource("lottoInfo")
    @DisplayName("당첨로또와 비교하여 각각의 로또의 상금에 대한 결과 리턴")
    void prize_of_lotto(Lotto lotto, Lotto winnerLotto, Prize prize, int expect, int mapSize) {
        Lottos lottos = new Lottos(Collections.singletonList(lotto));
        Map<Prize, Integer> map = lottos.getPrizeOfLotto(winnerLotto);
        assertThat(map).hasSize(mapSize);
        assertThat(map.get(prize)).isEqualTo(expect);
    }

    private static Stream<Arguments> lottoInfo() {
        List<LottoNumber> lottoNumbers = Stream.of(1, 2, 3, 4, 5, 6).map(LottoNumber::new).collect(Collectors.toList());
        List<LottoNumber> winnerLottoNumbers = Stream.of(1, 2, 3, 4, 5, 7).map(LottoNumber::new).collect(Collectors.toList());
        return Stream.of(
                Arguments.of(new Lotto(lottoNumbers), new Lotto(winnerLottoNumbers), Prize.SECOND, 1, 1)
        );
    }
}
