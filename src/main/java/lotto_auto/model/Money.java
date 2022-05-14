package lotto_auto.model;

import lotto_auto.exception.IllegalMoneyException;

public class Money {
    int money;
    public static final String NOT_NUMBER_MSG = "[ERROR] 구입금액은 숫자 이외의 문자가 올 수 없습니다.";

    public Money(String value) throws IllegalMoneyException {
        try {
            this.money = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw IllegalMoneyException.NOT_NUMBER_ERROR;
        }
    }

    public int getMoney() {
        return money;
    }
}
