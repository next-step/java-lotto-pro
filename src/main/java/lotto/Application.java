package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoCustomer;
import lotto.domain.LottoException;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStore;
import lotto.domain.Money;
import lotto.domain.UniqueLottoNumbersSupplier;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    private static final Money DEFAULT_LOTTO_TICKET_FEE = Money.wons(1_000);

    public static void main(final String[] args) {
        final Money givenMoney = parseMoney(InputView.getPurchaseMoney());
        final LottoCustomer customer = new LottoCustomer(givenMoney);
        final LottoStore store = new LottoStore(
            DEFAULT_LOTTO_TICKET_FEE,
            new UniqueLottoNumbersSupplier()
        );

        store.sellAllTo(customer);

        ResultView.printPurchasedCount(customer.getPurchasedCount());
        ResultView.printPurchaseLottoNumbersList(customer.getPurchasedLottoNumbers());
        ResultView.printEmptyLine();

        final LottoNumbers winningLottoNumbers = new LottoNumbers(
            mapToLottoNumberList(mapToNumberList(InputView.getWiningLottoNumbers())));

        customer.setWiningLottoNumbers(winningLottoNumbers);

        ResultView.printEmptyLine();
        ResultView.printLottoResultStatsTitle();
        ResultView.printDivider();
        ResultView.printLottoResultStatsBody(customer.getResultStats());
        ResultView.printProfitRate(customer.getProfitRate());
    }

    private static List<Integer> mapToNumberList(final String[] winingLottoNumbers) {
        return Arrays.stream(winingLottoNumbers)
            .map(String::trim)
            .map(Application::parseInt)
            .collect(Collectors.toList());
    }

    private static List<LottoNumber> mapToLottoNumberList(final List<Integer> winingLottoNumbers) {
        return winingLottoNumbers.stream()
            .map(LottoNumber::valueOf)
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
