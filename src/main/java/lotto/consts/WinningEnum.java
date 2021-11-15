package lotto.consts;

import java.util.Arrays;

public enum WinningEnum {

    FIRST(2000000000, 6),
    // SECOND(),
    THIRD(1500000, 5),
    FOURTH(50000, 4),
    FIFTH(5000, 3),
    NONE(0, 0);

    private final int prize;
    private final int matched;

    WinningEnum(int prize, int matched) {
        this.prize = prize;
        this.matched = matched;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatched() {
        return matched;
    }

    public static WinningEnum findByMatched(int matched) {
        return Arrays.stream(values()).filter(winningEnum -> winningEnum.matched == matched).findAny().orElse(NONE);
    }
}
