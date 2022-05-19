package lotto.model;

import lotto.constant.ErrorMessage;

public class LottoSelfCount {

    private final int selfCount;

    public LottoSelfCount(String selfMoneyWord) {
        try {
            this.selfCount = Integer.parseInt(selfMoneyWord);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    public LottoSelfCount(int selfCount) {
        this.selfCount = selfCount;
    }

    public int getSelfCount() {
        return selfCount;
    }
}
