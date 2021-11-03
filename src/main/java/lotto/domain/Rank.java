package lotto.domain;

import lotto.exception.MyErrorCode;
import lotto.exception.MyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NOT_WIN_MONEY_MATCH_COUNT_TWO(2, 0),
    NOT_WIN_MONEY_MATCH_COUNT_ONE(1, 0),
    NOT_MATCH(0, 0);

    private static final int START_VALID_LOTTO_MATCH_COUNT = 3;
    private static final int END_VALID_LOTTO_MATCH_COUNT = 6;
    private int count;
    private int winMoney;


    Rank(int count, int winMoney) {
        this.count = count;
        this.winMoney = winMoney;
    }

    public int count() {
        return this.count;
    }

    public int winMoney() {
        return this.winMoney;
    }

    public static Rank rank(int count) {
        return Arrays.stream(values())
                .filter(rank -> isMatch(count, rank))
                .findFirst()
                .orElseThrow(() -> new MyException(MyErrorCode.INVALID_LOTTO_WIN_COUNT));
    }

    public static List<Rank> getLottoResultRank() {
        List<Rank> lottoResultRanks = new ArrayList<>();
        for (int i = START_VALID_LOTTO_MATCH_COUNT; i <= END_VALID_LOTTO_MATCH_COUNT; i++) {
            lottoResultRanks.add(Rank.rank(i));
        }
        return lottoResultRanks;
    }

    private static boolean isMatch(int count, Rank rank) {
        return rank.count == count;
    }
}
