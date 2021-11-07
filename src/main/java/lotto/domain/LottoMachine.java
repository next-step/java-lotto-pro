package lotto.domain;

import lotto.common.Messages;
import lotto.exception.LottoException;
import lotto.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoMachine {

    protected static final String NUMBER_DELIMITER = ",";
    private static final String WINNING_LOTTO_ERROR = String.format("당첨 번호는 %d개여야 합니다.", Lotto.LOTTO_NUMBER_COUNT);

    public void start() {
        PurchaseAmount purchaseAmount = getPurchaseAmount();
        List<Lotto> lottoList = sell(purchaseAmount);
        Lotto lastWeekWinningLotto = getLastWeekWinningLotto();
        LottoResult lottoResult = new LottoResult(lastWeekWinningLotto, lottoList);
        System.out.println(lottoResult);
    }

    private PurchaseAmount getPurchaseAmount() {
        System.out.println(Messages.PURCHASE_AMOUNT_INPUT);
        int amount = Integer.parseInt(Console.readLine());
        return new PurchaseAmount(amount);
    }

    private List<Lotto> sell(PurchaseAmount purchaseAmount) {
        int purchasedLottoCount = getPurchasedLottoCount(purchaseAmount);
        return getLottoList(purchasedLottoCount);
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
        List<Integer> values = LottoNumber.getValues().subList(0, Lotto.LOTTO_NUMBER_COUNT);
        int[] numbers = values.stream()
                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
                .toArray();
        Lotto lotto = new Lotto(numbers);
        System.out.println(lotto);
        return lotto;
    }
}
