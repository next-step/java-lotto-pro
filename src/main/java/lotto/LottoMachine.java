package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoCount;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinnerTicket;
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

        LottoTicket winnerLottoTicket = getWinnerLottoTicket();
        WinnerTicket winnerTicket = getWinnerTicket(winnerLottoTicket);

        ResultView.printWinningStatistics(winnerTicket.calculateResult(lottoTickets).makeStatistics());
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

    private LottoTicket getWinnerLottoTicket() {
        ResultView.printAskWinnerTicket();
        try {
            List<Integer> numbers = Arrays.stream(removeAllSpaces(InputView.readLine()).split(COMMA))
                .map(this::parseInt)
                .collect(Collectors.toList());

            return new LottoTicket(numbers);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerLottoTicket();
        }
    }

    private WinnerTicket getWinnerTicket(LottoTicket ticket) {
        ResultView.printAskBonusNumber();

        try {
            LottoNumber lottoNumber = new LottoNumber(parseInt(removeAllSpaces(InputView.readLine())));
            return new WinnerTicket(ticket, lottoNumber);
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerTicket(ticket);
        }

    }

    private String removeAllSpaces(String numbers) {
        return numbers.replaceAll(ALL_SPACES_PATTERN, EMPTY);
    }

    private int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoException(LottoErrorCode.INVALID_NUMBER);
        }
    }
}
