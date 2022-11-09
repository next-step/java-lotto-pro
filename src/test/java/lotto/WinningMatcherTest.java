package lotto;

import lotto.common.Constants;
import lotto.ui.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.NumberFormat;

import static org.assertj.core.api.Assertions.assertThat;

class WinningMatcherTest {
    private static final String ONCE = "1000";
    private static final int ZERO = 0;
    private static final String BONUS_NUMBER = "6";

    private OutputStream captor;
    Lottos lottos;


    @BeforeEach
    void setUp() {
        lottos = new Lottos();
        lottos.add(new Lotto("1,2,3,4,5,7"));
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    public void 결과_테스트_1등() {
        // given
        Buyer buyer = new Buyer(lottos);
        // when
        WinningMatcher winningMatcher = new WinningMatcher(buyer, new WinningLotto("1,2,3,4,5,7", BONUS_NUMBER));
        new ResultView().printProfit(winningMatcher, ONCE);
        // then
        float expected = Rank.FIRST.getWinningMoney() / Integer.parseInt(ONCE);
        assertThat(output()).contains(cutDecimal(Constants.DECIMAL_POINT, expected));
    }

    @Test
    public void 결과_테스트_2등() {
        // given
        Lottos lottos = new Lottos();
        lottos.add(new Lotto("1,2,3,4,5,6"));
        Buyer buyer = new Buyer(lottos);
        // when
        WinningMatcher winningMatcher = new WinningMatcher(buyer, new WinningLotto("1,2,3,4,5,7", BONUS_NUMBER));
        print(winningMatcher, ONCE);
        // then
        float expected = Rank.SECOND.getWinningMoney() / Integer.parseInt(ONCE);
        assertThat(output()).contains(cutDecimal(Constants.DECIMAL_POINT, expected));
    }

    @Test
    public void 결과_테스트_3등() {
        // given
        Buyer buyer = new Buyer(lottos);
        // when
        WinningMatcher winningMatcher = new WinningMatcher(buyer, new WinningLotto("1,2,3,4,5,8", BONUS_NUMBER));
        print(winningMatcher, ONCE);
        // then
        float expected = Rank.THIRD.getWinningMoney() / Integer.parseInt(ONCE);
        assertThat(output()).contains(cutDecimal(Constants.DECIMAL_POINT, expected));
    }

    @Test
    public void 결과_테스트_꽝() {
        // given
        Buyer buyer = new Buyer(lottos);
        // when
        WinningMatcher winningMatcher = new WinningMatcher(buyer, new WinningLotto("12,11,10,9,7,8", BONUS_NUMBER));
        print(winningMatcher, ONCE);
        // then
        float expected = ZERO;
        assertThat(output()).contains(cutDecimal(Constants.DECIMAL_POINT, expected));
    }

    private final String output() {
        return captor.toString().trim();
    }

    public String cutDecimal(int cutSize, float value) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(cutSize);
        nf.setGroupingUsed(false);

        return nf.format(value);
    }

    public void print(WinningMatcher winningMatcher, String price) {
        new ResultView().printProfit(winningMatcher, price);
    }
}