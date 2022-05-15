package lotto.controller;

import lotto.controller.LottoGame;
import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {
    private LottoGame game;

    @BeforeEach
    public void beforeEach() {
        game = new LottoGame();
    }

    @ParameterizedTest
    @ValueSource(longs = { LOTTO_PRICE, 100 * LOTTO_PRICE, 1000 * LOTTO_PRICE })
    public void 로또_구매하기(long price) {
        Money money = new Money(price);
        PurchasedLotto lottos = game.purchaseLotto(money);
        assertThat(lottos.getLottoList()).hasSize((int)price / LOTTO_PRICE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6:FIRST", "1,2,3,4,5,7:5:SECOND", "1,2,3,4,7,8:4:THIRD", "1,2,3,7,8,9:3:FOURTH"}, delimiter = ':')
    public void 번호_맞춘_개수에_대한_등수_확인(String lottoNumbers, int matchingCount, Ranking expected) {
        Lotto lastWinningLotto = new Lotto("1,2,3,4,5,6");
        PurchasedLotto purchasedLotto = new PurchasedLotto(Arrays.asList(new Lotto(lottoNumbers)));
        LottoResult lottoResult = game.matchLottoNumbers(purchasedLotto, lastWinningLotto);
        assertThat(lottoResult.findRankings(matchingCount).get(0)).isEqualTo(expected);
    }
}
