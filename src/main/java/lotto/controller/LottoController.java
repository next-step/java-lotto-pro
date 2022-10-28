package lotto.controller;

import lotto.domain.*;
import lotto.domain.dto.StatisticDto;
import lotto.domain.enums.Rank;
import lotto.util.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LottoController {
    private static final Pattern STANDARD_PATTERN = Pattern.compile(",");
    private static final String WHITE_SPACE_REGEX_STRING = "\\s";
    private static final String EMPTY = "";

    public void run() {
        Money money = new Money(InputView.getMoney());
        List<LottoTicket> tickets = LottoMarket.sell(money, new RandomLottoGenerator());
        ResultView.printTickets(tickets);

        showLottoResult(money, tickets);
    }

    private void showLottoResult(Money money, List<LottoTicket> tickets) {
        LottoCommittee committee = new LottoCommittee(createWinningNumbers());
        StatisticDto dto = committee.statistics(tickets);

        ResultView.printStatistics(dto);
        ResultView.printReturnRate(committee.returnRate(Rank.calculatePrice(dto), money));
    }

    private List<Integer> createWinningNumbers() {
        String input = InputView.getWiningNumber()
                .replaceAll(WHITE_SPACE_REGEX_STRING, EMPTY);

        return Arrays.asList(STANDARD_PATTERN.split(input)).stream()
                .map(v -> Integer.parseInt(v))
                .collect(Collectors.toList());
    }
}
