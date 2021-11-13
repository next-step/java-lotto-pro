package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoCount;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.exception.LottoErrorCode;
import lotto.exception.LottoException;
import lotto.factory.LottoTicketFactory;
import view.InputView;
import view.ResultView;

public class LottoMachine {
    private static final String COMMA = ",";
    private static final String ALL_SPACES_PATTERN = "\\s";
    private static final String EMPTY = "";

    public void start() {
        LottoMoney lottoMoney = getLottoMoney();

        LottoCount lottoCount = lottoMoney.calculateLottoCount();
        ResultView.printNumberOfPurchasedLotto(lottoCount.getCount());

        LottoTickets lottoTickets = LottoTicketFactory.createRandomLottoTickets(lottoCount);
        ResultView.printLottoTickets(lottoTickets);
        ResultView.printWinningStatistics(lottoTickets.calculateResult(getWinnerTicket()).makeStatistics());
    }

    private LottoMoney getLottoMoney() {
        ResultView.printAskPurchaseAmount();
        try {
            return new LottoMoney(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getLottoMoney();
        }
    }

    private LottoTicket getWinnerTicket() {
        ResultView.printAskWinnerTicket();
        try {
            List<Integer> numbers = Arrays.stream(removeAllSpaces(InputView.readLine()).split(COMMA))
                .map(this::parseInt)
                .collect(Collectors.toList());

            return new LottoTicket(numbers);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerTicket();
        }
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_LOTTO_TICKET);
        }
    }

    private String removeAllSpaces(String numbers) {
        return numbers.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }
}
