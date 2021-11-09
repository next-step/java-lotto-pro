package lotto.controller;

import lotto.common.Messages;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.exception.LottoException;
import lotto.utils.Console;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;

public class LottoController {

    public static final String NUMBER_DELIMITER = ",";
    private static final String WINNING_LOTTO_ERROR = String.format("당첨 번호는 %d개여야 합니다.", Lotto.LOTTO_NUMBER_COUNT);

    public void run(LottoMachine lottoMachine) {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoList = lottoMachine.sell(purchaseAmount);

        System.out.println(Messages.getPurchasedLottoCount(lottoList.size()));
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }

        Lotto lastWeekWinningLotto = getLastWeekWinningLotto();
        LottoResult lottoResult = new LottoResult(lastWeekWinningLotto, lottoList);
        System.out.println(ResultView.print(lottoResult));
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);
        int amount = Integer.parseInt(Console.readLine());
        return new PurchaseAmount(amount);
    }

    private Lotto getLastWeekWinningLotto() {
        System.out.println(System.lineSeparator() + Messages.LAST_WEEK_WINNING_NUMBER_INPUT);
        String[] stringNumbers = Console.readLine().split(NUMBER_DELIMITER);
        if (stringNumbers.length != Lotto.LOTTO_NUMBER_COUNT) {
            throw new LottoException(WINNING_LOTTO_ERROR);
        }

        int[] numbers = Arrays.stream(stringNumbers)
                .mapToInt(stringNumber -> Integer.parseInt(stringNumber.trim()))
                .toArray();
        return new Lotto(numbers);
    }
}
