package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 3, 5, 7, 9, 10)));
        lottoList.add(new Lotto(Arrays.asList(7, 10, 15, 20, 25, 35)));
        lottoList.add(new Lotto(Arrays.asList(3, 7, 20, 35, 43, 45)));
        lottos = new Lottos(lottoList);
    }

    @DisplayName("로또 게임 수익률을 계산한다.")
    @Test
    void playLottoGame() {
        int totalWinningMount = 200_000;
        int lottoPrice = 1000;
        assertEquals((double) 200_000 / (lottoPrice * lottos.lottoCount()), lottos.calcProfitRate(totalWinningMount));
    }

}
