package lotto.domain;

import static java.lang.String.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import lotto.component.SimpleLottoShuffler;
import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

    @Test
    void 돈을지불하면_로또티켓을_얻을_수_있다() {
        //given
        final Money money = new Money(30000);

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
        final Ranks firstRanks = firstPlaceLottoTicket.toWinningRanks(winningLotto);
        final Ranks secondRanks = secondPlaceLottoTicket.toWinningRanks(winningLotto);
        final Ranks thirdRanks = thirdPlaceLottoTicket.toWinningRanks(winningLotto);
        final Ranks forthRanks = forthPlaceLottoTicket.toWinningRanks(winningLotto);

        //then
        final String formatResult = "%s- 1개";

        assertAll(
            () -> assertThat(firstRanks.getResults()).contains(format(formatResult, Rank.FIRST_PLACE.message())),
            () -> assertThat(secondRanks.getResults()).contains(format(formatResult, Rank.SECOND_PLACE.message())),
            () -> assertThat(thirdRanks.getResults()).contains(format(formatResult, Rank.THIRD_PLACE.message())),
            () -> assertThat(forthRanks.getResults()).contains(format(formatResult, Rank.FORTH_PLACE.message()))
        );
    }
}