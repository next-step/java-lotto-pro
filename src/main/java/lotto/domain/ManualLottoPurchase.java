package lotto.domain;

import util.ServiceUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManualLottoPurchase {

    private static final String ONLY_NUMBERS_CAN_BE_ENTERED = "Only numbers can be entered.";
    private static final String THE_NUMBER_OF_MANUAL_PURCHASE_LOTTERY_IS_DIFFERENT = "Must be less than the number of lottery tickets purchased.";
    private final int purchase;

    private ManualLottoPurchase(final int purchase) {
        this.purchase = purchase;
    }

    public static ManualLottoPurchase from(final String inputManualPurchase) {
        validate(inputManualPurchase);
        return new ManualLottoPurchase(Integer.parseInt(inputManualPurchase));
    }

    private static void validate(final String payment) {
        if( !payment.chars().allMatch( Character::isDigit )) {
            throw new IllegalArgumentException(ONLY_NUMBERS_CAN_BE_ENTERED);
        }
    }

    public ManualLottoPurchaseMachine from(Payment payment, List<List<Integer>> inputManualLottos) {
        validateGreaterPurchase(payment);
        List<Lotto> manualLottos = new ArrayList<>();
        for( int i = 0; i < this.purchase; i++ ) {
            manualLottos.add(Lotto.from(inputManualLottos.get(i)));
        }
        return new ManualLottoPurchaseMachine(manualLottos);
    }

    public ManualLottoPurchaseMachine from(Payment payment, BufferedReader br) throws IOException {
        List<List<Integer>> splitManualLottos = splitListInteger(br);
        validateGreaterPurchase(payment);
        List<Lotto> manualLottos = new ArrayList<>();
        for( int i = 0; i < this.purchase; i++ ) {
            manualLottos.add(Lotto.from(splitManualLottos.get(i)));
        }
        return new ManualLottoPurchaseMachine(manualLottos);
    }

    public void validateGreaterPurchase(final Payment payment) {
        if( this.purchase > payment.getPurchaseCount() ) {
            throw new IllegalArgumentException(THE_NUMBER_OF_MANUAL_PURCHASE_LOTTERY_IS_DIFFERENT);
        }
    }

    private List<List<Integer>> splitListInteger(BufferedReader br) throws IOException {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for(int i = 0; i < this.purchase; i++) {
            String sp = br.readLine();
            manualLottoNumbers.add(ServiceUtil.splitNumbers(sp));
        }
        return manualLottoNumbers;
    }

    public int getPurchase() {
        return this.purchase;
    }
}
