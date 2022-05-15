package camp.nextstep.edu.level1.lotto.lotto;

import camp.nextstep.edu.common.PositiveNumber;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int LOTTO_RANGE = 6;
    private static final Money LOTTO_PRICE = new Money(1_000);
    private static final List<LottoNumber> LOTTO_NUMBER_PRESET = new ArrayList<>();

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            LOTTO_NUMBER_PRESET.add(new LottoNumber(number));
        }
    }

    private Money purchaseOriginalMoney;
    private final List<LottoNumbers> items = new ArrayList<>();
    private PositiveNumber manualPurchaseCount;
    private PositiveNumber autoPurchaseCount;

    public Lotto(Money purchaseMoney) {
        checkValidLottoPurchaseMoney(purchaseMoney);

        this.purchaseOriginalMoney = purchaseMoney;
    }

    public void manualLottoPurchase(Collection<LottoNumbers> manualLottoPurchaseNumbers) {
        items.addAll(manualLottoPurchaseNumbers);
        manualPurchaseCount = new PositiveNumber(manualLottoPurchaseNumbers.size());;

        autoPurchaseLottoByRemainMoney();
    }

    public LottoResult compareWinningNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        checkWinningNumberAndBonusNumberDuplicated(winningNumbers, bonusNumber);

        return new LottoResult(this.items, winningNumbers, bonusNumber);
    }

    public double calculateReturnValue(Money earnedMoney) {
        double earnRateResult = earnedMoney.calculateRateByOtherMoney(this.purchaseOriginalMoney);

        return Math.floor(earnRateResult * 100) / 100;
    }

    public void printPurchaseResult() {
        String message = "수동으로 " + manualPurchaseCount + "장, 자동으로 " + autoPurchaseCount + "개를 구매했습니다.";
        System.out.println(message);
    }

    public void printPurchaseLottoNumbers() {
        for (LottoNumbers item : this.items) {
            System.out.println(item.toString());
        }
    }

    public void checkPossibleManualLottoPurchaseCount(PositiveNumber count) {
        long availablePurchaseCount = purchaseOriginalMoney.availablePurchaseCount(LOTTO_PRICE);
        if (availablePurchaseCount < count.getValue()) {
            throw new IllegalArgumentException(
                    "구입 가능한 로또 수 보다 많이 구입할 수 없습니다. 구입 가능한 최대수: " + availablePurchaseCount
            );
        }
    }

    private void checkValidLottoPurchaseMoney(Money money) {
        if (LOTTO_PRICE.isSameOrGreater(money)) {
            throw new IllegalArgumentException("로또 구입시 최소 " + LOTTO_PRICE + " 이상이 있어야 합니다.");
        }
    }

    private void checkWinningNumberAndBonusNumberDuplicated(LottoNumbers winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.isContainLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함되지 않은 숫자만 허용됩니다.");
        }
    }

    private void purchaseLotto(long purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            this.items.add(createRandomLottoNumbers());
        }
    }

    private void autoPurchaseLottoByRemainMoney() {
        Money manualPurchaseMoney = LOTTO_PRICE.multiply(manualPurchaseCount);
        Money remainMoney = purchaseOriginalMoney.subtract(manualPurchaseMoney);
        long availablePurchaseCount = remainMoney.availablePurchaseCount(LOTTO_PRICE);

        purchaseLotto(availablePurchaseCount);
        autoPurchaseCount = new PositiveNumber(availablePurchaseCount);
    }

    private static LottoNumbers createRandomLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_PRESET);

        return new LottoNumbers(LOTTO_NUMBER_PRESET.subList(0, LOTTO_RANGE));
    }
}
