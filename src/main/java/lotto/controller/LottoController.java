package lotto.controller;

import lotto.domain.*;
import lotto.domain.ManualLottoGenerator;
import lotto.domain.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoController {
    private static final Pattern STANDARD_PATTERN = Pattern.compile(",");

    public void run() {
        Money money = new Money(InputView.getMoney());
        Quantity quantity = new Quantity(InputView.getManualLottoCount());
        List<LottoTicket> tickets = LottoMarket.sell(money, new RandomLottoGenerator());
        OutputView.printTickets(tickets);

        showLottoResult(money, tickets);
    }

    private void showLottoResult(Money money, List<LottoTicket> tickets) {
        LottoTicket winningTicket = new ManualLottoGenerator(createWinningNumbers()).create();
        LottoResult lottoResult = new LottoResult(winningTicket);

        OutputView.printStatistics(lottoResult.statistics(tickets, chooseBonusNumber(winningTicket)));
        OutputView.printReturnRate(lottoResult.returnRate(money));
    }

    private List<Integer> createWinningNumbers() {
        return Arrays.stream(STANDARD_PATTERN.split(InputView.getWiningNumber()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private LottoNumber chooseBonusNumber(LottoTicket winningTicket) {
        LottoNumber number = LottoNumber.get(InputView.getBonusNumber());
        if (winningTicket.contain(number)) {
            OutputView.printDuplicateNumber();
            return chooseBonusNumber(winningTicket);
        }

        return number;
    }
}
