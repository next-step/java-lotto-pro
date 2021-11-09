package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private WinningLotto winLotto;
    private Lottos lottos;
    private Result result;

    @BeforeEach
    void setUp() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        winLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));
        lottos = new Lottos(Arrays.asList(lotto1, lotto2));
        result = new Result(lottos, winLotto);
    }

    @DisplayName("수익률 결과")
    @Test
    void yieldResult() {
        BigInteger purchase = Price.totalPurchase(lottos.size());

        assertThat(lottos.size()).isEqualTo(2);
        assertThat(purchase.toString()).isEqualTo("2000");
        assertThat(result.yield(lottos.size())).isEqualTo("1000002.50");
    }
}
