package lotto.money;

import lotto.system.MessageConstant;

public class Money {
    private int amount = 0;

    public Money(int amount){
        valideNegative(amount);
        this.amount = amount;
    }

    public Money(String stringAmount){
        try {
            amount = Integer.parseInt(stringAmount);
            valideNegative(amount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MessageConstant.ERROR_VALID_NOT_NUMBER);
        }
    }

    private static void valideNegative(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException(MessageConstant.ERROR_VALID_NOT_NEGATIVE_NUMBER);
        }
    }

    public int amount(){
        return amount;
    }

}
