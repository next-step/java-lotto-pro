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
        List<LottoTicket> tickets = LottoMarket.sell(money, new RandomLottoGenerator());
        OutputView.printTickets(tickets);

        showLottoResult(money, tickets);
    }

    private void showLottoResult(Money money, List<LottoTicket> tickets) {
        LottoResult lottoResult = new LottoResult(
                new ManualLottoGenerator(createWinningNumbers()).create()
        );

        lottoResult.chooseBonusNumber(LottoNumber.get(InputView.getBonusNumber()));

        OutputView.printStatistics(lottoResult.statistics(tickets));
        OutputView.printReturnRate(lottoResult.returnRate(money));
    }

    private List<Integer> createWinningNumbers() {
        return Arrays.stream(STANDARD_PATTERN.split(InputView.getWiningNumber()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
