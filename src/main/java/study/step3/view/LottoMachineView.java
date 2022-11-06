package study.step3.view;

import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.message.LottoMachineMessage;
import study.step3.message.LottoMessage;
import study.step3.util.Patterns;

import java.util.ArrayList;
import java.util.List;

public class LottoMachineView {

    private static final long PURCHASE_MINIMUM_MONEY = 1000;

    public static PurchaseMoney getPurchaseMoney() {
        PurchaseMoney purchaseMoney = null;
        while (InputView.isNeedToRetryInputValue(purchaseMoney)) {
            ResultView.output(LottoMachineMessage.INPUT_PURCHASE_MONEY_MESSAGE.message());
            purchaseMoney = inputPurchaseMoney();
        }
        return purchaseMoney;
    }

    private static PurchaseMoney inputPurchaseMoney() {
        try {
            String purchaseMoney = InputView.input();
            validatePurchaseMoney(purchaseMoney);
            return PurchaseMoney.of(Long.parseLong(purchaseMoney));
        } catch (Exception e) {
            ResultView.output(e.getMessage());
            return null;
        }
    }

    private static void validatePurchaseMoney(String purchaseMoney) {
        validatePurchaseMoneyIsNotEmpty(purchaseMoney);
        validatePurchaseMoneyIsNumber(purchaseMoney);
        validatePurchaseMoneyIsGreaterThanMinimumMoney(purchaseMoney);
    }

    private static void validatePurchaseMoneyIsNotEmpty(String purchaseMoney) {
        if(purchaseMoney == null || purchaseMoney.isEmpty()) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_PURCHASE_MONEY_SHOULD_BE_NOT_EMPTY.message());
        }
    }

    private static void validatePurchaseMoneyIsNumber(String purchaseMoney) {
        if(!Patterns.ONLY_NUMBERS.match(purchaseMoney)) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_PURCHASE_MONEY_SHOULD_BE_NUMBER.message());
        }
    }

    private static void validatePurchaseMoneyIsGreaterThanMinimumMoney(String purchaseMoney) {
        if(Long.parseLong(purchaseMoney) < PURCHASE_MINIMUM_MONEY) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_PURCHASE_MONEY_IS_GREATER_THAN_MINIMUM_MONEY.message());
        }
    }

    public static long getManualLottoCount(PurchaseMoney purchaseMoney) {
        Long manualLottoCount = null;
        while (InputView.isNeedToRetryInputValue(manualLottoCount)) {
            ResultView.output(LottoMachineMessage.INPUT_MANUAL_LOTTO_COUNT.message());
            manualLottoCount = inputManualLottoCount(purchaseMoney);
        }
        return manualLottoCount;
    }

    private static Long inputManualLottoCount(PurchaseMoney purchaseMoney) {
        try {
            String manualLottoCount = InputView.input();
            validateManualLottoCount(purchaseMoney, manualLottoCount);
            return Long.parseLong(manualLottoCount);
        } catch (Exception e) {
            ResultView.output(e.getMessage());
            return null;
        }
    }

    private static void validateManualLottoCount(PurchaseMoney purchaseMoney, String manualLottoCount) {
        if(!Patterns.ONLY_NUMBERS.match(manualLottoCount)) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_MANUAL_LOTTO_COUNT_SHOULD_BE_NUMBER.message());
        }

        if(purchaseMoney.isLackOfMoney(Long.parseLong(manualLottoCount))) {
            throw new IllegalArgumentException(LottoMachineMessage.ERROR_MANUAL_LOTTO_LACK_OF_MONEY.message());
        }
    }
}
