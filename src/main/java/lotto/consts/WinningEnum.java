package lotto.consts;

import java.util.Arrays;

public enum WinningEnum {

    FIRST(2_000_000_000, 6, 0),
    SECOND(30_000_000, 5, 1),
    THIRD(1_500_000, 5, 0),
    FOURTH(50_000, 4, 0),
    FIFTH(5_000, 3, 0),
    NONE(0, 0, 0);

    private final int prize;
    private final int matched;
    private final int bonusNumberMatched;

    WinningEnum(int prize, int matched, int bonusNumberMatched) {
        this.prize = prize;
        this.matched = matched;
        this.bonusNumberMatched = bonusNumberMatched;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatched() {
        return matched;
    }

    public static WinningEnum findByMatched(int matched, int bonusNumberMatched) {
        return Arrays.stream(values()).filter(winningEnum -> winningEnum.matched == matched && winningEnum.bonusNumberMatched == bonusNumberMatched).findAny().orElse(NONE);
    }
}
