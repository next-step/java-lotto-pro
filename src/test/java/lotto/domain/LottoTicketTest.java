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
        final LottoTicket lottoTicket =
            new LottoTicket(money, Lotteries.EMPTY, new SimpleLottoShuffler());
        lottoTicket.publish();

        //then
        assertAll(
            () -> assertThat(lottoTicket).isNotNull(),
            () -> assertThat(lottoTicket.sizeOfTotalLotteries()).isEqualTo(money.exchangeLottoPurchasableCount())
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

        final LottoTicket firstPlaceLottoTicket = new LottoTicket(money, Lotteries.EMPTY, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, sameLottoNumberFive, sameLottoNumberSix
        )));
        firstPlaceLottoTicket.publish();

        final LottoTicket secondPlaceLottoTicket =
            new LottoTicket(money, Lotteries.EMPTY, () -> new Lotto(Arrays.asList(
                sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
                sameLottoNumberFour, sameLottoNumberFive, new LottoNumber(45)
            )));
        secondPlaceLottoTicket.publish();

        final LottoTicket thirdPlaceLottoTicket = new LottoTicket(money, Lotteries.EMPTY, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, sameLottoNumberFive, new LottoNumber(45)
        )));
        thirdPlaceLottoTicket.publish();

        final LottoTicket forthPlaceLottoTicket = new LottoTicket(money, Lotteries.EMPTY, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            sameLottoNumberFour, new LottoNumber(3), new LottoNumber(45)
        )));
        forthPlaceLottoTicket.publish();

        final LottoTicket fifthPlaceLottoTicket = new LottoTicket(money, Lotteries.EMPTY, () -> new Lotto(Arrays.asList(
            sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
            new LottoNumber(27), new LottoNumber(3), new LottoNumber(45)
        )));
        fifthPlaceLottoTicket.publish();

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
    void _3등일때_보너스를_맞추면_2등으로_프로모션된다() {
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

        final LottoTicket thirdPlaceLottoTicket =
            new LottoTicket(money, Lotteries.EMPTY, () -> new Lotto(Arrays.asList(
                sameLottoNumberOne, sameLottoNumberThree, sameLottoNumberTwo,
                sameLottoNumberFour, sameLottoNumberFive, new LottoNumber(45)
            )));
        thirdPlaceLottoTicket.publish();

        final Ranks secondRanks =
            thirdPlaceLottoTicket.toWinningRanks(winningLotto, new BonusBall(winningLotto, new LottoNumber(45)));

        assertThat(secondRanks.getResults()).contains(Rank.SECOND_PLACE.message(1));
    }

    @Test
    void 수동으로_넣고싶은_로또번호를_넣어_수동과_자동으로_로또티켓을_만들수있다() {
        //given
        final Money money = new Money(30000);

        final Lotteries manualLotteries = new Lotteries(Arrays.asList(
            new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
            ))
        ));

        //when
        final LottoTicket lottoTicket = new LottoTicket(
            money,
            manualLotteries,
            new SimpleLottoShuffler()
        );

        lottoTicket.publish();

        //then
        assertAll(
            () -> assertThat(lottoTicket).isNotNull(),
            () -> assertThat(lottoTicket.sizeOfTotalLotteries()).isEqualTo(money.exchangeLottoPurchasableCount())
        );
    }
}