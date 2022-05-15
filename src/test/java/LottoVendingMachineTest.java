import lotto.LottoNumber;
import lotto.LottoTicket;
import lotto.LottoVendingMachine;
import lotto.dto.LottoResult;
import lotto.dto.LottoResultItem;
import lotto.dto.LottoWin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoVendingMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "0:0", "2900:2"}, delimiter = ':')
    void 구매(int money, int numberOfGames) {
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();

        LottoTicket lottoTicket = lottoVendingMachine.sellTicket(money);

        assertThat(lottoTicket.size()).isEqualTo(numberOfGames);
    }

    @Test
    void 당첨_확인_결과() {
        Map<Integer, Integer> prizeMoneyByMatch = new HashMap<>();
        prizeMoneyByMatch.put(3, 5000);
        prizeMoneyByMatch.put(4, 50000);
        prizeMoneyByMatch.put(5, 1500000);
        prizeMoneyByMatch.put(6, 2000000000);

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

        List<LottoNumber> winningNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        LottoVendingMachine machine = new LottoVendingMachine();
        LottoResult result = machine.check(ticket, new LottoWin(winningNumbers, prizeMoneyByMatch));

        assertThat(result).isEqualTo(
                new LottoResult(
                        "0.36",
                        Arrays.asList(
                                new LottoResultItem(3, 5000, 1),
                                new LottoResultItem(4, 50000, 0),
                                new LottoResultItem(5, 1500000, 0),
                                new LottoResultItem(6, 2000000000, 0))));
    }
}
