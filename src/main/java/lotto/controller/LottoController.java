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

import java.util.Arrays;
import java.util.List;

public class LottoController {

    public static final String NUMBER_DELIMITER = ",";
    private static final String WINNING_LOTTO_ERROR = String.format("당첨 번호는 %d개여야 합니다.", Lotto.LOTTO_NUMBER_COUNT);

    public void run(LottoMachine lottoMachine) {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoList = lottoMachine.sell(purchaseAmount);
        printLottoList(lottoList);

        WinningLotto winningLotto = initWeekWinningLotto();
        printLottoResult(winningLotto, lottoList);
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);
        int amount = Integer.parseInt(Console.readLine());
        return new PurchaseAmount(amount);
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
            throw new LottoException(WINNING_LOTTO_ERROR);
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
