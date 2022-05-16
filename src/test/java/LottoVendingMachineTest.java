import lotto.LottoVendingMachine;
import lotto.Match;
import lotto.MatchPrizes;
import lotto.Money;
import lotto.WinningNumbers;
import lotto.domain.LottoTicket;
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
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

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

        LottoTicket ticket = new LottoTicket(
                Arrays.asList(
                        Arrays.asList(1, 10, 11, 12, 13, 14),
                        Arrays.asList(1, 10, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 11, 12, 13, 14),
                        Arrays.asList(1, 2, 3, 12, 13, 14)));

        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

        LottoVendingMachine machine = new LottoVendingMachine();
        LottoResult result = machine.check(ticket, new LottoWin(winningNumbers, new MatchPrizes(matchingPrizes)));

        assertThat(result).isEqualTo(
                new LottoResult(
                        "0.36",
                        Arrays.asList(
                                new LottoResultItem(new Match(3), 5000, 1),
                                new LottoResultItem(new Match(4), 50000, 0),
                                new LottoResultItem(new Match(5), 1500000, 0),
                                new LottoResultItem(new Match(6), 2000000000, 0))));
    }
}
