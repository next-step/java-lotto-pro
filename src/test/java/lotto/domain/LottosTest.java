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
        정답_번호 = new WinningNumbers("1,2,3,4,5,6");
        정답_번호.addBonusNumber(new BonusNumber("45"));

        Lotto FIFTH_LOTTO = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        Lotto FOURTH_LOTTO = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        Lotto THIRD_LOTTO = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));

        로또_목록 = Arrays.asList(FIFTH_LOTTO, FOURTH_LOTTO, THIRD_LOTTO);

    }

    @Test
    @DisplayName("로또 스코어의 개수가 정확히 계산되어 저장되어야 한다")
    void lottos_test() {
        Lottos lottos = new Lottos(로또_목록);
        LottoScore lottoScore = lottos.calculateLottoScore(정답_번호);

        Map<Rank, Integer> rankMap = lottoScore.getRankMap();
        assertThat(rankMap.get(Rank.FIFTH)).isEqualTo(1);
        assertThat(rankMap.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(rankMap.get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 목록들을 정답과 비교해 계산하면 정확하게 계산되어야 한다"
        + "3,4,5개 맞춘 로또의 당첨금의 합을 계산한다")
    void lottos_test2() {
        Lottos lottos = new Lottos(로또_목록);
        LottoScore lottoScore = lottos.calculateLottoScore(정답_번호);

        int expected = Rank.FIFTH.getWinningsMoney() + Rank.FOURTH.getWinningsMoney()
            + Rank.THIRD.getWinningsMoney();
        assertThat(lottoScore.getWinnings().getWinningsPrice()).isEqualTo(expected);
    }
}
