package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoCustomer;
import lotto.domain.LottoException;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResultStatsCalculator;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.UniqueLottoNumbersSupplier;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    private static final Money DEFAULT_LOTTO_TICKET_FEE = Money.wons(1_000);

    public static void main(final String[] args) {
        final LottoCustomer customer = new LottoCustomer(parseMoney(InputView.getPurchaseMoney()));
        final LottoStore store = new LottoStore(
            DEFAULT_LOTTO_TICKET_FEE,
            new UniqueLottoNumbersSupplier());

        store.sellAllTo(customer);

        ResultView.printPurchasedCount(customer.getPurchasedCount());
        ResultView.printPurchaseLottoNumbersList(customer.getPurchasedLottoNumbers());
        ResultView.printEmptyLine();

        final LottoResultStatsCalculator resultCalculator = new LottoResultStatsCalculator(
            customer.getPurchasedLottoTickets(),
            mapToLottoNumbers(InputView.getWiningLottoNumbers()),
            mapToLottoNumber(InputView.getBonusLottoNumber())
        );

        ResultView.printEmptyLine();
        ResultView.printLottoResultStatsTitle();
        ResultView.printDivider();
        ResultView.printLottoResultStatsBody(resultCalculator.computeLottoResultStats());
        ResultView.printProfitRate(resultCalculator.computeProfitRate());
    }

    private static LottoNumber mapToLottoNumber(final String lottoNumber) {
        return LottoNumber.valueOf(parseInt(lottoNumber));
    }

    private static LottoNumbers mapToLottoNumbers(final String[] lottoNumbers) {
        return new LottoNumbers(mapToLottoNumberList(lottoNumbers));
    }

    private static List<LottoNumber> mapToLottoNumberList(final String[] winingLottoNumbers) {
        return Arrays.stream(winingLottoNumbers)
            .map(String::trim)
            .map(Application::mapToLottoNumber)
            .collect(Collectors.toList());
    }

    private static int parseInt(final String lottoNumber) {
        try {
            return Integer.parseInt(lottoNumber);
        } catch (final NumberFormatException numberFormatException) {
            throw new LottoException("Lotto number should be numeric", numberFormatException);
        }
    }

    private static Money parseMoney(final String money) {
        try {
            return Money.wons(Long.parseLong(money));
        } catch (final NumberFormatException numberFormatException) {
            throw new LottoException("Money should be numeric", numberFormatException);
        }
    }

}
