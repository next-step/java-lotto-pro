package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 목록에 대한 테스트")
class LottosTest {
    private List<Lotto> 로또_목록;
    private WinningNumbers 정답_번호;

    @BeforeEach
    void setUp() {
        Lotto lotto = mock(Lotto.class);
        Lotto lotto_2 = mock(Lotto.class);
        Lotto lotto_3 = mock(Lotto.class);

        정답_번호 = mock(WinningNumbers.class);

        when(lotto.getWinningOfNumbersCount(any()))
            .thenReturn(3);
        when(lotto_2.getWinningOfNumbersCount(any()))
            .thenReturn(4);
        when(lotto_3.getWinningOfNumbersCount(any()))
            .thenReturn(5);

        로또_목록 = Arrays.asList(lotto, lotto_2, lotto_3);
    }

    @Test
    @DisplayName("로또 스코어의 개수가 정확히 계산되어 저장되어야 한다")
    void lottos_test() {
        Lottos lottos = new Lottos(로또_목록);
        LottoScore lottoScore = lottos.calculateLottoScore(정답_번호);

        Map<LottoWinnings, Integer> lottoScoreMap = lottoScore.getLottoScoreMap();
        assertThat(lottoScoreMap.get(LottoWinnings.THREE)).isEqualTo(1);
        assertThat(lottoScoreMap.get(LottoWinnings.FOUR)).isEqualTo(1);
        assertThat(lottoScoreMap.get(LottoWinnings.FIVE)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 목록들을 정답과 비교해 계산하면 정확하게 계산되어야 한다"
        + "3,4,5개 맞춘 로또의 당첨금의 합을 계산한다")
    void lottos_test2() {
        Lottos lottos = new Lottos(로또_목록);
        LottoScore lottoScore = lottos.calculateLottoScore(정답_번호);

        int expected = LottoWinnings.THREE.getWinnings() + LottoWinnings.FOUR.getWinnings() + LottoWinnings.FIVE.getWinnings();
        assertThat(lottoScore.getWinnings().getWinningsPrice()).isEqualTo(expected);
    }
}
