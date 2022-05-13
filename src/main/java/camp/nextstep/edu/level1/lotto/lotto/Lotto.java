package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.CollectionHelper;
import camp.nextstep.edu.until.TypeCheckHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final static long LOTTO_PRICE = 1000;
    private final static int WINNING_NUMBER_COUNT = 6;
    private final static String WINNING_NUMBER_DELIMITER = ",";

    private Money purchaseOriginalMoney;
    private List<LottoNumbers> items = new ArrayList<>();

    public Lotto(int value) {
        checkValidLottoPurchaseMoney(value);

        this.purchaseLotto(value);
    }

    public Lotto(String value) {
        checkValueIsInteger(value);
        Integer convertedValue = Integer.parseInt(value);
        checkValidLottoPurchaseMoney(convertedValue);

        this.purchaseLotto(convertedValue);
    }

    public LottoResult compareWinningNumber(String winningNumbers) {
        String[] splitResult = Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
        checkValidWinningNumber(splitResult);

        LottoNumbers winnerLottoNumbers = new LottoNumbers(
                CollectionHelper.arrayStringToIntegerList(splitResult)
        );

        return new LottoResult(this.items, winnerLottoNumbers);
    }

    public double calculateReturnValue(Money earnedMoney) {
        double earnRateResult = earnedMoney.calculateRateByOtherMoney(this.purchaseOriginalMoney);

        return Math.floor(earnRateResult * 100) / 100;
    }

    public void printPurchaseLottoNumbers() {
        for (LottoNumbers item : this.items) {
            System.out.println(item.toString());
        }
    }

    private void checkValidLottoPurchaseMoney(int value) {
        if (value < LOTTO_PRICE) {
            String message = String.format("로또 구입시 최소 %d 원 이상이 있어야 합니다.", LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }
    }

    private void checkValidWinningNumber(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 이어야 합니다.");
        }
    }

    private void checkValueIsInteger(String value) {
        if (!TypeCheckHelper.isPossibleStringToInteger(value)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자만 가능합니다.");
        }
    }

    private void purchaseLotto(Integer value) {
        this.purchaseOriginalMoney = new Money(value);
        long availablePurchaseCount = purchaseOriginalMoney.availablePurchaseCount(LOTTO_PRICE);

        for (int i = 0; i < availablePurchaseCount; i++) {
            this.items.add(new LottoNumbers());
        }

        System.out.println(availablePurchaseCount + "개를 구매했습니다.");
    }
}
