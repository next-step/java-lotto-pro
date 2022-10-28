package lotto.controller;

import lotto.domain.LottoCommittee;
import lotto.domain.LottoMarket;
import lotto.domain.LottoTicket;
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
        List<LottoTicket> tickets = LottoMarket.sell(InputView.getMoney(), new RandomLottoGenerator());
        ResultView.printTickets(tickets);

        LottoCommittee committee = new LottoCommittee(createWinningNumbers());
        ResultView.printStatistics(committee.statistics(tickets));
    }

    private List<Integer> createWinningNumbers() {
        String input = InputView.getWiningNumber()
                .replaceAll(WHITE_SPACE_REGEX_STRING, EMPTY);

        return Arrays.asList(STANDARD_PATTERN.split(input)).stream()
                .map(v -> Integer.parseInt(v))
                .collect(Collectors.toList());
    }
}
