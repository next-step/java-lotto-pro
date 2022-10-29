package step3.model;

import static step3.constant.Message.ERROR_IS_NUMBERIC;
import static step3.constant.Message.NOT_VALID_NULL;

public class LottoGenerator {
    private int purchasePrice;
    private Lottos lottos = new Lottos();

    public void setPurchasePrice(String price) {
        checkEmpty(price);

        try {
            this.purchasePrice = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_IS_NUMBERIC);
        }
    }


    public Lottos generateLottos() {
        if(validatePrice()) {
            lottos.setPurchasedCount(purchasePrice);
        }

        lottos.setLottos();
        return lottos;
    }
    private boolean validatePrice() {
        boolean valid = false;
        return valid;
    }
    private void checkEmpty(String price) {
        if(price == null || price.isEmpty()) {
            throw new IllegalArgumentException(NOT_VALID_NULL);
        }
    }

}
