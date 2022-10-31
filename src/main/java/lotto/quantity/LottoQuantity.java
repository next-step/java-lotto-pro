package lotto.quantity;

import lotto.system.MessageConstant;

public class LottoQuantity {
    private int autoLottoQuantity = 0;

    public LottoQuantity(String lottoQuantity) {
        try {
            this.autoLottoQuantity = Integer.parseInt(lottoQuantity);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MessageConstant.ERROR_VALID_NOT_NUMBER);
        }
        validationNegative(this.autoLottoQuantity);
    }

    private static void validationNegative(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_NOT_NEGATIVE_NUMBER);
        }
    }

    public int quantity(){
        return this.autoLottoQuantity;
    }

}
