package lotto.domain;

import lotto.common.Messages;
import lotto.utils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine implements Machine {

    private static final String NUMBER_DELIMITER = ",";

    @Override
    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        sell(purchaseAmount);
        Lotto lastWeekWinningLotto = getLastWeekWinningLotto();
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);
        int amount = Integer.parseInt(Console.readLine());
        return new PurchaseAmount(amount);
    }

    private void sell(PurchaseAmount purchaseAmount) {
        int purchasedLottoCount = getPurchasedLottoCount(purchaseAmount);
        List<Lotto> lottoList = getLottoList(purchasedLottoCount);
    }

    private Lotto getLastWeekWinningLotto() {
        System.out.println(System.lineSeparator() + Messages.LAST_WEEK_WINNING_NUMBER_INPUT);
        String[] stringNumbers = Console.readLine().split(NUMBER_DELIMITER);

        Lotto lotto = new Lotto();
        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber.trim());
            lotto.addLottoNumber(new LottoNumber(number));
        }
        return lotto;
    }

    private int getPurchasedLottoCount(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.buyLotto();
        System.out.println(Messages.getPurchasedLottoCount(count));
        return count;
    }

    private List<Lotto> getLottoList(int purchasedLottoCount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < purchasedLottoCount; i++) {
            Lotto lotto = generateLotto();
            lottoList.add(lotto);
        }
        return lottoList;
    }

    private Lotto generateLotto() {
        Lotto lotto = new Lotto();
        List<Integer> values = LottoNumber.getValues().subList(0, Lotto.LOTTO_NUMBER_COUNT);
        for (Integer value : values) {
            LottoNumber lottoNumber = new LottoNumber(value);
            lotto.addLottoNumber(lottoNumber);
        }
        System.out.println(lotto);
        return lotto;
    }
}
