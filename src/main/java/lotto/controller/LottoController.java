package lotto.controller;

import lotto.common.Messages;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.exception.LottoException;
import lotto.utils.Console;
import lotto.utils.StringUtils;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {

    public static final String NUMBER_DELIMITER = ",";

    private final List<Lotto> lottoList = new ArrayList<>();

    public void run(LottoMachine lottoMachine) {
        lottoList.clear();

        PurchaseAmount purchaseAmount = getPurchaseAmount();
        int manualLottoCount = getManualLottoCount(purchaseAmount);
        int autoLottoCount = purchaseAmount.getPurchasableLottoCount() - manualLottoCount;

        lottoList.addAll(lottoMachine.sell(manualLottoCount));
        lottoList.addAll(lottoMachine.sell(autoLottoCount));
        printLottoList(lottoList);

        WinningLotto winningLotto = initWeekWinningLotto();
        printLottoResult(winningLotto, lottoList);
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);

        int amount = Integer.parseInt(Console.readLine());

        System.out.print(System.lineSeparator());
        return new PurchaseAmount(amount);
    }

    private int getManualLottoCount(PurchaseAmount purchaseAmount) {
        System.out.println(Messages.MANUAL_LOTTO_COUNT_INPUT);

        int count = Integer.parseInt(Console.readLine());
        purchaseAmount.validatePurchasableLottoCount(count);

        System.out.print(System.lineSeparator());
        return count;
    }

    private void printLottoList(List<Lotto> lottoList) {
        System.out.println(Messages.getPurchasedLottoCount(lottoList.size()));
        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }

    private WinningLotto initWeekWinningLotto() {
        int[] winningNumbers = getWinningNumbers();
        int winningBonusNumber = getWinningBonusNumber();

        return new WinningLotto(winningBonusNumber, winningNumbers);
    }

    private int[] getWinningNumbers() {
        System.out.println(System.lineSeparator() + Messages.LAST_WEEK_WINNING_NUMBER_INPUT);
        String[] stringNumbers = Console.readLine().split(NUMBER_DELIMITER);

        if (stringNumbers.length != Lotto.LOTTO_NUMBER_COUNT) {
            throw new LottoException(WinningLotto.WINNING_LOTTO_ERROR);
        }
        return Arrays.stream(stringNumbers)
                .mapToInt(stringNumber -> Integer.parseInt(stringNumber.trim()))
                .toArray();
    }

    private int getWinningBonusNumber() {
        System.out.println(Messages.LAST_WEEK_WINNING_BONUS_NUMBER_INPUT);
        String stringNumber = Console.readLine();

        if (StringUtils.isNotNumber(stringNumber)) {
            throw new LottoException(StringUtils.IS_NOT_STRING_NUMBER);
        }
        return StringUtils.toNumber(stringNumber);
    }

    private void printLottoResult(WinningLotto winningLotto, List<Lotto> lottoList) {
        LottoResult lottoResult = new LottoResult(winningLotto, lottoList);
        System.out.println(System.lineSeparator() + ResultView.print(lottoResult));
    }
}
