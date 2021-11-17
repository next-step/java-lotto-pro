package step3.domain;

import static helper.Constants.*;
import static java.lang.String.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import lotto.component.SimpleLottoShuffler;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.Prizes;
import lotto.enums.Prize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    @ParameterizedTest(name = DISPLAY_NAME)
    @ValueSource(ints = {1000, 2000, 3000, 4000, 5000})
    void 돈을지불하면_로또티켓을_얻을_수_있다(final long moneyOfThousand) {
        //given
        final Money money = new Money(moneyOfThousand);

        //when
        final LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.publish(money, new SimpleLottoShuffler());

        //then
        assertAll(
            () -> assertThat(lottoTicket).isNotNull(),
            () -> assertThat(lottoTicket.size()).isEqualTo(money.exchangeLottoPurchasableCount())
        );
    }

    @Test
    void 로또당첨결과를_알수_있다() {
        //given
        final Money money = new Money(1000);
        final LottoNumber sameLottoNumberOne = new LottoNumber(1);
        final LottoNumber sameLottoNumberTwo = new LottoNumber(35);
        final LottoNumber sameLottoNumberThree = new LottoNumber(7);
        final LottoNumber sameLottoNumberFour = new LottoNumber(28);
        final LottoNumber sameLottoNumberFive = new LottoNumber(2);
        final LottoNumber sameLottoNumberSix = new LottoNumber(43);

        final Lotto winningLotto = new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberTwo, sameLottoNumberThree,
            sameLottoNumberFour, sameLottoNumberFive, sameLottoNumberSix
        ));

        final LottoTicket firstPlaceLottoTicket = new LottoTicket();
        firstPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, sameLottoNumberFive, sameLottoNumberSix
        )));

        final LottoTicket secondPlaceLottoTicket = new LottoTicket();
        secondPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, sameLottoNumberFive, new LottoNumber(45)
        )));

        final LottoTicket thirdPlaceLottoTicket = new LottoTicket();
        thirdPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, new LottoNumber(3), new LottoNumber(45)
        )));

        final LottoTicket forthPlaceLottoTicket = new LottoTicket();
        forthPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            new LottoNumber(27), new LottoNumber(3), new LottoNumber(45)
        )));

        //when
        final Prizes firstPrizes = firstPlaceLottoTicket.toWinningPrizes(winningLotto);
        final Prizes secondPrizes = secondPlaceLottoTicket.toWinningPrizes(winningLotto);
        final Prizes thirdPrizes = thirdPlaceLottoTicket.toWinningPrizes(winningLotto);
        final Prizes forthPrizes = forthPlaceLottoTicket.toWinningPrizes(winningLotto);

        //then
        final String formatResult = "%s- 1개";

        assertAll(
            () -> assertThat(firstPrizes.getResults()).contains(format(formatResult, Prize.FIRST_PLACE.message())),
            () -> assertThat(secondPrizes.getResults()).contains(format(formatResult, Prize.SECOND_PLACE.message())),
            () -> assertThat(thirdPrizes.getResults()).contains(format(formatResult, Prize.THIRD_PLACE.message())),
            () -> assertThat(forthPrizes.getResults()).contains(format(formatResult, Prize.FORTH_PLACE.message()))
        );
    }
}