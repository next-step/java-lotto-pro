package lotto.domain;

import lotto.domain.common.Constant;
import util.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Payment {
    private static final String THE_NUMBER_OF_MANUAL_PURCHASE_LOTTERY_IS_DIFFERENT = "Must be less than the number of lottery tickets purchased.";
    private static final String THE_PRICE_OF_A_LOTTERY_TICKET_IS_1_000_WON = "The price of a lottery ticket is 1,000 won.";
    private static final String ONLY_NUMBERS_CAN_BE_ENTERED = "Only numbers can be entered.";
    private final Long payment;
    private final int manualLottoPurchase;

    private Payment(final Long payment, int manualLottoPurchase) {
        validateAmount(payment);
        this.payment = payment;
        this.manualLottoPurchase = manualLottoPurchase;
    }

    public static Payment from(final Long payment, final int manualLottoPurchase) {
        return new Payment(payment, manualLottoPurchase);
    }

    public static Payment from(final String payment, final String manualLottoPurchase) {
        validateCharacter(payment);
        validateCharacter(manualLottoPurchase);
        return new Payment(Long.valueOf(payment), Integer.parseInt(manualLottoPurchase));
    }

    private static void validateCharacter(String payment) {
        if( !payment.chars().allMatch( Character::isDigit )) {
            throw new IllegalArgumentException(ONLY_NUMBERS_CAN_BE_ENTERED);
        }
    }

    private static void validateAmount(final Long payment) {
        if( payment < Constant.LOTTO_PURCHASE_PRICE) {
            throw new IllegalArgumentException(THE_PRICE_OF_A_LOTTERY_TICKET_IS_1_000_WON);
        }
    }

    public int getPurchaseCount() {
        Long purchaseCount = this.payment / Constant.LOTTO_PURCHASE_PRICE;
        return purchaseCount.intValue();
    }

    public int getAutoPurchaseCount() {
        return getPurchaseCount() - this.manualLottoPurchase;
    }

    public boolean matchManualLottoPurchaseCount(int count) {
        return this.manualLottoPurchase == count;
    }

    public ManualLottoPurchaseMachine from(List<List<Integer>> inputManualLottos) {
        validateGreaterPurchase();
        List<Lotto> manualLottos = new ArrayList<>();
        for( int i = 0; i < this.manualLottoPurchase; i++ ) {
            manualLottos.add(Lotto.from(inputManualLottos.get(i)));
        }
        return new ManualLottoPurchaseMachine(manualLottos);
    }

    public ManualLottoPurchaseMachine from(BufferedReader br) throws IOException {
        List<List<Integer>> splitManualLottos = splitListInteger(br);
        validateGreaterPurchase();
        List<Lotto> manualLottos = new ArrayList<>();
        for( int i = 0; i < this.manualLottoPurchase; i++ ) {
            manualLottos.add(Lotto.from(splitManualLottos.get(i)));
        }
        return new ManualLottoPurchaseMachine(manualLottos);
    }

    public void validateGreaterPurchase() {
        if( this.manualLottoPurchase > this.getPurchaseCount() ) {
            throw new IllegalArgumentException(THE_NUMBER_OF_MANUAL_PURCHASE_LOTTERY_IS_DIFFERENT);
        }
    }

    private List<List<Integer>> splitListInteger(BufferedReader br) throws IOException {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for(int i = 0; i < this.manualLottoPurchase; i++) {
            String sp = br.readLine();
            manualLottoNumbers.add(ServiceUtil.splitNumbers(sp));
        }
        return manualLottoNumbers;
    }

    public int getManualLottoPurchase() {
        return this.manualLottoPurchase;
    }
}
