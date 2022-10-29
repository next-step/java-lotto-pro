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
        checkEmpty(price);
        int integerPrice = stringToNumber(price);
        checkPriceMinLimit(integerPrice);

        return integerPrice;
    }

    private void checkEmpty(String price) {
        if (price == null || price.isEmpty()) {
            throw new IllegalArgumentException(NOT_VALID_NULL);
        }
    }

    private int stringToNumber(String price) {
        int afterPrice;
        try {
            afterPrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_IS_NUMBERIC);
        }
        return afterPrice;
    }

    private void checkPriceMinLimit(int price) {
        if (price < EACH_LOTTO_PRICE) {
            throw new IllegalArgumentException(UNDER_MIN_PRICE);
        }
    }

}
