package lotto.model;

import lotto.service.LottoAutoCreateFactory;
import lotto.util.PriceUtil;
import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lotto winLotto;
    private Lottos lottos;
    private Result result;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        Lotto lotto2 = new Lotto(new int[]{4, 5, 6, 7, 8, 9});
        winLotto = new Lotto(new int[]{1, 2, 3, 4, 5, 6});
        lottos = new Lottos(new Lotto[]{lotto1, lotto2});
        Map<Rank, Integer> matchResult = lottos.matchResult(winLotto);
        result = new Result(matchResult);
    }

    @DisplayName("갯수를 입력받아 로또를 여러개 생성하는 기능 검증")
    @Test
    void createLottos() {
        Lottos lottos = LottoAutoCreateFactory.createLottos(20);
        assertThat(lottos.size()).isEqualTo(20);
    }

    @DisplayName("로또 당첨 상태값을 가지는 객체 검증")
    @Test
    void rankReport() {
        Map<Rank, Integer> matchResult = lottos.matchResult(winLotto);

        assertThat(matchResult.size()).isEqualTo(5);
        assertThat(matchResult.get(Rank.FIRST)).isEqualTo(1);
        assertThat(matchResult.get(Rank.FOURTH)).isEqualTo(1);
        assertThat(matchResult.get(Rank.THIRD)).isEqualTo(0);
    }

    @DisplayName("당첨 통계 결과 검증")
    @Test
    void report() {
        assertThat(result.toString()).isEqualTo("3개 일치 (5000원)- 1개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "6개 일치 (2000000000원)- 1개\n");

    }

    @DisplayName("수익률 결과")
    @Test
    void name() {
        //TODO
        BigInteger purchase = PriceUtil.getPurchase(lottos.size());
        assertThat(result.yield(purchase)).isEqualTo("0.00");
    }
}
