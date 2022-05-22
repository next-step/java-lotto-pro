package step3.lotto.view.reader;

import static step3.lotto.domain.lotto.Lotto.LOTTO_NUMBER_COUNT;
import static step3.lotto.utils.LottoNumberUtils.intArrayToList;
import static step3.lotto.view.InputView.printInputBonusNumberGuideMessage;
import static step3.lotto.view.InputView.printInputLastWinningLottoGuideMessage;
import static step3.lotto.view.InputView.printInputManualAttemptsCountGuideMessage;
import static step3.lotto.view.InputView.printInputManualAttemptsLottosGuideMessage;
import static step3.lotto.view.InputView.printInputPriceGuideMessage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import step3.lotto.domain.customer.Customer;
import step3.lotto.domain.customer.wrap.ManualAttemptsCount;
import step3.lotto.domain.customer.wrap.Price;
import step3.lotto.domain.lotto.Lotto;
import step3.lotto.domain.lotto.LottoNumber;
import step3.lotto.domain.lotto.Lottos;
import step3.lotto.domain.lotto.Winnings;
import step3.lotto.view.InputView;

/**
 * @author : choi-ys
 * @date : 2022/05/17 3:34 오후
 */
public class InputReader {

    public static final String WINNING_LOTTO_NUMBERS_DELIMITER = ", ";
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Customer InputCustomer() {
        Price price = inputPrice();
        ManualAttemptsCount manualAttemptsCount = inputManualAttemptsCount(price);
        Lottos manualLottos = inputManualLottos(manualAttemptsCount);
        Customer customer = Customer.of(price, manualAttemptsCount, manualLottos);

        InputView.printPurchaseCompletionAndPublishedLottosGuidMessage(customer);
        return customer;
    }

    public static Winnings inputWinnings() {
        printInputLastWinningLottoGuideMessage();

        Lotto winningsLotto = inputSingleLotto();
        LottoNumber bonusNumber = inputBonusNumber();
        return Winnings.of(winningsLotto, bonusNumber);
    }

    private static Price inputPrice() {
        Price price = null;
        while (price == null) {
            printInputPriceGuideMessage();
            price = inputValidPrice(price);
        }
        return price;
    }

    private static Price inputValidPrice(Price price) {
        try {
            price = Price.of(Integer.parseInt(br.readLine()));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return price;
    }

    private static ManualAttemptsCount inputManualAttemptsCount(Price price) {
        ManualAttemptsCount manualAttemptsCount = null;
        while (manualAttemptsCount == null) {
            printInputManualAttemptsCountGuideMessage();
            manualAttemptsCount = inputValidManualAttemptsCount(price, manualAttemptsCount);
        }
        return manualAttemptsCount;
    }

    private static ManualAttemptsCount inputValidManualAttemptsCount(Price price, ManualAttemptsCount manualAttemptsCount) {
        try {
            manualAttemptsCount = ManualAttemptsCount.of(Integer.parseInt(br.readLine()), price);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return manualAttemptsCount;
    }

    private static LottoNumber inputBonusNumber() {
        printInputBonusNumberGuideMessage();
        LottoNumber lottoNumber = null;
        while (lottoNumber == null) {
            lottoNumber = getLottoNumber(lottoNumber);
        }
        return lottoNumber;
    }

    private static LottoNumber getLottoNumber(LottoNumber lottoNumber) {
        try {
            lottoNumber = LottoNumber.of(Integer.parseInt(br.readLine()));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return lottoNumber;
    }

    private static Lotto inputSingleLotto() {
        Lotto lotto = null;
        while (lotto == null) {
            lotto = inputValidSingleLotto(lotto);
        }
        return lotto;
    }

    private static Lotto inputValidSingleLotto(Lotto lotto) {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[LOTTO_NUMBER_COUNT];
            for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
                arr[i] = Integer.parseInt(st.nextToken(WINNING_LOTTO_NUMBERS_DELIMITER));
            }
            lotto = Lotto.of(intArrayToList(arr));
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return lotto;
    }

    private static Lottos inputManualLottos(ManualAttemptsCount manualAttemptsCount) {
        printInputManualAttemptsLottosGuideMessage();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualAttemptsCount.getManualAttemptsCount(); i++) {
            lottos.add(inputSingleLotto());
        }
        return new Lottos(lottos);
    }
}
