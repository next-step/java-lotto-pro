package lotto.money;

import lotto.system.MessageConstant;

public class Money {
    private int amount = 0;

    public Money(int amount){
        this.amount = amount;
    }

    public Money(String stringAmount){
        try {
            amount = Integer.parseInt(stringAmount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(MessageConstant.ERROR_VALID_NOT_NUMBER);
        }
    }

    public int amount(){
        return amount;
    }
}
