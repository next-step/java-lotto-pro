package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.until.CollectionHelper;
import camp.nextstep.edu.until.TypeCheckHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_RANGE = 6;
    private static final long LOTTO_PRICE = 1000;
    private static final int WINNING_NUMBER_COUNT = 6;
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final List<LottoNumber> LOTTO_NUMBER_PRESET = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            LOTTO_NUMBER_PRESET.add(new LottoNumber(number));
        }
    }

    private Money purchaseOriginalMoney;
    private final List<LottoNumbers> items = new ArrayList<>();

    public Lotto(int purchaseMoney) {
        checkValidLottoPurchaseMoney(purchaseMoney);

        this.purchaseLotto(purchaseMoney);
    }

    public Lotto(String purchaseStringMoney) {
        checkValueIsInteger(purchaseStringMoney);
        int convertedValue = Integer.parseInt(purchaseStringMoney);
        checkValidLottoPurchaseMoney(convertedValue);

        this.purchaseLotto(convertedValue);
    }

    public LottoResult compareWinningNumber(String winningNumbers, String bonusNumber) {
        String[] splitResult = Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .toArray(String[]::new);
        checkValidWinningNumber(splitResult);

        LottoNumbers winnerLottoNumbers = new LottoNumbers(
                CollectionHelper.arrayStringToIntegerList(splitResult)
        );
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        checkWinningNumberAndBonusNumberDuplicated(winnerLottoNumbers, bonusLottoNumber);

        return new LottoResult(this.items, winnerLottoNumbers, bonusLottoNumber);
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

    private void checkValidLottoPurchaseMoney(int money) {
        if (money < LOTTO_PRICE) {
            String message = String.format("로또 구입시 최소 %d 원 이상이 있어야 합니다.", LOTTO_PRICE);
            throw new IllegalArgumentException(message);
        }
    }

    private void checkValidWinningNumber(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("당첨 번호는 6개 이어야 합니다.");
        }
    }

    private void checkValueIsInteger(String money) {
        if (!TypeCheckHelper.isPossibleStringToInteger(money)) {
            throw new IllegalArgumentException("로또 구입 금액은 숫자만 가능합니다.");
        }
    }

    private void checkWinningNumberAndBonusNumberDuplicated(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.isContainLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함되지 않은 숫자만 허용됩니다.");
        }
    }

    private void purchaseLotto(int purchaseMoney) {
        this.purchaseOriginalMoney = new Money(purchaseMoney);
        long availablePurchaseCount = purchaseOriginalMoney.availablePurchaseCount(LOTTO_PRICE);

        for (int i = 0; i < availablePurchaseCount; i++) {
            this.items.add(createRandomLottoNumbers());
        }

        System.out.println(availablePurchaseCount + "개를 구매했습니다.");
    }

    private static LottoNumbers createRandomLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_PRESET);

        return new LottoNumbers(LOTTO_NUMBER_PRESET.subList(0, LOTTO_RANGE));
    }
}
