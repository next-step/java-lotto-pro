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
        validateNegative(this.autoLottoQuantity);
    }

    public LottoQuantity(int totalQuantity, String manualQuantity) {
        try {
            this.autoLottoQuantity = Integer.parseInt(manualQuantity);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MessageConstant.ERROR_VALID_NOT_NUMBER);
        }
        validateNegative(this.autoLottoQuantity);
        validateRange(totalQuantity);
    }

    private void validateRange(int totalQuantity) {
        if(autoLottoQuantity > totalQuantity){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_OUT_OF_RANGE_NUMBER);
        }
    }

    private static void validateNegative(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_NOT_NEGATIVE_NUMBER);
        }
    }

    public int quantity(){
        return this.autoLottoQuantity;
    }

}
