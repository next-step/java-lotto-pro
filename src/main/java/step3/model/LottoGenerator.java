package step3.model;

import static step3.constant.Constant.EACH_LOTTO_PRICE;
import static step3.constant.Message.*;

public class LottoGenerator {
    private int purchasePrice;
    private Lottos lottos = new Lottos();

    public void setPurchasePrice(String price) {
        this.purchasePrice = validatePrice(price);
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Lottos generateLottos() {
        lottos.setPurchasedCount(purchasePrice);
        lottos.addLottos();
        return lottos;
    }

    private int validatePrice(String price) {
        commonCheckEmpty(price);
        int integerPrice = commonStringToNumber(price);
        checkPriceMinLimit(integerPrice);

        return integerPrice;
    }

    public static void commonCheckEmpty(String target) {
        if (target == null || target.isEmpty()) {
            throw new IllegalArgumentException(NOT_VALID_NULL);
        }
    }

    public static int commonStringToNumber(String target) {
        int afterNumber;
        try {
            afterNumber = Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_IS_NUMBERIC);
        }
        return afterNumber;
    }

    private void checkPriceMinLimit(int price) {
        if (price < EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_MIN_PRICE);
        }
    }

    public int getPurchasedCount() {
        return lottos.getPurchasedCount();
    }

}
