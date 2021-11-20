package lotto.domain;

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
            sameLottoNumberFour, sameLottoNumberFive, new LottoNumber(45)
        )));

        final LottoTicket forthPlaceLottoTicket = new LottoTicket();
        forthPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, new LottoNumber(3), new LottoNumber(45)
        )));

        final LottoTicket fifthPlaceLottoTicket = new LottoTicket();
        fifthPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            new LottoNumber(27), new LottoNumber(3), new LottoNumber(45)
        )));

        final BonusBall bonusBall = new BonusBall(winningLotto, new LottoNumber(33));

        //when
        final Ranks firstRanks = firstPlaceLottoTicket.toWinningRanks(winningLotto, bonusBall);
        final Ranks secondRanks =
            secondPlaceLottoTicket.toWinningRanks(winningLotto, new BonusBall(winningLotto, new LottoNumber(45)));
        final Ranks thirdRanks = thirdPlaceLottoTicket.toWinningRanks(winningLotto, bonusBall);
        final Ranks forthRanks = forthPlaceLottoTicket.toWinningRanks(winningLotto, bonusBall);
        final Ranks fifthRanks = fifthPlaceLottoTicket.toWinningRanks(winningLotto, bonusBall);

        //then
        assertAll(
            () -> assertThat(firstRanks.getResults()).contains(Rank.FIRST_PLACE.message(1)),
            () -> assertThat(secondRanks.getResults()).contains(Rank.SECOND_PLACE.message(1)),
            () -> assertThat(thirdRanks.getResults()).contains(Rank.THIRD_PLACE.message(1)),
            () -> assertThat(forthRanks.getResults()).contains(Rank.FORTH_PLACE.message(1)),
            () -> assertThat(fifthRanks.getResults()).contains(Rank.FIFTH_PLACE.message(1))
        );
    }

    @Test
    void _3등일떄_보너스를_맞추면_2등으로_프로모션된다() {
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

        final LottoTicket thirdPlaceLottoTicket = new LottoTicket();
        thirdPlaceLottoTicket.publish(money, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, sameLottoNumberFive, new LottoNumber(45)
        )));

        final Ranks secondRanks =
            thirdPlaceLottoTicket.toWinningRanks(winningLotto, new BonusBall(winningLotto, new LottoNumber(45)));

        assertThat(secondRanks.getResults()).contains(Rank.SECOND_PLACE.message(1));
    }
}