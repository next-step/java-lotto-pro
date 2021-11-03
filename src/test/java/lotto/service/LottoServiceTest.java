package lotto.service;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("Lotto ball 6개를 만드는 테스트")
    void createLotto() {
        LottoCreator lottoCreator = new LottoCreator() {
            @Override
            public List<Integer> makeLotto() {
                return Arrays.asList(1, 10, 20, 32, 33, 34);
            }
        };

        LottoService lottoService = new LottoService();
        List<Lotto> lotto = lottoService.createLotto(1, lottoCreator);
        Lotto firstLotto = lotto.get(0);
        List<Ball> firstBalls = firstLotto.balls();

        Assertions.assertThat(firstBalls).containsExactly(new Ball(1), new Ball(10), new Ball(20),
                new Ball(32), new Ball(33), new Ball(34));
    }
}
