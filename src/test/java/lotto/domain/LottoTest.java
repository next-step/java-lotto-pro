package lotto.domain;

import lotto.enums.LottoRank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static lotto.common.Messages.LOTTO_MINIMUM_PRICE;
import static lotto.domain.Lotto.gameCount;
import static lotto.domain.Lotto.generateLottoGame;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class LottoTest {

    @ParameterizedTest
    @ValueSource(strings = {"13000"})
    void 로또_구매시_게임_횟수_생성(String string) {
        // given
        Money money = new Money(string);

        // when
        int gameCount = gameCount(money);

        // then
        assertThat(gameCount).isEqualTo(13);
    }

    @ParameterizedTest
    @ValueSource(strings = {"800"})
    void 로또_구매시_잔액_부족(String string) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gameCount(new Money(string)))
                .withMessageContaining(LOTTO_MINIMUM_PRICE);
    }


    @Test
    void 로또_게임_생성() {
        // given()
        List<LottoNumbers> lottoNumbers = generateLottoGame(5);

        // when
        assertThat(lottoNumbers).size().isEqualTo(5);
    }

    @Test
    void 로또_게임_1등() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        List<LottoNumbers> purchasedLotto = new ArrayList<>();
        purchasedLotto.add(lottoNumbers);

        LottoNumbers lastWeekWinningNumber = new LottoNumbers(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        BonusBall bonusBall = new BonusBall("7");

        // when
        Lotto lotto = new Lotto(purchasedLotto);
        List<LottoRank> ranks = lotto.gamePlay(lastWeekWinningNumber, bonusBall);

        assertThat(ranks.stream()).size().isEqualTo(1);
        assertThat(ranks.stream().findFirst().get()).isEqualTo(LottoRank.FIRST);
    }
}
