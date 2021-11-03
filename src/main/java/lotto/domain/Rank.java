package lotto.domain;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;

import java.util.Arrays;

public enum Rank {
    FIRST(6,2_000_000_000),
    THIRD(5,1_500_000),
    FOURTH(4,50_000),
    FIFTH(3,5_000),
    NOT_WIN_MONEY_MATCH_COUNT_TWO(2,0),
    NOT_WIN_MONEY_MATCH_COUNT_ONE(1,0),
    NOT_MATCH(0,0);

    private int count;
    private int winMoney;

    Rank(int count, int winMoney) {
        this.count = count;
        this.winMoney = winMoney;
    }

    public static Rank rank(int count){
        for (Rank rank : values()) {
            if(rank.count == count){
                return rank;
            }
        }
        throw new MyException(MyErrorCode.INVALID_LOTTO_WIN_COUNT);
    }
}
