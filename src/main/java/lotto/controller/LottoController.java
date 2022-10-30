package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.StatisticDto;
import lotto.domain.enums.Rank;
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
        LottoCommittee committee = new LottoCommittee(
                new ManualLottoGenerator(createWinningNumbers()).create()
        );
        StatisticDto dto = committee.statistics(tickets);

        OutputView.printStatistics(dto);
        OutputView.printReturnRate(committee.returnRate(Rank.calculatePrice(dto), money));
    }

    private List<Integer> createWinningNumbers() {
        return Arrays.stream(STANDARD_PATTERN.split(InputView.getWiningNumber()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
