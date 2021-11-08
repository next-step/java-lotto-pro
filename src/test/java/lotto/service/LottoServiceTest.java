package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoServiceTest {

    private WinningLotto winningLotto;
    private final LottoService lottoService = new LottoService();

    @BeforeEach
    void setUp() {
        lottoService.makeWinningLotto(Arrays.asList(10, 11, 12, 13, 14, 15), 7);
        winningLotto = lottoService.winningLotto();
    }

    @Test
    @DisplayName("Lotto ball 6개를 만드는 테스트")
    void createLotto() {
        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.createAutoLotto(1);
        List<Lotto> lottoBasket = lottos.lottos();
        Lotto firstLotto = lottoBasket.get(0);
        List<Ball> firstBalls = firstLotto.balls();

        assertThat(firstBalls.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("5등 테스트")
    void rank_FIFTH() {
        Lotto lotto = makeLottoBall(Arrays.asList(1, 11, 12, 13, 25, 36));
        Rank resultRank = lottoService.match(lotto);
        assertThat(resultRank).isEqualTo(Rank.FIFTH);
    }

    @Test
    @DisplayName("4등 테스트")
    void rank_FOURTH() {
        Lotto lotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 25, 36));
        Rank resultRank = lottoService.match(lotto);
        assertThat(resultRank).isEqualTo(Rank.FOURTH);
    }

    @Test
    @DisplayName("3등 테스트")
    void rank_THIRD() {
        Lotto lotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 14, 36));
        Rank resultRank = lottoService.match(lotto);
        assertThat(resultRank).isEqualTo(Rank.THIRD);
    }

    @Test
    @DisplayName("2등 테스트")
    void rank_SECOND() {
        Lotto lotto = makeLottoBall(Arrays.asList(7, 10, 11, 12, 13, 14));
        Rank resultRank = lottoService.match(lotto);
        assertThat(resultRank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("1등 테스트")
    void rank_FIRST() {
        Lotto lotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 14, 15));
        Rank resultRank = lottoService.match(lotto);
        assertThat(resultRank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("결과 통계 테스트 1등 1개, 2등 1개, 3등 2개,4등 2개, 5등 2개")
    void rankTotalCountTEST() {
        Lotto firstLotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 14, 15));

        Lotto secondLotto = makeLottoBall(Arrays.asList(7, 10, 11, 12, 13, 14));

        Lotto thirdLotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 14, 36));
        Lotto thirdLotto2 = makeLottoBall(Arrays.asList(9, 11, 12, 13, 14, 15));

        Lotto fourthLotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 25, 36));
        Lotto fourthLotto2 = makeLottoBall(Arrays.asList(10, 11, 12, 13, 25, 36));

        Lotto fifthLotto = makeLottoBall(Arrays.asList(1, 11, 12, 13, 25, 36));
        Lotto fifthLotto2 = makeLottoBall(Arrays.asList(10, 11, 12, 17, 25, 36));

        Lottos lottos = new Lottos(Arrays.asList(firstLotto, secondLotto,
                thirdLotto, thirdLotto2, fourthLotto, fourthLotto2, fifthLotto, fifthLotto2));
        Map<Rank, Integer> resultLotto = lottoService.result(lottos);
        assertAll(
                () -> assertThat(resultLotto.get(Rank.FIRST)).isEqualTo(1),
                () -> assertThat(resultLotto.get(Rank.SECOND)).isEqualTo(1),
                () -> assertThat(resultLotto.get(Rank.THIRD)).isEqualTo(2),
                () -> assertThat(resultLotto.get(Rank.FOURTH)).isEqualTo(2),
                () -> assertThat(resultLotto.get(Rank.FIFTH)).isEqualTo(2)
        );
    }

    private Lotto makeLottoBall(List<Integer> balls) {
        List<Ball> ballBasket = balls.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        return new Lotto(ballBasket);
    }
}
