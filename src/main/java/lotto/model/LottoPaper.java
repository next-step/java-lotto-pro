package lotto.model;

import java.util.Objects;
import lotto.constant.ErrorMessage;

public class LottoPaper {

    private final int selfCount;

    public LottoPaper(int selfCount) {
        this.selfCount = selfCount;
    }

    public LottoPaper(String selfMoneyWord) {
        try {
            this.selfCount = Integer.parseInt(selfMoneyWord);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    public int getSelfCount() {
        return selfCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPaper that = (LottoPaper) o;
        return selfCount == that.selfCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(selfCount);
    }
}
