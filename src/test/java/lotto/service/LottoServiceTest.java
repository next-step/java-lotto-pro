package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private Lotto winningLotto;
    private final LottoService lottoService = new LottoService();

    @BeforeEach
    void setUp() {
        lottoService.makeWinningLotto(Arrays.asList(10, 11, 12, 13, 14, 15));
        winningLotto = lottoService.winningLotto();
    }

    @Test
    @DisplayName("Lotto ball 6개를 만드는 테스트")
    void createLotto() {
        LottoService lottoService = new LottoService();
        Lottos lottos = lottoService.createLotto(1);
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
    @DisplayName("1등 테스트")
    void rank_FIRST() {
        Lotto lotto = makeLottoBall(Arrays.asList(10, 11, 12, 13, 14, 15));
        Rank resultRank = lottoService.match(lotto);
        assertThat(resultRank).isEqualTo(Rank.FIRST);
    }

    private Lotto makeLottoBall(List<Integer> balls) {
        List<Ball> ballBasket = balls.stream()
                .map(number -> new Ball(number))
                .collect(Collectors.toList());
        return new Lotto(ballBasket);
    }
}
