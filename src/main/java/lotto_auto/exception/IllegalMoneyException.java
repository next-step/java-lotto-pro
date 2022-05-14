package lotto_auto.exception;

import lotto_auto.model.Money;

public class IllegalMoneyException extends IllegalArgumentException{
    public static final IllegalMoneyException NOT_NUMBER_ERROR = new IllegalMoneyException(Money.NOT_NUMBER_MSG);
    public IllegalMoneyException(final String errorMessage) { super(errorMessage);}
}
