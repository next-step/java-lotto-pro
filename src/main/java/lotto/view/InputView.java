package lotto.view;

import java.util.ArrayList;
import java.util.List;

import lotto.model.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;
import lotto.model.Number;
import lotto.model.Payment;
import lotto.util.Console;
import lotto.util.InputParser;

public class InputView {
    private static final String QUERY_FOR_PAYMENT = "구입금액을 입력해주세요.";
    private static final String QUERY_FOR_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUERY_FOR_MANUAL_LOTTOS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUERY_FOR_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUERY_FOR_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static Payment readPayment() {
        System.out.println(QUERY_FOR_PAYMENT);
        String payment = Console.readLine();
        return InputParser.toPayment(payment);
    }

    public static LottoCount readLottoCount(Payment payment) {
        System.out.println(QUERY_FOR_MANUAL_LOTTO_COUNT);
        int manualLottoCount = InputParser.toInteger(Console.readLine());
        return payment.computeLottoCount(manualLottoCount);
    }

    public static Lottos readManualLottos(int manualCount) {
        if (manualCount == 0) {
            return Lottos.empty();
        }
        System.out.println(QUERY_FOR_MANUAL_LOTTOS);
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            String lottoNumbers = Console.readLine();
            Lotto lotto = InputParser.toLotto(lottoNumbers);
            manualLottos.add(lotto);
        }
        return new Lottos(manualLottos);
    }

    public static Lotto readWinningLotto() {
        System.out.println(QUERY_FOR_WINNING_NUMBERS);
        String winningNumbers = Console.readLine();
        return InputParser.toLotto(winningNumbers);
    }

    public static Number readBonusNumber() {
        System.out.println(QUERY_FOR_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        return InputParser.toNumber(bonusNumber);
    }
}
