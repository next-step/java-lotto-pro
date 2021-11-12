package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoPurchaseMachine {

    private static final String THE_PURCHASE_AMOUNT_IS_INSUFFICIENT = "The purchase amount is insufficient.";
    private final List<Lotto> manualLottoNumbers;

    public ManualLottoPurchaseMachine(List<Lotto> manualLottoNumbers) {
        this.manualLottoNumbers = manualLottoNumbers;
    }

    public static ManualLottoPurchaseMachine from(final int purchaseCount, final int manualLottoCount, final List<List<Integer>> inputManualLottos) {
        validate(purchaseCount, manualLottoCount);
        List<Lotto> manualLottos = new ArrayList<>();
        for( int i = 0; i < manualLottoCount; i++ ) {
            manualLottos.add(Lotto.from(inputManualLottos.get(i)));
        }
        return new ManualLottoPurchaseMachine(manualLottos);
    }

    private static void validate(final int purchaseCount, final int manualLottoCount) {
        if( purchaseCount < manualLottoCount ) {
            throw new IllegalArgumentException(THE_PURCHASE_AMOUNT_IS_INSUFFICIENT);
        }
    }

    public List<Lotto> getManualLottoNumbers() {
        return this.manualLottoNumbers;
    }

    public int getManualLottoPurchaseSize() {
        return this.manualLottoNumbers.size();
    }
}
