package lotto;

import lotto.LottoNumbersGeneratorKr;
import lotto.LottoVendingMachine;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Match;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResult;
import lotto.dto.LottoResultItem;
import lotto.dto.LottoWin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoVendingMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "2900:2"}, delimiter = ':')
    void 구매(String money, int numberOfGames) {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine(new LottoNumbersGeneratorKr());

        LottoTicket lottoTicket = lottoVendingMachine.sellTicket(new Money(money));

        assertThat(lottoTicket.size()).isEqualTo(numberOfGames);
    }

    @Test
    void 당첨_확인_결과() {
        Map<Match, Integer> matchingPrizes = new HashMap<>();
        matchingPrizes.put(new Match(3), 5000);
        matchingPrizes.put(new Match(4), 50000);
        matchingPrizes.put(new Match(5), 1500000);
        matchingPrizes.put(new Match(6), 2000000000);

        LottoTicket ticket = new LottoTicket();
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 3, 5, 6, 7)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 10, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 11, 12, 13, 14)));
        ticket.addGame(new LottoGame(Arrays.asList(1, 2, 3, 12, 13, 14)));

        LottoVendingMachine machine = new LottoVendingMachine(new LottoNumbersGeneratorKr());
        LottoResult result = machine.check(ticket, new LottoWin(new WinningNumbers("1,2,3,4,5,6"), new LottoNumber(7)));

        assertThat(result).isEqualTo(
                new LottoResult(
                        String.format("%.2f", (double) (Rank.FIFTH.getPrize() + Rank.SECOND.getPrize()) / ticket.moneyValue()),
                        Arrays.asList(
                                new LottoResultItem(Rank.MISS, 12),
                                new LottoResultItem(Rank.FIFTH, 1),
                                new LottoResultItem(Rank.FOURTH, 0),
                                new LottoResultItem(Rank.THIRD, 0),
                                new LottoResultItem(Rank.SECOND, 1),
                                new LottoResultItem(Rank.FIRST, 0))));
    }
}
