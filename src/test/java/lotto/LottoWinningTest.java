package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoWinningTest {
    private LottoNumber lottoNumber;
    private LottoPurchase lottoPurchase;
    private LottoWinning lottoWinning;
    private List<Integer> answerList;

    @BeforeEach
    public void setUp() {
        lottoNumber = new LottoNumber(Arrays.asList(7, 8, 9, 15, 16, 17));
        lottoPurchase = new LottoPurchase(Collections.singletonList(lottoNumber));
        answerList = Arrays.asList(7, 8, 9, 10, 11, 12);
        lottoWinning = new LottoWinning(lottoPurchase, answerList);
    }

    @Test
    @DisplayName("로또 수익률을 확인한다.")
    void 테스트_로또_수익률_확인() {
        double result = 5d;
        Assertions.assertThat(lottoWinning.getProfit()).isEqualTo(result);
    }
}
